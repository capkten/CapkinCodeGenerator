package org.capkin.code.parse.factory.impl;

import cn.hutool.core.lang.Singleton;
import org.capkin.code.parse.factory.ITableInfoParseFactory;
import org.capkin.code.parse.factory.TableInfoParseDatabaseFactory;
import org.capkin.code.parse.factory.TableInfoParseSqlFactory;

/**
 * 抽象工厂的实现类，提供两种工厂，一种是数据库工厂，一种是SQL工厂
 * 这里通过hutool来确保单例
 */
public class TableInfoParseFactoryImpl implements ITableInfoParseFactory {

    @Override
    public TableInfoParseDatabaseFactory getTableInfoParseDatabaseFactory() {
        return Singleton.get(TableInfoParseDatabaseFactory.class);
    }

    @Override
    public TableInfoParseSqlFactory getTableInfoParseSqlFactory() {
        return Singleton.get(TableInfoParseSqlFactory.class);
    }
}
