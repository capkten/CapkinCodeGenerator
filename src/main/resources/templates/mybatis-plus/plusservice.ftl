package ${basePackage}.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basePackage}.entity.${tableName};
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* <p>
*  服务类
* </p>
*
* @author ${author}
* @since ${.now?string("yyyy-MM-dd")}
*/

public interface I${tableName}Service extends IService<${tableName}> {

    List<${tableName}> getAll();

    Page<${tableName}> getAllPage(int page, int pageSize);

    boolean deleteByIds(List<${primaryType}> ${primaryName}s);

    boolean add(${tableName} ${tableName?uncap_first});

    boolean change(${tableName} ${tableName?uncap_first});

    List<${tableName}> getAllBySelect(Map<String, String> searchParams);
}