package org.capkin.code.parse.factory;

/**
 * 抽象工厂，提供两种工厂，一种是数据库工厂，一种是SQL工厂
 * @author capkin
 * @date 2025/02/20
 * @version 1.0.0
 */
public interface ITableInfoParseFactory {

    public TableInfoParseDatabaseFactory getTableInfoParseDatabaseFactory();

    public TableInfoParseSqlFactory getTableInfoParseSqlFactory();
}
