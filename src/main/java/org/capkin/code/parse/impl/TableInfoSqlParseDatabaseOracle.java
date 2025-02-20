package org.capkin.code.parse.impl;

import org.capkin.code.parse.ITableInfoParseDatabase;
import org.capkin.code.parse.model.TableInfo;

import java.util.List;

public class TableInfoSqlParseDatabaseOracle implements ITableInfoParseDatabase {

    @Override
    public List<TableInfo> getTableInfo(String sql) {
        return List.of();
    }
}
