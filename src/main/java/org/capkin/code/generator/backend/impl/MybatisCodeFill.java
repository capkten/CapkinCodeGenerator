package org.capkin.code.generator.backend.impl;

import org.capkin.code.generator.backend.model.ProjectModel;
import org.capkin.code.parse.model.TableInfo;

import java.util.List;
import java.util.Map;

public class MybatisCodeFill extends BackendCodeFill{

    @Override
    public ProjectModel fillCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return super.fillCode(tableInfoList, packageName, author, isSwagger);
    }

    @Override
    public Map<String, String> fillControllerCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fillServiceCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fillServiceImplCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fileMapperCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fileMapperXmlCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public String fillPomCode(String packageName, String author, Boolean isSwagger) {
        return "";
    }

    @Override
    public Map<String, String> fileUtilCode(String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fillEntityCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fillConfigCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }
}
