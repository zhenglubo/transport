package com.transport.service.impl;

import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.transport.mapper.UserMapper;
import com.transport.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public DataResult<List<User>> listSearch() {

        return null;
    }
}
