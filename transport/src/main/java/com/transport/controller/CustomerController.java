package com.transport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Customer;
import com.transport.dto.CustomerListQueryDto;
import com.transport.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-02
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private ICustomerService customerService;

    @ApiOperation(value = "list search")
    @PostMapping("/listSearch")
    public DataResult<IPage<Customer>> listSearch(@RequestBody CustomerListQueryDto queryDto){

        return customerService.listSearch(queryDto);
    }

}

