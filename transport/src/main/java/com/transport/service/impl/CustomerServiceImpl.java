package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.utils.DMLSQLWrapper;
import com.transport.domain.Customer;
import com.transport.dto.CustomerListQueryDto;
import com.transport.mapper.CustomerMapper;
import com.transport.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public DataResult<IPage<Customer>> listSearch(CustomerListQueryDto queryDto) {
        QueryWrapper<Customer> queryWrapper = DMLSQLWrapper.queryWrapper(queryDto, Customer.class);
        IPage<Customer> page = customerMapper.selectPage(new Page<>(queryDto.getCurrent(), queryDto.getSize(), true), queryWrapper);
        return CollectionUtils.isEmpty(page.getRecords())? DataResultBuild.fail(" no data"):DataResultBuild.success(page);
    }
}
