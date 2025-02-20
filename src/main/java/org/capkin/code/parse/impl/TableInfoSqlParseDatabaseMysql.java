package org.capkin.code.parse.impl;

import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.ForeignKeyIndex;
import net.sf.jsqlparser.statement.create.table.Index;
import org.capkin.code.parse.ITableInfoParseDatabase;
import org.capkin.code.parse.model.ColumnProperty;
import org.capkin.code.parse.model.ForeignKeyProperty;
import org.capkin.code.parse.model.TableInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableInfoSqlParseDatabaseMysql implements ITableInfoParseDatabase {

    private Logger log = Logger.getLogger(TableInfoSqlParseDatabaseMysql.class.getName());

    /**
     * 解析MYSQL语句，获取表信息
     * @param sql
     * @return
     */
    @Override
    public List<TableInfo> getTableInfo(String sql) {
        try {
            // 首先提取所有的create table语句
            List<String> createTablesSql = getCreateTables(sql);
            log.info("createTablesSql: " + createTablesSql);
            // 解析所有的create table语句
            List<TableInfo> tableInfoList = parseCreateTable(createTablesSql);
            log.info("parse result tableInfoList:" + tableInfoList);
            // 提取所有的更新语句，从而处理外键
            List<String> alterSql = getAlterSql(sql);
            log.info("alterSql: " + alterSql);
            // 解析所有的更新表语句
            tableInfoList = parseAlterTable(alterSql, tableInfoList);
            log.info("tableInfoList result: " + tableInfoList);
            return tableInfoList;
        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
    }

    private List<TableInfo> parseAlterTable(List<String> alterSqlList, List<TableInfo> tableInfoList) {
        for (String alterSql : alterSqlList) {
            try {
                alterSql = alterSql.replaceAll("on update restrict", "")
                        .replaceAll("on delete cascade", "")
                        .replaceAll("ON UPDATE RESTRICT", "")
                        .replaceAll("ON DELETE CASCADE", "")
                        .replaceAll("ON DELETE RESTRICT", "")
                        .replaceAll("on delete restrict", "");
                Alter alter = (Alter) CCJSqlParserUtil.parse(alterSql);
                String patternString = "\\bALTER\\s+TABLE\\s+\\w+\\s+ADD\\s+CONSTRAINT\\s+\\w+\\s+FOREIGN\\s+KEY\\s*\\(\\s*(\\w+)\\s*\\)\\s+REFERENCES\\s+(\\w+)\\s*\\(\\s*(\\w+)\\s*\\)";                Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(alterSql);
                if (matcher.find()) {
                    String fkColumn = matcher.group(1);  // cp_id
                    String refTable = matcher.group(2);  // comments_posts
                    String refColumn = matcher.group(3); // id
                    for (TableInfo tableInfo : tableInfoList) {
                        if (tableInfo.getTableCodeName().equals(alter.getTable().getName())) {
                            log.info("alterSql: " + alterSql);
                            if (tableInfo.getForeignKeyPropertyList() == null) {
                                tableInfo.setForeignKeyPropertyList(new ArrayList<>());
                            }
                            ForeignKeyProperty foreignKeyProperty = new ForeignKeyProperty();
                            foreignKeyProperty.setForeignTable(refTable);
                            foreignKeyProperty.setThisColumn(fkColumn);
                            foreignKeyProperty.setForeignColumn(refColumn);
                            tableInfo.getForeignKeyPropertyList().add(foreignKeyProperty);
                        }
                    }
                } else {
                    System.out.println("未匹配到外键信息");
                }
            } catch (JSQLParserException e) {
                throw new RuntimeException(e);
            }
        }
        return tableInfoList;
    }

    private List<String> getAlterSql(String sql) {
        List<String> alterSql = new ArrayList<>();
        String[] split = sql.split(";");
        for (String s : split) {
            String upperCase = s.toUpperCase();
            int updateStart = upperCase.indexOf("ALTER TABLE");
            if (updateStart != -1) {
                String updateSqlStr = s.substring(updateStart);
                alterSql.add(updateSqlStr);
            }
        }
        return alterSql;
    }

    private List<String> getCreateTables(String sql) throws JSQLParserException {
        List<String> createTableSql = new ArrayList<>();
        String[] splitStr = sql.split(";");
        for (String s : splitStr) {
            String upperCase = s.toUpperCase();
            int createTableStart = upperCase.indexOf("CREATE TABLE");
            if (createTableStart != -1) {
                String createTableSqlStr = s.substring(createTableStart);
//                log.info("createTableSqlStr: " + createTableSqlStr);
                createTableSql.add(createTableSqlStr);
            }
        }
        return createTableSql;
    }

    public List<TableInfo> parseCreateTable(List<String> createTableSqlList) {
        List<TableInfo> tableInfoList = new ArrayList<>();
        for (String createTableSql : createTableSqlList) {
            try {
                CreateTable parse = (CreateTable) CCJSqlParserUtil.parse(createTableSql);
                Table table = parse.getTable();
                TableInfo tableInfo = new TableInfo();
                tableInfoList.add(tableInfo);
                tableInfo.setTableCodeName(table.getName());
                String tableName = StrUtil.toCamelCase(table.getName());
                if (!tableName.isEmpty()) {
                    tableName = Character.toUpperCase(tableName.charAt(0)) + tableName.substring(1);
                }
                tableInfo.setTableName(tableName);
                List<ColumnProperty> columnPropertyList = new ArrayList<>();
                tableInfo.setColumns(columnPropertyList);
                List<ColumnDefinition> columnDefinitions = parse.getColumnDefinitions();
                for (ColumnDefinition columnDefinition : columnDefinitions) {
                    ColumnProperty columnProperty = new ColumnProperty();
                    columnPropertyList.add(columnProperty);
                    columnProperty.setCodeName(columnDefinition.getColumnName());
                    columnProperty.setPropertyName(StrUtil.toCamelCase(columnDefinition.getColumnName()));
                    columnProperty.setPropertyType(columnDefinition.getColDataType().getDataType());
                    List<String> columnSpecs = columnDefinition.getColumnSpecs();
                    for (int i = 0; i < columnSpecs.size(); i++) {
                        String columnSpec = columnSpecs.get(i);
                        if (columnSpec.equals("not") || columnSpec.equals("NOT")) {
                            columnProperty.setNullable(false);
                            i++;
                        } else if (columnSpec.equals("null") || columnSpec.equals("NULL")) {
                            columnProperty.setNullable(true);
                        } else if (columnSpec.equals("auto_increment") || columnSpec.equals("AUTO_INCREMENT")) {
                            columnProperty.setDefaultValue("auto_increment");
                        } else if (columnSpec.equals("default")) {
                            columnProperty.setDefaultValue(columnSpecs.get(i + 1));
                            i++;
                        } else if(columnSpec.equals("comment")) {
                            columnProperty.setColumComment(columnSpecs.get(i + 1));
                            i++;
                        }
                    }
                }
                List<Index> indexes = parse.getIndexes();
                for (Index index : indexes) {
                    if (index.getType().equals("PRIMARY KEY") || index.getType().equals("primary key")) {
                        for (ColumnProperty columnProperty : columnPropertyList) {
                            if (columnProperty.getCodeName().equals(index.getColumns().getFirst().getColumnName())) {
                                columnProperty.setPrimaryKey(true);
                            }
                        }
                    }else if (index instanceof ForeignKeyIndex) {
                        ForeignKeyIndex foreignKeyIndex = (ForeignKeyIndex) index;
                        if (tableInfo.getForeignKeyPropertyList() == null) {
                            tableInfo.setForeignKeyPropertyList(new ArrayList<>());
                        }
                        ForeignKeyProperty foreignKeyProperty = new ForeignKeyProperty();
                        foreignKeyProperty.setForeignTable(foreignKeyIndex.getTable().getName());
                        foreignKeyProperty.setThisColumn(foreignKeyIndex.getColumns().getFirst().getColumnName());
                        foreignKeyProperty.setForeignColumn(foreignKeyIndex.getReferencedColumnNames().getFirst());
                        tableInfo.getForeignKeyPropertyList().add(foreignKeyProperty);
                    }
                }
            } catch (JSQLParserException e) {
                log.info("createTableSql parse error: " + createTableSql);
            }
        }
        return tableInfoList;
    }
}
