package com.transport.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="订单信息")
public class Orders extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "订单状态(0代发货 1运输中 2已完成 3退货中 4已退货)")
    private Integer orderStatus;

    @ApiModelProperty(value = "发货人ID")
    private Long senderId;

    @ApiModelProperty(value = "收货人ID")
    private Long receiverId;

    @ApiModelProperty(value = "订单处理人ID")
    private Long userId;

    @ApiModelProperty(value = "订单处理人ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
