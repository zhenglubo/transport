package com.transport.service.impl;

import com.transport.domain.Receiver;
import com.transport.mapper.ReceiverMapper;
import com.transport.service.IReceiverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货人信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class ReceiverServiceImpl extends ServiceImpl<ReceiverMapper, Receiver> implements IReceiverService {

}
