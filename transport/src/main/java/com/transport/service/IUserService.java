package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.UserListQueryDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-15
 */
public interface IUserService extends IService<User> {

    /**
     * 分页查询
     * @param queryDto
     * @return
     */
    DataResult<IPage<User>> listSearch(UserListQueryDto queryDto);

    /**
     * 新增、修改
     * @param user
     * @return
     */
    DataResult<Boolean> insertOrUpdate(User user);
}
