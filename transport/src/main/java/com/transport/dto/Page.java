package com.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 分页
 * @author: zhenglubo
 * @create: 2019-04-04 16:54
 **/

@ApiModel("分页")
@Data
public class Page {

    @ApiModelProperty(name = "pageSize",example = "10",required = true)
    //@NotNull(message = "pageSize is null")
    private int pageSize = 10;
    @ApiModelProperty(name = "当前页",example = "0",required = true)
    //@NotNull(message = "current is null")
    private int current = 1;
    @ApiModelProperty(name = "总条数",example = "20")
    private int total;

}
