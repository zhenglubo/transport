package com.transport.service;

import com.transport.common.ListResponse;
import com.transport.common.RequestParam;
import com.transport.domain.User;

import java.util.List;

/**
 * Created by zlb on 2019.03.20.
 */
public interface IUserService {

    ListResponse<List<User>> selectAll(RequestParam param);

    User selectByPrimaryKey(Long id);
}
