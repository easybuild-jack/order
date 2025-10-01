package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
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
@Table(name = "order_deliver", comment = "订单发货")
public class OrderDeliver extends BaseMyBatisPlusEntity<OrderDeliver> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderDeliverId", isKey = true, length = 50)
    private String orderDeliverId;

    /**
     * 订单ID
     */
    @Column(comment = "订单ID", length = 50)
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    /**
     * 快递单号
     */
    @Column(comment = "快递单号", length = 50)
    private String expressNo;

    /**
     * 快递公司编码
     */
    @Column(comment = "快递公司编码", length = 50)
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    @Column(comment = "快递公司", length = 50)
    private String expressCompany;

    /**
     * 发货门店ID
     */
    @Column(comment = "发货门店ID", length = 50)
    private String shopId;

    /**
     * 发货门店名称
     */
    @Column(comment = "发货门店名称", length = 50)
    private String shopName;

    /**
     * 发货人ID
     */
    @Column(comment = "发货人ID", length = 50)
    private String empId;

    /**
     * 发货人名称
     */
    @Column(comment = "发货人名称", length = 50)
    private String empName;

    /**
     * 发货日期
     */
    @Column(comment = "发货日期")
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    @Column(comment = "发货时间")
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    @Column(comment = "收货人名称", length = 50)
    private String recipientsName;

    /**
     * 收货人手机号
     */
    @Column(comment = "收货人手机号", length = 50)
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    @Column(comment = "收货地址的ID", length = 50)
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    @Column(comment = "具体收货地址", length = 200)
    private String address;

    /**
     * 地区
     */
    @Column(comment = "地区", length = 50)
    private String area;

    /**
     * 城市
     */
    @Column(comment = "城市", length = 50)
    private String city;

    /**
     * 省份
     */
    @Column(comment = "省份", length = 50)
    private String province;

    /**
     * 排序
     */
    @Column(comment = "排序", length = 2)
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    @Column(comment = "状态 0:待签收 1已签收", length = 2)
    private Integer status;

    /**
     * 收货时间
     */
    @Column(comment = "收货时间")
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    @Column(comment = "快递费用", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    @Column(comment = "快递费用模板ID", length = 50)
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    @Column(comment = "快递费用模板名称", length = 50)
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    @Column(comment = "订阅状态 0 未订阅 1已订阅", length = 2)
    private Integer subscriptStatus;

    /**
     * 备注
     */
    @Column(comment = "备注", length = 200)
    private String remark;

}