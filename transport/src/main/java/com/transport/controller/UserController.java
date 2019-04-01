package com.transport.controller;


import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.transport.dto.UserListQueryDto;
import com.transport.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listSearch")
    public DataResult<List<User>> listSearch(UserListQueryDto queryDto){
        return userService.listSearch();
    }

}

