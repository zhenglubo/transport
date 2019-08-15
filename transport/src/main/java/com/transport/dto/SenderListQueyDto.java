package com.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 分页查询Dto
 * @author: zhenglubo
 * @create: 2019-04-15 13:35
 **/

@ApiModel(value = "分页查询dto")
@Data
public class SenderListQueyDto extends Page{

    @ApiModelProperty(value = "主键ID",position = 1)
    private Long id;

    @ApiModelProperty(value = "发货人",position = 2)
    private String senderName;

    @ApiModelProperty(value = "电话",position = 3)
    private String senderPhone;
}
