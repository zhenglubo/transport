package com.transport.service.impl;

import com.transport.domain.MonthOrderSummary;
import com.transport.mapper.MonthOrderSummaryMapper;
import com.transport.service.IMonthOrderSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每月订单数量统计信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class MonthOrderSummaryServiceImpl extends ServiceImpl<MonthOrderSummaryMapper, MonthOrderSummary> implements IMonthOrderSummaryService {

}
