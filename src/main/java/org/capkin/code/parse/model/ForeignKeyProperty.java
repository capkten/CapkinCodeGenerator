package org.capkin.code.parse.model;

public class ForeignKeyProperty {

    private String foreignName;

    private String foreignTable;

    private String foreignColumn;

    private String thisColumn;

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getForeignTable() {
        return foreignTable;
    }

    public void setForeignTable(String foreignTable) {
        this.foreignTable = foreignTable;
    }

    public String getForeignColumn() {
        return foreignColumn;
    }

    public void setForeignColumn(String foreignColumn) {
        this.foreignColumn = foreignColumn;
    }

    public String getThisColumn() {
        return thisColumn;
    }

    public void setThisColumn(String thisColumn) {
        this.thisColumn = thisColumn;
    }

    @Override
    public String toString() {
        return "ForeignKeyProperty{" +
                "foreignName='" + foreignName + '\'' +
                ", foreignTable='" + foreignTable + '\'' +
                ", foreignColumn='" + foreignColumn + '\'' +
                ", thisColumn='" + thisColumn + '\'' +
                '}';
    }
}
