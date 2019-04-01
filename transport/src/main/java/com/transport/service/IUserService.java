package com.transport.service;

import com.transport.common.result.DataResult;
import com.transport.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @return
     */
    DataResult<List<User>> listSearch();
}
