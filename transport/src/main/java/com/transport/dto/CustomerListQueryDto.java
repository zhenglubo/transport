package com.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author zlb
 * @date 2019.04.02
 */
@Data
@ApiModel("分页查询Dto")
public class CustomerListQueryDto {

    @ApiModelProperty(name = "用户名",example = "王林")
    private String name;
    @ApiModelProperty(name = "联系电话",position = 1,example = "15674518896")
    private String phoneNumber;
    @ApiModelProperty(name = "当前页",position = 2,example = "0",required = true)
    private int current;
    @ApiModelProperty(name = "每一页大小",position = 3,example = "10",required = true)
    private int size;

}
