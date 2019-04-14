package com.transport.service.impl;

import com.transport.domain.FleetManagement;
import com.transport.mapper.FleetManagementMapper;
import com.transport.service.IFleetManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车队管理信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class FleetManagementServiceImpl extends ServiceImpl<FleetManagementMapper, FleetManagement> implements IFleetManagementService {

}
