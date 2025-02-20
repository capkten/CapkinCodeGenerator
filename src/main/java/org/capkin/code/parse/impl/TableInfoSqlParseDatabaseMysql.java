package org.capkin.code.parse.impl;

import cn.hutool.core.util.StrUtil;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.Index;
import org.capkin.code.parse.ITableInfoParseDatabase;
import org.capkin.code.parse.model.ColumnProperty;
import org.capkin.code.parse.model.TableInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TableInfoSqlParseDatabaseMysql implements ITableInfoParseDatabase {

    private Logger log = Logger.getLogger(TableInfoSqlParseDatabaseMysql.class.getName());

    /**
     * 解析MYSQL语句，获取表信息
     * @param sql
     * @return
     */
    @Override
    public List<TableInfo> getTableInfo(String sql) {
        // 首先提取所有的create table语句
        try {
            List<String> createTablesSql = getCreateTables(sql);
            log.info("createTablesSql: " + createTablesSql);
            List<TableInfo> tableInfoList = parseCreateTable(createTablesSql);
            log.info("parse result tableInfoList:" + tableInfoList);
        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
        return List.of();
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
                tableInfo.setTableName(table.getName());
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
                    }
                }
            } catch (JSQLParserException e) {
                log.info("createTableSql parse error: " + createTableSql);
            }
        }
        return tableInfoList;
    }



}
