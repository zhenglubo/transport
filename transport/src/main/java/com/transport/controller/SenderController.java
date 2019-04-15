package com.transport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Sender;
import com.transport.dto.SenderListQueyDto;
import com.transport.service.ISenderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发货人信息 前端控制器
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    private ISenderService senderService;

    @ApiOperation(value = "分页查询")
    @PostMapping(value = "/listSearch")
    public DataResult<IPage<Sender>> listSearch(@RequestBody SenderListQueyDto dto){

        return senderService.listSearch(dto);
    }

    @ApiOperation(value = "新增/修改")
    @PostMapping(value = "/insertOrUpdate")
    public DataResult<Boolean> insertOrUpdate(@RequestBody Sender sender){

        return senderService.insertOrUpdate(sender);
    }
}

