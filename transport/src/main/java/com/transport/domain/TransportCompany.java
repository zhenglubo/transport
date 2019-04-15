package com.transport.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 物流公司信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TransportCompany对象", description="物流公司信息")
public class TransportCompany extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "公司手机号1")
    private String companyPhone;

    @ApiModelProperty(value = "联系人姓名")
    private String companyPhoneName;

    @ApiModelProperty(value = "座机1")
    private String companyTelFirst;

    @ApiModelProperty(value = "座机2")
    private String companyTelSecond;

    @ApiModelProperty(value = "开始收货时间")
    private LocalDateTime beginReceiveTime;

    @ApiModelProperty(value = "截止收货时间")
    private LocalDateTime endReceiveTime;

    @ApiModelProperty(value = "结算时间说明")
    private String settleTimeDescrible;

    @ApiModelProperty(value = "开始发货日期")
    private LocalDate beginOperationDate;

    @ApiModelProperty(value = "开始收货日期")
    private LocalDate stopOperationDate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime dataChangeCreateTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
