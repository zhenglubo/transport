package com.transport.controller;


import com.transport.common.*;
import com.transport.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zlb on 2019.03.20.
 */
@RestController
@RequestMapping("/user")
public class UserController{

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService  userService;

    @ApiOperation(value="users info", notes="list search user info")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "RequestParam", value = "RequestParam", required = true, dataType = "RequestParam",paramType = "RequestParam"),
    })
    @PostMapping("/listSearch")
    public Response<ListResponse> listSearch(RequestParam param){
        return Response.ok(userService.selectAll(param));
    }

    @ApiOperation(value="user info", notes="search user info")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "long",paramType = "userId"),
    })
    @PostMapping("/search")
    public Response search(Long userId){
        if(userId == null){
            logger.error(ReturnCode.EMPTY_PARAMS.getCode(),ReturnCode.EMPTY_PARAMS.getMessage());
          return Response.exception(new BusinessException(ReturnCode.EMPTY_PARAMS));
        }
        return Response.ok(userService.selectByPrimaryKey(userId));
    }
}
