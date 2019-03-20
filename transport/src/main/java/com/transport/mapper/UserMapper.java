package com.transport.mapper;

import com.transport.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zlb on 2019.03.20.
 */
@Repository
public interface UserMapper {

    List<User> selectAll();
}
