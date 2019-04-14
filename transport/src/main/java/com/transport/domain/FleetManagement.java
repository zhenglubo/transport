package com.transport.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 车队管理信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="FleetManagement对象", description="车队管理信息")
public class FleetManagement extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "起点")
    private String startAddress;

    @ApiModelProperty(value = "终点")
    private String destinitionAddress;

    @ApiModelProperty(value = "牌照")
    private String license;

    @ApiModelProperty(value = "车长(米)")
    private String length;

    @ApiModelProperty(value = "主驾驶姓名")
    private String mainDriverName;

    @ApiModelProperty(value = "主驾驶电话")
    private String mainDriverPhone;

    @ApiModelProperty(value = "主驾驶驾照")
    private String mainDriverLicense;

    @ApiModelProperty(value = "副驾驶姓名")
    private String secondDriverPhone;

    @ApiModelProperty(value = "副司机驾照")
    private String secondDriverLicense;

    @ApiModelProperty(value = "载重(单位:吨)")
    private String carryingCapacity;

    @ApiModelProperty(value = "当前是否可用(0可用 1不可用)")
    private Boolean status;

    @ApiModelProperty(value = "是否验证信息(0已验证 1未验证)")
    private Boolean isValid;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangCreatetTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangLastTime;


}
