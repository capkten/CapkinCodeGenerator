package org.capkin.code;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import org.capkin.code.parse.ITableInfoParseDatabase;
import org.capkin.code.parse.factory.ITableInfoParseFactory;
import org.capkin.code.parse.factory.TableInfoParseSqlFactory;
import org.capkin.code.parse.factory.impl.TableInfoParseFactoryImpl;
import org.capkin.code.parse.model.TableInfo;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("databasesql.sql");
        File file = resource.getFile();
        String sql = FileUtil.readString(file, "utf-8");
        ITableInfoParseFactory tableInfoParseFactory = ProxyUtil.proxy(new TableInfoParseFactoryImpl(), TimeIntervalAspect.class);
        TableInfoParseSqlFactory tableInfoParseSqlFactory = tableInfoParseFactory.getTableInfoParseSqlFactory();
        ITableInfoParseDatabase tableInfoParse = tableInfoParseSqlFactory.getTableInfoParse(TableInfoParseSqlFactory.MYSQL);
        List<TableInfo> tableInfo = tableInfoParse.getTableInfo(sql);
    }
}
