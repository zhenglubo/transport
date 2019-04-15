package com.transport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.transport.dto.UserListQueryDto;
import com.transport.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listSearch")
    public DataResult<IPage<User>> listSearch(@RequestBody UserListQueryDto queryDto){
        return userService.listSearch(queryDto);
    }

    @ApiOperation(value = "修改订单信息")
    @PostMapping("/insertOrUpdate")
    public DataResult<Boolean> insertOrUpdate(@RequestBody User user){

        return userService.insertOrUpdate(user);
    }

}

