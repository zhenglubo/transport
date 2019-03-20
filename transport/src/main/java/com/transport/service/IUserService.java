package com.transport.service;

import com.transport.domain.User;

import java.util.List;

/**
 * Created by zlb on 2019.03.20.
 */
public interface IUserService {

    List<User> selectAll();
}
