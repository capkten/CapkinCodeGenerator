package org.capkin.code.parse.factory;

import cn.hutool.core.lang.Singleton;
import org.capkin.code.parse.ITableInfoParseDatabase;
import org.capkin.code.parse.impl.TableInfoSqlParseDatabaseMysql;
import org.capkin.code.parse.impl.TableInfoSqlParseDatabaseOracle;

public class TableInfoParseSqlFactory {

    public static final int MYSQL = 1;

    public static final int ORACLE = 2;

    public ITableInfoParseDatabase getTableInfoParse(Integer type) {
        return switch (type) {
            case MYSQL: yield Singleton.get(TableInfoSqlParseDatabaseMysql.class);
            case ORACLE: yield Singleton.get(TableInfoSqlParseDatabaseOracle.class);
            default:throw new RuntimeException("不支持的类型");
        };
    }
}
