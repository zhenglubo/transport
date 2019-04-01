package com.transport.dto;

import com.transport.common.annotation.GeneratorTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: order list search query dto
 * @author: zhenglubo
 * @create: 2019-04-01 13:47
 **/

@Data
@ApiModel(value="OrderListSearchDto", description="列表查询请求dto")
public class OrderListSearchDto implements Serializable {

    @GeneratorTable(name="id")
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /*@GeneratorTable(name = "order_id")
    @ApiModelProperty(value = "订单号")
    private String orderId;

    @GeneratorTable(name = "order_status")
    @ApiModelProperty(value = "订单状态（0：未发货，1：运输中，2：已完成）")
    private Integer orderStatus;

    @GeneratorTable(name = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @GeneratorTable(name = "transport_pay_type")
    @ApiModelProperty(value = "运费付款方式（0：发货方付，1：收货方付）")
    private String transportPayType;*/

}
