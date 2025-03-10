package org.capkin.code;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Singleton;
import org.capkin.code.generator.GeneratorCode;
import org.capkin.code.generator.backend.BackendCodeFactory;
import org.capkin.code.generator.backend.IBackendCodeFill;
import org.capkin.code.generator.backend.model.ProjectModel;
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
        // 根据tableInfo的内容填充模板，存在多种模板
        BackendCodeFactory backendCodeFactory = Singleton.get(BackendCodeFactory.class);
        IBackendCodeFill mysql = backendCodeFactory.getBackendCodeFill(2, "mysql");
        ProjectModel projectModel = mysql.fillCode(tableInfo, "org.hzy.soccer", "capkin", true);
        GeneratorCode generatorCode = Singleton.get(GeneratorCode.class);
        generatorCode.generateCode(projectModel, "E:\\code\\generator", "soccer_backend", "org.hzy.soccer");
    }
}
