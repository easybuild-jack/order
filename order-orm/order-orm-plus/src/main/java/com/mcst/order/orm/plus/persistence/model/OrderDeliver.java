package com.mcst.order.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderDeliverDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单发货
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_deliver")
@AutoMapper(target = OrderDeliverDto.class)
public class OrderDeliver extends BaseMyBatisPlusEntity<OrderDeliver> {

    /**
     * 订单发货ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "订单发货ID")
    private String orderDeliverId;

    /**
     * 订单ID
     */
    @EntityColumn(comment = "订单ID")
    private String orderId;

    /**
     * 订单编号
     */
    @EntityColumn(comment = "订单编号")
    private String orderNo;

    /**
     * 快递单号
     */
    @EntityColumn(comment = "快递单号")
    private String expressNo;

    /**
     * 快递公司编码
     */
    @EntityColumn(comment = "快递公司编码")
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    @EntityColumn(comment = "快递公司")
    private String expressCompany;

    /**
     * 发货商户ID
     */
    @EntityColumn(comment = "发货商户ID")
    private String merchantId;

    /**
     * 发货商户名称
     */
    @EntityColumn(comment = "发货商户名称")
    private String merchantName;

    /**
     * 发货人ID
     */
    @EntityColumn(comment = "发货人ID")
    private String empId;

    /**
     * 发货人名称
     */
    @EntityColumn(comment = "发货人名称")
    private String empName;

    /**
     * 发货日期
     */
    @EntityColumn(comment = "发货日期")
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    @EntityColumn(comment = "发货时间")
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    @EntityColumn(comment = "收货人名称")
    private String recipientsName;

    /**
     * 收货人手机号
     */
    @EntityColumn(comment = "收货人手机号")
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    @EntityColumn(comment = "收货地址的ID")
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    @EntityColumn(comment = "具体收货地址")
    private String address;

    /**
     * 地区
     */
    @EntityColumn(comment = "地区")
    private String area;

    /**
     * 城市
     */
    @EntityColumn(comment = "城市")
    private String city;

    /**
     * 省份
     */
    @EntityColumn(comment = "省份")
    private String province;

    /**
     * 排序
     */
    @EntityColumn(comment = "排序")
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    @EntityColumn(comment = "状态 0:待签收 1已签收")
    private Integer status;

    /**
     * 收货时间
     */
    @EntityColumn(comment = "收货时间")
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    @EntityColumn(comment = "快递费用")
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    @EntityColumn(comment = "快递费用模板ID")
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    @EntityColumn(comment = "快递费用模板名称")
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    @EntityColumn(comment = "订阅状态 0 未订阅 1已订阅")
    private Integer subscriptStatus;

    /**
     * 备注
     */
    @EntityColumn(comment = "备注")
    private String remark;

}
