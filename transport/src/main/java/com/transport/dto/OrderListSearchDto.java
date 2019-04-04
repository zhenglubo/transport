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
public class OrderListSearchDto extends Page implements Serializable {

    /*@GeneratorTable(name="id")
    @ApiModelProperty(value = "主键ID",position = 1,example = "1")
    private Long id;

    @GeneratorTable(name = "order_id")
    @ApiModelProperty(value = "订单号",position = 2,example = "1241142451")
    private String orderId;

    @GeneratorTable(name = "order_status")
    @ApiModelProperty(value = "订单状态（0：未发货，1：运输中，2：已完成）",position = 3,example = "1")
    private Integer orderStatus;

    @GeneratorTable(name = "user_id")
    @ApiModelProperty(value = "用户id",position = 4,example = "1")
    private Long userId;

    @GeneratorTable(name = "transport_pay_type")
    @ApiModelProperty(value = "运费付款方式（0：发货方付，1：收货方付）",position = 5,example = "0")
    private String transportPayType;

    @ApiModelProperty(value = "当前页",position = 6,example = "0")
    private Integer current;

    @ApiModelProperty(value = "每一页大小",position = 7,example = "10")
    private Integer pageSize;*/

}
