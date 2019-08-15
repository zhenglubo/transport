package com.transport.service.impl;

import com.transport.domain.DailyOrderSummary;
import com.transport.mapper.DailyOrderSummaryMapper;
import com.transport.service.IDailyOrderSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日订单数量统计信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class DailyOrderSummaryServiceImpl extends ServiceImpl<DailyOrderSummaryMapper, DailyOrderSummary> implements IDailyOrderSummaryService {

}
