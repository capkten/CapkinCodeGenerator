package org.capkin.code.generator.backend.utils;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.logging.Logger;

public class TypeMappingUtil {

    private Logger log = Logger.getLogger(TypeMappingUtil.class.getName());

    private Map<String, String> mysqlTypeMapping;

    private Map<String, String> mysqlSpecialTypeMapping;

    private Map<String, String> oracleTypeMapping;

    private void load() {
        ClassPathResource resource = new ClassPathResource("type_mapping.json");
        File file = resource.getFile();
        JSONObject jsonObject = JSONUtil.readJSONObject(file, Charset.forName("utf-8"));
        Map typeMappings = jsonObject.get("typeMappings", Map.class);
        Map<String, Object> mysql = (Map<String, Object>) typeMappings.get("mysql");
        this.mysqlTypeMapping = (Map<String, String>) mysql.get("baseTypes");
        this.mysqlSpecialTypeMapping = (Map<String, String>) mysql.get("specialCases");
        log.info("1");
    }

    public String getTypeMapping(String type, String database) {
        type = type.toUpperCase();
        if ("mysql".equals(database)) {
            if (mysqlTypeMapping.containsKey(type)) {
                return mysqlTypeMapping.get(type);
            } else if (mysqlSpecialTypeMapping.containsKey(type)) {
                // 使用正则匹配
                for (Map.Entry<String, String> entry : mysqlSpecialTypeMapping.entrySet()) {
                    if (type.matches(entry.getKey())) {
                        return entry.getValue();
                    }
                }
            }
        } else if ("oracle".equals(database)) {
            if (oracleTypeMapping.containsKey(type)) {
                return oracleTypeMapping.get(type);
            }
        }
        return "Object";
    }

    public TypeMappingUtil() {
        load();
    }

}
