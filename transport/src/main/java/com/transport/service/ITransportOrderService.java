package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.domain.TransportOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.OrderListSearchDto;

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
    IPage<TransportOrder> listSearch(OrderListSearchDto orderListSearchDto);
}
