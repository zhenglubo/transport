package com.transport.dto;

import com.transport.common.annotation.GeneratorTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 修改订单dto对象
 * @author: zhenglubo
 * @create: 2019-04-02 10:19
 **/

@Data
@ApiModel(value = "修改订单dto对象")
public class OrderUpdateDto {

    @GeneratorTable(name = "id")
    @ApiModelProperty(name = "订单表ID", position = 1, example = "1")
    private Long id;
    @GeneratorTable(name = "order_status", isCondition = false)
    @ApiModelProperty(name = "订单状态",position = 2,example = "1:运输中")
    private Integer orderStatus;
}
