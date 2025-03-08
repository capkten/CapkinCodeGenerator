package org.capkin.code.parse.model;

public class ColumnProperty {

    private String propertyName;

    private boolean isPrimaryKey = false;

    private boolean isNullable = false;

    private String codeName;

    private String propertyType;

    private String propertyCodeType;

    private String defaultValue;

    private String columComment;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public void setNullable(boolean nullable) {
        isNullable = nullable;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getColumComment() {
        return columComment;
    }

    public void setColumComment(String columComment) {
        this.columComment = columComment;
    }

    public String getPropertyCodeType() {
        return propertyCodeType;
    }

    public void setPropertyCodeType(String propertyCodeType) {
        this.propertyCodeType = propertyCodeType;
    }

    @Override
    public String toString() {
        return "ColumnProperty{" +
                "propertyName='" + propertyName + '\'' +
                ", isPrimaryKey=" + isPrimaryKey +
                ", isNullable=" + isNullable +
                ", codeName='" + codeName + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", propertyCodeType='" + propertyCodeType + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", columComment='" + columComment + '\'' +
                '}';
    }
}
