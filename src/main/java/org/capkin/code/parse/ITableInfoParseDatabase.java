package org.capkin.code.parse;

import org.capkin.code.parse.model.TableInfo;

import java.util.List;

public interface ITableInfoParseDatabase {

    public List<TableInfo> getTableInfo(String sql);
}
