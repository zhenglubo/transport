package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Sender;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.SenderListQueyDto;

/**
 * <p>
 * 发货人信息 服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
public interface ISenderService extends IService<Sender> {

    /**
     * 分页查询
     * @param dto
     * @return
     */
    DataResult<IPage<Sender>> listSearch(SenderListQueyDto dto);

    /**
     * 新增/修改
     * @param sender
     * @return
     */
    DataResult<Boolean> insertOrUpdate(Sender sender);
}
