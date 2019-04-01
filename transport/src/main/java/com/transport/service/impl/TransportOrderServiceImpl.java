package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.utils.MapUtils;
import com.transport.domain.TransportOrder;
import com.transport.dto.OrderListSearchDto;
import com.transport.mapper.TransportOrderMapper;
import com.transport.service.ITransportOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
@Service
public class TransportOrderServiceImpl extends ServiceImpl<TransportOrderMapper, TransportOrder> implements ITransportOrderService {

    @Autowired
    private TransportOrderMapper transportOrderMapper;

    @Override
    public IPage<TransportOrder> listSearch(OrderListSearchDto orderListSearchDto) {
        QueryWrapper<TransportOrder> wrapper = new QueryWrapper<>();
        setWrapper(wrapper,orderListSearchDto);
        IPage<TransportOrder> orderIPage = transportOrderMapper.selectPage(new Page<>(), wrapper);
        return orderIPage;
    }

    private void  setWrapper(QueryWrapper<TransportOrder> wrapper, OrderListSearchDto orderListSearchDto) {
        Map<String, Object> map = MapUtils.toMap(orderListSearchDto);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getValue());
            wrapper.eq(entry.getKey(),entry.getValue());
        }
    }


}
