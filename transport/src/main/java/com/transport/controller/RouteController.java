package com.transport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Route;
import com.transport.dto.RouteListQueryDto;
import com.transport.service.IRouteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物流线路信息 前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private IRouteService routeService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listSearch")
    public DataResult<IPage<Route>> listSearch(@RequestBody RouteListQueryDto dto){
        return routeService.listSearch(dto);
    }
}

