package org.capkin.code.generator.backend.model;

import java.util.Map;

public class ProjectModel {

    private Map<String, String> controller;

    private Map<String, String> service;

    private Map<String, String> serviceImpl;

    private Map<String, String> mapper;

    private Map<String, String> mapperXml;

    private Map<String, String> entity;

    private Map<String, String> util;

    private Map<String, String> config;

    private String pom;

    public Map<String, String> getController() {
        return controller;
    }

    public void setController(Map<String, String> controller) {
        this.controller = controller;
    }

    public Map<String, String> getService() {
        return service;
    }

    public void setService(Map<String, String> service) {
        this.service = service;
    }

    public Map<String, String> getMapper() {
        return mapper;
    }

    public void setMapper(Map<String, String> mapper) {
        this.mapper = mapper;
    }

    public Map<String, String> getEntity() {
        return entity;
    }

    public void setEntity(Map<String, String> entity) {
        this.entity = entity;
    }

    public Map<String, String> getUtil() {
        return util;
    }

    public void setUtil(Map<String, String> util) {
        this.util = util;
    }

    public String getPom() {
        return pom;
    }

    public void setPom(String pom) {
        this.pom = pom;
    }

    public Map<String, String> getServiceImpl() {
        return serviceImpl;
    }

    public void setServiceImpl(Map<String, String> serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public Map<String, String> getMapperXml() {
        return mapperXml;
    }

    public void setMapperXml(Map<String, String> mapperXml) {
        this.mapperXml = mapperXml;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "controller=" + controller +
                ", service=" + service +
                ", serviceImpl=" + serviceImpl +
                ", mapper=" + mapper +
                ", mapperXml=" + mapperXml +
                ", entity=" + entity +
                ", util=" + util +
                ", config=" + config +
                ", pom='" + pom + '\'' +
                '}';
    }
}
