package com.transport.service.impl;

import com.transport.domain.MonthAmountSummary;
import com.transport.mapper.MonthAmountSummaryMapper;
import com.transport.service.IMonthAmountSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每月金额统计信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class MonthAmountSummaryServiceImpl extends ServiceImpl<MonthAmountSummaryMapper, MonthAmountSummary> implements IMonthAmountSummaryService {

}
