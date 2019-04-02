package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.utils.DMLSQLWrapper;
import com.transport.domain.User;
import com.transport.dto.UserListQueryDto;
import com.transport.dto.UserUpdateDto;
import com.transport.mapper.UserMapper;
import com.transport.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
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
    public DataResult<IPage<User>> listSearch(UserListQueryDto userListQueryDto) {
        QueryWrapper<User> queryWrapper = DMLSQLWrapper.queryWrapper(userListQueryDto, User.class);
        IPage<User> userIPage = userMapper.selectPage(new Page<>(userListQueryDto.getCurrent(), userListQueryDto.getSize(), true), queryWrapper);
        return CollectionUtils.isEmpty(userIPage.getRecords()) ? DataResultBuild.fail("no data") : DataResultBuild.success(userIPage);
    }

    @Override
    public DataResult<Boolean> updateUserInfo(UserUpdateDto dto) {
        UpdateWrapper<User> updateWrapper = DMLSQLWrapper.updateWrapper(dto, User.class);
        boolean result = update(updateWrapper);
        return result ? DataResultBuild.success(true) : DataResultBuild.fail("update fail");
    }
}
