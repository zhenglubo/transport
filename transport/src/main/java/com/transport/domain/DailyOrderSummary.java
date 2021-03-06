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
 * 每日订单数量统计信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DailyOrderSummary对象", description="每日订单数量统计信息")
public class DailyOrderSummary extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "订单总数")
    private Integer totalOrder;

    @ApiModelProperty(value = "正在处理订单(已提货未结算)")
    private Integer processingNumber;

    @ApiModelProperty(value = "已完成订单")
    private Integer processedNumber;

    @ApiModelProperty(value = "未处理订单(未发货或在途)")
    private Integer unprocessNumber;

    @ApiModelProperty(value = "退货订单数")
    private Integer returnNumber;

    @ApiModelProperty(value = "发货省份数量")
    private Integer provinceNumber;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "发货城市数量")
    private Integer cityNumber;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "损坏订单数")
    private Integer damagedNumber;

    @ApiModelProperty(value = "统计日期")
    private LocalDate summaryDate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
