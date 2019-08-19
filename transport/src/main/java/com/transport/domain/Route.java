package com.transport.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 物流线路信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Route对象", description="物流线路信息")
public class Route extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "出发省份")
    private String startProvince;

    @ApiModelProperty(value = "出发城市")
    private String startCity;

    @ApiModelProperty(value = "出发县(区)")
    private String startCounty;

    @ApiModelProperty(value = "出发乡镇(详细地址)")
    private String startTown;

    @ApiModelProperty(value = "到达省份")
    private String destinationProvince;

    @ApiModelProperty(value = "到达城市")
    private String destinationCity;

    @ApiModelProperty(value = "到达县(区)")
    private String destinationCounty;

    @ApiModelProperty(value = "到达乡镇(详细地址)")
    private String destinationTown;

    @ApiModelProperty(value = "开始发货日期")
    private LocalDate beginSenderDate;

    @ApiModelProperty(value = "截止收货日期")
    private LocalDate endSenderDate;

    @ApiModelProperty(value = "假期停运说明")
    private String holidayDescription;

    @ApiModelProperty(value = "发货周期(1 每天发一次 2 隔天发一次 3每隔两天发一次 4每隔三天发一次 ...)")
    private Integer sendPeriod;

    @ApiModelProperty(value = "预计在途时间")
    private Integer expectedDate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
