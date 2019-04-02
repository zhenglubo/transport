package com.transport.dto;

import com.transport.common.annotation.GeneratorTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 用户列表查询
 * @author: zhenglubo
 * @create: 2019-04-01 18:26
 **/

@Data
@ApiModel(value = "分页查询请求对象")
public class UserListQueryDto {


    @GeneratorTable(name = "username")
    @ApiModelProperty(name = "用户名",position = 1,example = "admin")
    private String username;
    @GeneratorTable(name = "contact_phone")
    @ApiModelProperty(name = "联系方式",position = 2,example = "13828486044")
    private String contactPhone;
    @ApiModelProperty(name = "当前页",position = 3,example = "0")
    private int current;
    @ApiModelProperty(name = "每一页大小",position = 4,example = "10")
    private int size;
}
