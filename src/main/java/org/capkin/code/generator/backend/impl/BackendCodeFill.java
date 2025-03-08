package org.capkin.code.generator.backend.impl;

import org.capkin.code.generator.backend.IBackendCodeFill;
import org.capkin.code.generator.backend.model.ProjectModel;
import org.capkin.code.parse.model.TableInfo;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public abstract class BackendCodeFill implements IBackendCodeFill {

    private final Logger log = Logger.getLogger(BackendCodeFill.class.getName());

    @Override
    public ProjectModel fillCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        ProjectModel projectModel = new ProjectModel();
        Map<String, String> controllerCode = fillControllerCode(tableInfoList, packageName, author, isSwagger);
        log.info("controller:" + controllerCode);
        projectModel.setController(controllerCode);
        Map<String, String> serviceCode = fillServiceCode(tableInfoList, packageName, author, isSwagger);
        log.info("service:" + serviceCode);
        projectModel.setService(serviceCode);
        Map<String, String> serviceImplCode = fillServiceImplCode(tableInfoList, packageName, author, isSwagger);
        log.info("serviceImpl:" + serviceImplCode);
        projectModel.setServiceImpl(serviceImplCode);
        Map<String, String> mapperCode = fileMapperCode(tableInfoList, packageName, author, isSwagger);
        log.info("mapper:" + mapperCode);
        projectModel.setMapper(mapperCode);
        Map<String, String> mapperXmlCode = fileMapperXmlCode(tableInfoList, packageName, author, isSwagger);
        log.info("mapperXml:" + mapperXmlCode);
        projectModel.setMapperXml(mapperCode);
        String pomCode = fillPomCode(packageName, author, isSwagger);
        log.info("pom:" + pomCode);
        projectModel.setPom(pomCode);
        Map<String, String> utilCode = fileUtilCode(packageName, author, isSwagger);
        log.info("utils:" + utilCode);
        projectModel.setUtil(utilCode);
        Map<String, String> entityCode = fillEntityCode(tableInfoList, packageName, author, isSwagger);
        log.info("entity:" + entityCode);
        projectModel.setEntity(entityCode);
        Map<String, String> configCode = fillConfigCode(tableInfoList, packageName, author, isSwagger);
        log.info("config:" + configCode);
        projectModel.setConfig(controllerCode);
        return projectModel;
    }

    public abstract Map<String, String> fillControllerCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fillServiceCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fillServiceImplCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fileMapperCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fileMapperXmlCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract String fillPomCode(String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fileUtilCode(String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fillEntityCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

    public abstract Map<String, String> fillConfigCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);
}
