package org.capkin.code.parse.model;

import java.util.List;

public class TableInfo {

    List<ColumnProperty> columns;

    String tableName;

    private List<ForeignKeyProperty> foreignKeyPropertyList;

    public List<ColumnProperty> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnProperty> columns) {
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ForeignKeyProperty> getForeignKeyPropertyList() {
        return foreignKeyPropertyList;
    }

    public void setForeignKeyPropertyList(List<ForeignKeyProperty> foreignKeyPropertyList) {
        this.foreignKeyPropertyList = foreignKeyPropertyList;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "columns=" + columns +
                ", tableName='" + tableName + '\'' +
                ", foreignKeyPropertyList=" + foreignKeyPropertyList +
                '}';
    }
}
