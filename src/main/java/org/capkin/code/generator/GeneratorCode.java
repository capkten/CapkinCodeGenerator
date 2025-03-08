package org.capkin.code.generator;

import cn.hutool.core.io.FileUtil;
import org.capkin.code.generator.backend.model.ProjectModel;

import java.io.File;

public class GeneratorCode {

    public boolean generateCode(ProjectModel projectModel, String filePath, String fileName, String packageName) {
        FileUtil.mkdir(filePath);
        String projectPath = filePath + File.separator + fileName;
        if (!FileUtil.exist(projectPath)) {
            FileUtil.mkdir(projectPath);
        }
        // 创建基本的Java项目路径
        String javaPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "java";
        String[] split = packageName.split(".");
        for (int i = 0; i < split.length; i++) {
            javaPath = javaPath + File.separator + split[i];
        }
        if (!FileUtil.exist(javaPath)) {
            FileUtil.mkdir(javaPath);
        }
        // 创建resource路径
        String resourcePath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        if (!FileUtil.exist(resourcePath)) {
            FileUtil.mkdir(resourcePath);
        }
        // 创建test路径
        String testPath = projectPath + File.separator + "src" + File.separator + "test" + File.separator + "java";
        if (!FileUtil.exist(testPath)) {
            FileUtil.mkdir(testPath);
        }
        // 构造controller
        String controllerPath = javaPath + File.separator + "controller";
        if (!FileUtil.exist(controllerPath)) {
            FileUtil.mkdir(controllerPath);
        }
            // 遍历controller创建文件
        for (String key : projectModel.getController().keySet()) {
            FileUtil.writeUtf8String(projectModel.getController().get(key), controllerPath + File.separator + key);
        }
        // 构造service
        String servicePath = javaPath + File.separator + "service";
        if (!FileUtil.exist(servicePath)) {
            FileUtil.mkdir(servicePath);
        }
        for (String key : projectModel.getService().keySet()) {
            FileUtil.writeUtf8String(projectModel.getService().get(key), servicePath + File.separator + key);
        }
            // serviceImpl
        String serviceImplPath = javaPath + File.separator + "service" + File.separator + "impl";
        if (!FileUtil.exist(serviceImplPath)) {
            FileUtil.mkdir(serviceImplPath);
        }
        for (String key : projectModel.getServiceImpl().keySet()) {
            FileUtil.writeUtf8String(projectModel.getServiceImpl().get(key), serviceImplPath + File.separator + key);
        }
        // 构造mapper
        String mapperPath = javaPath + File.separator + "mapper";
        if (!FileUtil.exist(mapperPath)) {
            FileUtil.mkdir(mapperPath);
        }
        for (String key : projectModel.getMapper().keySet()) {
            FileUtil.writeUtf8String(projectModel.getMapper().get(key), mapperPath + File.separator + key);
        }
            // 构造mapper xml
        String mapperXmlPath = resourcePath;
        for (String s : split) {
            mapperXmlPath = mapperXmlPath + File.separator + s;
            if (!FileUtil.exist(mapperXmlPath)) {
                FileUtil.mkdir(mapperXmlPath);
            }
        }
        mapperXmlPath = mapperXmlPath + File.separator + "mapper";
        if (!FileUtil.exist(mapperXmlPath)) {
            FileUtil.mkdir(mapperXmlPath);
        }
        for (String key : projectModel.getMapperXml().keySet()) {
            FileUtil.writeUtf8String(projectModel.getMapperXml().get(key), mapperXmlPath + File.separator + key + ".xml");
        }
        // 构造entity
        String entityPath = javaPath + File.separator + "entity";
        if (!FileUtil.exist(entityPath)) {
            FileUtil.mkdir(entityPath);
        }
        for (String key : projectModel.getEntity().keySet()) {
            FileUtil.writeUtf8String(projectModel.getEntity().get(key), entityPath + File.separator + key);
        }
        // 构造util
        String utilPath = javaPath + File.separator + "util";
        if (!FileUtil.exist(utilPath)) {
            FileUtil.mkdir(utilPath);
        }
        for (String key : projectModel.getUtil().keySet()) {
            FileUtil.writeUtf8String(projectModel.getUtil().get(key), utilPath + File.separator + key);
        }
        // 构造pom
        String pomPath = projectPath + File.separator + "pom.xml";
        FileUtil.writeUtf8String(projectModel.getPom(), pomPath);
        return true;
    }
}
