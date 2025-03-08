package ${basePackage}.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
   <#if isSwagger>
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
</#if>
import ${basePackage}.entity.${tableName};
import ${basePackage}.entity.dto.ResponseDto;
import ${basePackage}.service.I${tableName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
* <p>
*  前端控制器
* </p>
*
* @author ${author}
* @since ${.now?string("yyyy-MM-dd")}
*/
<#if isSwagger>
@Tag(name = "${tableName}Controller", description = "${tableName}")
</#if>
@RestController
@RequestMapping("/api/${tableCodeName}")
public class ${tableName}Controller {

    @Autowired
    private I${tableName}Service ${tableName?uncap_first}Service;

    @GetMapping("/all")
    <#if isSwagger>
    @Operation(summary = "查询全部", description = "查询全部")
    @Parameters({
    })
    </#if>
    public ResponseDto getAll() {
        List<${tableName}> ${tableName?uncap_first}List = ${tableName?uncap_first}Service.getAll();
        return ResponseDto.success("查询成功", ${tableName?uncap_first}List);
    }

    @GetMapping("/all/page")
    <#if isSwagger>
    @Operation(summary = "分页查询", description = "分页查询")
    @Parameters({
        @Parameter(name = "page", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true)
    })
    </#if>
    public ResponseDto getAllPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                  @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<${tableName}> ${tableName?uncap_first}List = ${tableName?uncap_first}Service.getAllPage(page, pageSize);
        return ResponseDto.success("查询成功", ${tableName?uncap_first}List);
    }

    @GetMapping("/all/select")
    <#if isSwagger>
    @Operation(summary = "根据条件查询", description = "根据条件查询")
    @Parameters({
        @Parameter(name = "searchParams", description = "查询条件", required = true)
    })
    </#if>
    public ResponseDto getAllPageSelect(@RequestBody Map<String, String> searchParams) {
        List<${tableName}> ${tableName?uncap_first}List = ${tableName?uncap_first}Service.getAllBySelect(searchParams);
        return ResponseDto.success("查询成功", ${tableName?uncap_first}List);
    }

    @GetMapping("/delete")
    <#if isSwagger>
    @Operation(summary = "删除", description = "删除")
    @Parameters({
        @Parameter(name = "ids", description = "id数组", required = true)
    })
    </#if>
    public ResponseDto delete(@RequestParam(name = "${primaryName}s") List<${primaryType}> ${primaryName}s) {
        boolean result = ${tableName?uncap_first}Service.deleteByIds(${primaryName}s);
        if (result) {
            return ResponseDto.success("删除成功", null);
        } else {
            return ResponseDto.fail("删除失败");
        }
    }

    @PostMapping("/add")
    <#if isSwagger>
    @Operation(summary = "添加", description = "添加")
    @Parameters({
        @Parameter(name = "admin", description = "管理员", required = true)
    })
    </#if>
    public ResponseDto add(@RequestBody ${tableName} ${tableName?uncap_first}) {
        boolean result = ${tableName?uncap_first}Service.add(${tableName?uncap_first});
        if (result) {
            return ResponseDto.success("添加成功", null);
        } else {
            return ResponseDto.fail("添加失败");
        }
    }

    @PostMapping("/update")
    <#if isSwagger>
    @Operation(summary = "修改", description = "修改")
    @Parameters({
        @Parameter(name = "admin", description = "管理员", required = true)
    })
    </#if>
    public ResponseDto update(@RequestBody ${tableName} ${tableName?uncap_first}) {
        boolean result = ${tableName?uncap_first}Service.change(${tableName?uncap_first});
        if (result) {
            return ResponseDto.success("修改成功", null);
        } else {
            return ResponseDto.fail("修改失败");
        }
    }

<#if isSwagger>
}
</#if>