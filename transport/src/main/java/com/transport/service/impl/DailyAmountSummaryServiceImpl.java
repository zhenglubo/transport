package com.transport.service.impl;

import com.transport.domain.DailyAmountSummary;
import com.transport.mapper.DailyAmountSummaryMapper;
import com.transport.service.IDailyAmountSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日金额统计信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class DailyAmountSummaryServiceImpl extends ServiceImpl<DailyAmountSummaryMapper, DailyAmountSummary> implements IDailyAmountSummaryService {

}
