package ${basePackage}.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
<#if isSwagger>
import io.swagger.v3.oas.annotations.media.Schema;
</#if>

import java.io.Serializable;

<#if databaseType == "mysql">
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
</#if>
<#if databaseType == "oracle">
import java.math.BigDecimal;
import java.time.LocalDateTime;
</#if>

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since ${.now?string("yyyy-MM-dd")}
 */
@Getter
@Setter
@ToString
<#if isSwagger>
@Schema(name = "${tableName}", description = "${tableCodeName}")
</#if>
public class ${tableName} implements Serializable {

    private static final long serialVersionUID = 1L;

<#list tableInfo.columns as column>
    <#if column.primaryKey>
    @TableId(value = "${column.codeName}", type = IdType.AUTO)
    </#if>
    @TableField(value = "${column.codeName}")
    private ${column.propertyType} ${column.propertyName};

</#list>
}