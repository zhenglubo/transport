package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.UserListQueryDto;
import com.transport.dto.UserUpdateDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-01
 */
public interface IUserService extends IService<User> {

    /**
     * list search
     * @param userListQueryDto
     * @return
     */
    DataResult<IPage<User>> listSearch(UserListQueryDto userListQueryDto);

    /**
     * update user info
     * @param dto
     * @return
     */
    DataResult<Boolean> updateUserInfo(UserUpdateDto dto);
}
