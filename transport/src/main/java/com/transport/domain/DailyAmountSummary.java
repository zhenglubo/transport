package com.transport.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 每日金额统计信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DailyAmountSummary对象", description="每日金额统计信息")
public class DailyAmountSummary extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "物流公司ID")
    private Long transportCompanyId;

    @ApiModelProperty(value = "实收")
    private BigDecimal actualAmount;

    @ApiModelProperty(value = "应收")
    private BigDecimal naturalAmount;

    @ApiModelProperty(value = "已收")
    private BigDecimal alreadAmount;

    @ApiModelProperty(value = "打包费")
    private BigDecimal packageFee;

    @ApiModelProperty(value = "运费")
    private BigDecimal transportFee;

    @ApiModelProperty(value = "损毁赔付费")
    private BigDecimal damagedFee;

    @ApiModelProperty(value = "统计日期")
    private LocalDateTime summaryDate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
