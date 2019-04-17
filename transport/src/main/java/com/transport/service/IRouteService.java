package com.transport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.transport.common.result.DataResult;
import com.transport.domain.Route;
import com.baomidou.mybatisplus.extension.service.IService;
import com.transport.dto.RouteListQueryDto;

/**
 * <p>
 * 物流线路信息 服务类
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
public interface IRouteService extends IService<Route> {

    /**
     * 分页查询
     * @param dto 查询条件dto
     * @return 结果集
     */
    DataResult<IPage<Route>> listSearch(RouteListQueryDto dto);
}
