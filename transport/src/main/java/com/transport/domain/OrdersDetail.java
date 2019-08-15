package com.transport.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单详情
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OrdersDetail对象", description="订单详情")
public class OrdersDetail extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderId;

    @ApiModelProperty(value = "运输方式(0:汽运 1空运)")
    private Integer transportType;

    @ApiModelProperty(value = "订单状态(0:代发货,1:发货中,2:已完成,3:退货中,4:已退货)")
    private Integer orderStatus;

    @ApiModelProperty(value = "运费付款方(0:到付,1:现付)")
    private Integer transportFeePayType;

    @ApiModelProperty(value = "运费")
    private BigDecimal transportFee;

    @ApiModelProperty(value = "收货人")
    private Long receiverId;

    @ApiModelProperty(value = "发货/收货件数(默认1件)")
    private Integer packagesNumber;

    @ApiModelProperty(value = "是否打包（0不打包，1打包）")
    private Boolean isPack;

    @ApiModelProperty(value = "打包费用(默认0)")
    private BigDecimal packFee;

    @ApiModelProperty(value = "结算状态(0:为结算,1已结算)")
    private Boolean settleStatus;

    @ApiModelProperty(value = "是否保价（0不保价，1保价）")
    private Boolean isInsurance;

    @ApiModelProperty(value = "保价费用(默认0)")
    private BigDecimal insuranceFee;

    @ApiModelProperty(value = "发货人ID")
    private Long senderId;

    @ApiModelProperty(value = "发货日期")
    private LocalDate sendDate;

    @ApiModelProperty(value = "收货日期")
    private LocalDate reciveDate;

    @ApiModelProperty(value = "是否损坏(0:未损坏 1损坏)")
    private Boolean damageState;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
