package org.capkin.code.generator.backend.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.capkin.code.parse.model.ColumnProperty;
import org.capkin.code.parse.model.TableInfo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MybatisPlusCodeFill extends BackendCodeFill {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public Map<String, String> fillControllerCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String controllerPath = "classpath:templates/mybatis-plus/pluscontroller.ftl";
        Map<String, String> controllerCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("pluscontroller.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = tableInfo.getTableName() + "Controller.java";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    controllerCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return controllerCode;
    }

    @Override
    public Map<String, String> fillServiceCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String controllerPath = "classpath:templates/mybatis-plus/plusservice.ftl";
        Map<String, String> controllerCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("plusservice.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = "I" + tableInfo.getTableName() + "Service.java";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    controllerCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return controllerCode;
    }

    @Override
    public Map<String, String> fillServiceImplCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String serviceImplPath = "classpath:templates/mybatis-plus/plusserviceimpl.ftl";
        Map<String, String> serviceImplCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("plusserviceimpl.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = tableInfo.getTableName() + "ServiceImpl.java";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    serviceImplCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serviceImplCode;
    }

    @Override
    public Map<String, String> fileMapperCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String mapperPath = "classpath:templates/mybatis-plus/plusmapper.ftl";
        Map<String, String> plusCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("plusmapper.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = tableInfo.getTableName() + "Mapper.java";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    plusCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return plusCode;
    }

    @Override
    public Map<String, String> fileMapperXmlCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String plusMapperXmlPath = "classpath:templates/mybatis-plus/plusserviceimpl.ftl";
        Map<String, String> plusMapperXmlCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("plusserviceimpl.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = tableInfo.getTableName() + "Mapper.xml";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    plusMapperXmlCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return plusMapperXmlCode;
    }

    @Override
    public String fillPomCode(String packageName, String author, Boolean isSwagger) {
        String plusMapperXmlPath = "classpath:templates/mybatis-plus/plusserviceimpl.ftl";
        String pomCode = "";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("pom.ftl");
            Map<String, Object> dataModel = new HashMap<>();
            int i = packageName.lastIndexOf('.');
            String groupId = packageName.substring(0, i);
            String artifactId = packageName.substring(i + 1);
            String description = artifactId;
            String name = artifactId;
            dataModel.put("groupId", groupId);
            dataModel.put("artifactId", artifactId);
            dataModel.put("description", description);
            dataModel.put("name", name);
            StringWriter writer = new StringWriter();
            try {
                template.process(dataModel, writer);
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
            pomCode = writer.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pomCode;
    }

    @Override
    public Map<String, String> fileUtilCode(String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }

    @Override
    public Map<String, String> fillEntityCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        String plusEntityPath = "classpath:templates/mybatis-plus/plusentity.ftl";
        Map<String, String> entityCode = new HashMap<>();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/mybatis-plus");
        try {
            Template template = cfg.getTemplate("plusentity.ftl");
            for (TableInfo tableInfo : tableInfoList) {
                String fileName = tableInfo.getTableName() + ".java";
                // 设置模板变量
                Map<String, Object> dataModel = new HashMap<>();
                dataModel.put("basePackage", packageName);
                dataModel.put("tableName", tableInfo.getTableName());
                dataModel.put("tableCodeName", tableInfo.getTableCodeName());
                dataModel.put("author", author);
                dataModel.put("isSwagger", isSwagger);
                dataModel.put("databaseType", "mysql");
                dataModel.put("tableInfo", tableInfo);
                String primaryType = null;
                String primaryName = null;
                for (ColumnProperty column : tableInfo.getColumns()) {
                    if (column.isPrimaryKey()) {
                        primaryType = column.getPropertyType();
                        primaryName = column.getPropertyName();
                    }
                }
                dataModel.put("primaryType", primaryType);
                dataModel.put("primaryName", primaryName);
                try (StringWriter writer = new StringWriter()) {
                    template.process(dataModel, writer);
                    String string = writer.toString();
                    log.info(fileName + ":\n" + writer.toString());
                    entityCode.put(fileName, writer.toString());
                } catch (TemplateException e) {
                    throw new RuntimeException("Template processing failed", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entityCode;
    }

    @Override
    public Map<String, String> fillConfigCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger) {
        return Map.of();
    }
}