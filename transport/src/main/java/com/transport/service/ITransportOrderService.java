package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.TransportOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.OrderListSearchDto;
import com.transport.dto.OrderUpdateDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
public interface ITransportOrderService extends IService<TransportOrder> {

    /**
     * list search
     * @param orderListSearchDto
     * @return
     */
    DataResult<IPage<TransportOrder>> listSearch(OrderListSearchDto orderListSearchDto);

    /**
     * 更新订单
     * @param updateDto
     * @return
     */
    DataResult<Boolean> updateOrder(OrderUpdateDto updateDto);
}
