package com.transport.service.impl;

import com.transport.domain.SenderReceiver;
import com.transport.mapper.SenderReceiverMapper;
import com.transport.service.ISenderReceiverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货人发货人中间表 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class SenderReceiverServiceImpl extends ServiceImpl<SenderReceiverMapper, SenderReceiver> implements ISenderReceiverService {

}
