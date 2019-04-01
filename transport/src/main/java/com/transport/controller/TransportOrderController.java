package com.transport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.domain.TransportOrder;
import com.transport.dto.OrderListSearchDto;
import com.transport.service.ITransportOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
@RestController
@RequestMapping("/order")
public class TransportOrderController {

    @Autowired
    private ITransportOrderService orderService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listSearch")
    public DataResult<IPage<TransportOrder>> listSearch(@RequestBody OrderListSearchDto orderListSearchDto) {
        IPage<TransportOrder> orders = orderService.listSearch(orderListSearchDto);
        return CollectionUtils.isEmpty(orders.getRecords()) ? DataResultBuild.fail("no data") : DataResultBuild.success(orders);
    }
}
