package com.transport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.transport.common.result.DataResult;
import com.transport.common.result.DataResultBuild;
import com.transport.common.utils.DMLSQLWrapper;
import com.transport.domain.Route;
import com.transport.dto.RouteListQueryDto;
import com.transport.mapper.RouteMapper;
import com.transport.service.IRouteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 物流线路信息 服务实现类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements IRouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public DataResult<IPage<Route>> listSearch(RouteListQueryDto dto) {
        QueryWrapper<Route> queryWrapper = DMLSQLWrapper.queryWrapper(dto, Route.class);
        IPage<Route> page = routeMapper.selectPage(new Page<>(dto.getCurrent(), dto.getPageSize(), true), queryWrapper);
        return CollectionUtils.isEmpty(page.getRecords()) ? DataResultBuild.fail("no data") : DataResultBuild.success(page);
    }

}
