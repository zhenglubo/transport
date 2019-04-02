package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.utils.DMLSQLWrapper;
import com.transport.domain.TransportOrder;
import com.transport.dto.OrderListSearchDto;
import com.transport.dto.OrderUpdateDto;
import com.transport.mapper.TransportOrderMapper;
import com.transport.service.ITransportOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 服务实现类
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
    public DataResult<IPage<TransportOrder>> listSearch(OrderListSearchDto orderListSearchDto) {
        QueryWrapper<TransportOrder> wrapper = DMLSQLWrapper.queryWrapper(orderListSearchDto, TransportOrder.class);
        IPage<TransportOrder> orderIPage = transportOrderMapper.selectPage(new Page<>(orderListSearchDto.getCurrent(), orderListSearchDto.getSize(), true), wrapper);
        return CollectionUtils.isEmpty(orderIPage.getRecords()) ? DataResultBuild.fail("no data") : DataResultBuild.success(orderIPage);
    }

    @Override
    public DataResult<Boolean> updateOrder(OrderUpdateDto updateDto) {
        UpdateWrapper<TransportOrder> updateWrapper = DMLSQLWrapper.updateWrapper(updateDto, TransportOrder.class);
        boolean update = update(updateWrapper);
        return update ? DataResultBuild.success(true) : DataResultBuild.fail("update fail");
    }
}
