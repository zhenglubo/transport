package com.transport.service.impl;

import com.transport.common.ListResponse;
import com.transport.common.Pagination;
import com.transport.common.RequestParam;
import com.transport.common.Response;
import com.transport.domain.User;
import com.transport.mapper.UserMapper;
import com.transport.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zlb on 2019.03.20.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ListResponse<List<User>> selectAll(RequestParam param) {
        List<User> userList = userMapper.selectAll();
        int total = userMapper.selectCount();
        return new ListResponse(userList,total,param.getBasePagination());
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
