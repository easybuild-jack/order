package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
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
 * @author: liu yijun
 * @date: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_deliver")
@AutoMapper(target = OrderDeliverDto.class)
public class OrderDeliver extends BaseMyBatisPlusEntity<OrderDeliver> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderDeliverId;

    /**
     * 订单ID
     */
    private String orderInfoId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 快递公司编码
     */
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 发货门店ID
     */
    private String shopId;

    /**
     * 发货门店名称
     */
    private String shopName;

    /**
     * 发货人ID
     */
    private String empId;

    /**
     * 发货人名称
     */
    private String empName;

    /**
     * 发货日期
     */
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    private String recipientsName;

    /**
     * 收货人手机号
     */
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    private String address;

    /**
     * 地区
     */
    private String area;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    private Integer status;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    private Integer subscriptStatus;

    /**
     * 备注
     */
    private String remark;

}