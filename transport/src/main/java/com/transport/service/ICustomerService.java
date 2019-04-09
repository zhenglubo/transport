package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.CustomerListQueryDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-02
 */
public interface ICustomerService extends IService<Customer> {

    /**
     *分页查询
     * @param queryDto
     * @return
     */
    DataResult<IPage<Customer>> listSearch(CustomerListQueryDto queryDto);
}
