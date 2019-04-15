package com.transport.service.impl;

import com.transport.domain.OrdersDetail;
import com.transport.mapper.OrdersDetailMapper;
import com.transport.service.IOrdersDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class OrdersDetailServiceImpl extends ServiceImpl<OrdersDetailMapper, OrdersDetail> implements IOrdersDetailService {

}
