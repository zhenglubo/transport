package com.transport.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 发货人信息
 * </p>
 *
 * @author zhenglb
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Sender对象", description="发货人信息")
public class Sender extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "发货人姓名")
    private String senderName;

    @ApiModelProperty(value = "身份证号")
    private String identityNo;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "发货人电话")
    private String senderPhone;

    @ApiModelProperty(value = "发货人提货地址")
    private String senderAddress;

    @ApiModelProperty(value = "银行卡号")
    private String bankCardNo;

    @ApiModelProperty(value = "银行卡类型")
    private String bankCardType;

    @ApiModelProperty(value = "持卡人")
    private String cardholder;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime dataChangeCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime dataChangeLastTime;


}
