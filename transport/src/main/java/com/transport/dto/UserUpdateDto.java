package com.transport.dto;

import com.transport.common.annotation.GeneratorTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 修改用户信息Dto对象
 * @author: zhenglubo
 * @create: 2019-04-02 11:56
 **/

@Data
@ApiModel(value = "修改用户信息Dto对象")
public class UserUpdateDto {

    @GeneratorTable(name = "id")
    @ApiModelProperty(value = "用户表主键" ,example = "1")
    private Long id;

    @GeneratorTable(name = "username",isCondition = false)
    @ApiModelProperty(value = "用户名",position = 1,example = "zhenglubo")
    private String username;
}
