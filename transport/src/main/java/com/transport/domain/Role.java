package com.transport.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Role对象", description="角色信息")
public class Role extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色对应权限ID")
    private Long permissionId;

    @ApiModelProperty(value = "是否有效(0无效 1有效)")
    private Boolean isValid;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
