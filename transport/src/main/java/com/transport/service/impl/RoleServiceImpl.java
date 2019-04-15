package com.transport.service.impl;

import com.transport.domain.Role;
import com.transport.mapper.RoleMapper;
import com.transport.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
