package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.utils.DMLSQLWrapper;
import com.transport.domain.Sender;
import com.transport.dto.SenderListQueyDto;
import com.transport.mapper.SenderMapper;
import com.transport.service.ISenderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 发货人信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class SenderServiceImpl extends ServiceImpl<SenderMapper, Sender> implements ISenderService {


    @Autowired
    private SenderMapper senderMapper;

    @Override
    public DataResult<IPage<Sender>> listSearch(SenderListQueyDto dto) {

        QueryWrapper<Sender> queryWrapper = DMLSQLWrapper.queryWrapper(dto, Sender.class);
        IPage<Sender> page = senderMapper.selectPage(new Page<>(dto.getCurrent(), dto.getPageSize(), true), queryWrapper);
        return CollectionUtils.isEmpty(page.getRecords()) ? DataResultBuild.fail("no data") : DataResultBuild.success(page);
    }

    @Override
    public DataResult<Boolean> insertOrUpdate(Sender sender) {
        int count = 0;
        if (sender.getId() != null) {
            count = senderMapper.updateById(sender);
        } else {
            count = senderMapper.insert(sender);
        }
        return count > 0 ? DataResultBuild.success(true) : DataResultBuild.fail("新增/修改失败 ");
    }
}
