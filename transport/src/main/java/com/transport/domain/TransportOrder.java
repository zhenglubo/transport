package com.transport.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Order对象", description="订单信息表")
public class TransportOrder extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "订单号",position = 1)
    private String orderId;

    @ApiModelProperty(value = "订单状态（0：未发货，1：运输中，2：已完成）",position = 2)
    private Integer orderStatus;

    @ApiModelProperty(value = "用户id",position = 3)
    private Long userId;

    @ApiModelProperty(value = "运费付款方式（0：发货方付，1：收货方付）",position = 4)
    private String transportPayType;

    @ApiModelProperty(value = "运费",position = 5)
    private BigDecimal transportFee;

    @ApiModelProperty(value = "是否代收（0：不代收，1：代收）",position = 6)
    private Boolean isCollectAmount;

    @ApiModelProperty(value = "代收金额",position = 7)
    private BigDecimal collectAmount;

    @ApiModelProperty(value = "操作人id",position = 8)
    private Long operatorId;

    @ApiModelProperty(value = "运输方式（0：汽运，1：火车，2：空运）",position = 9)
    private Integer transportMethod;

    @ApiModelProperty(value = "是否需要包装（0：不需要，1需要）",position = 10)
    private Boolean isPackaging;

    @ApiModelProperty(value = "包装费用",position = 11)
    private BigDecimal packagingFee;


    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    @ApiModelProperty(value = "订单创建时间",position = 12)
    private LocalDateTime dataChangeCreateTime;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "订单最终修改时间",position = 13)
    private LocalDateTime dataChangeLastTime;


}
