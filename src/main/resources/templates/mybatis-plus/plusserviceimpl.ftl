package ${basePackage}.service.impl;

import ${basePackage}.entity.${tableName};
import ${basePackage}.mapper.${tableName}Mapper;
import ${basePackage}.service.I${tableName}Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>
* 服务实现类
* </p>
*
* @author ${author}
* @since ${.now?string("yyyy-MM-dd")}
*/
@Service
public class ${tableName}ServiceImpl extends ServiceImpl<${tableName}Mapper, ${tableName}> implements I${tableName}Service {

    @Autowired
    private ${tableName}Mapper ${tableName?uncap_first}Mapper;

    @Override
    public List<${tableName}> getAll() {
        return ${tableName?uncap_first}Mapper.selectList(new QueryWrapper<${tableName}>());
    }

    @Override
    public Page<${tableName}> getAllPage(int page, int pageSize) {
        Page<${tableName}> ${tableName?uncap_first}Page = new Page<>();
        ${tableName?uncap_first}Page.setCurrent(page);
        ${tableName?uncap_first}Page.setSize(pageSize);
        return ${tableName?uncap_first}Mapper.selectPage(${tableName?uncap_first}Page, new QueryWrapper<${tableName}>());
    }

    @Override
    public boolean deleteByIds(List<${primaryType}> ${primaryName}s) {
        int i = ${tableName?uncap_first}Mapper.deleteByIds(${primaryName}s);
        return i > 0;
    }

    @Override
    public boolean add(${tableName} ${tableName?uncap_first}) {
        int i = ${tableName?uncap_first}Mapper.insert(${tableName?uncap_first});
        return i > 0;
    }

    @Override
    public boolean change(${tableName} ${tableName?uncap_first}) {
        int i = ${tableName?uncap_first}Mapper.updateById(${tableName?uncap_first});
        return i > 0;
    }

    @Override
    public List<${tableName}> getAllBySelect(Map<String, String> searchParams) {
        Map<String, Object> objectMap = new HashMap<>();
        searchParams.forEach((k, v) -> objectMap.put(k, v));
        return ${tableName?uncap_first}Mapper.selectByMap(objectMap);
    }
}