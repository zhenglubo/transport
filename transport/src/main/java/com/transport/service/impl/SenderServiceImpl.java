package com.transport.service.impl;

import com.transport.domain.Sender;
import com.transport.mapper.SenderMapper;
import com.transport.service.ISenderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发货人信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class SenderServiceImpl extends ServiceImpl<SenderMapper, Sender> implements ISenderService {

}
