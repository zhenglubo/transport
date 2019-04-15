package com.transport.service.impl;

import com.transport.domain.TransportCompany;
import com.transport.mapper.TransportCompanyMapper;
import com.transport.service.ITransportCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物流公司信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class TransportCompanyServiceImpl extends ServiceImpl<TransportCompanyMapper, TransportCompany> implements ITransportCompanyService {

}
