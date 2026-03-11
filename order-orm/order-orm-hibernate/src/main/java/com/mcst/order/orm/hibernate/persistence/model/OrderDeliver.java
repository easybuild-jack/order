package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderDeliverDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_deliver")
@AutoMapper(target = OrderDeliverDto.class)
public class OrderDeliver extends BaseHibernateEntity {

    /**
     * 订单发货ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_deliver_id")
    private String orderDeliverId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 快递单号
     */
    @Column(name = "express_no")
    private String expressNo;

    /**
     * 快递公司编码
     */
    @Column(name = "express_company_code")
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    @Column(name = "express_company")
    private String expressCompany;

    /**
     * 发货商户ID
     */
    @Column(name = "merchant_id")
    private String merchantId;

    /**
     * 发货商户名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 发货人ID
     */
    @Column(name = "emp_id")
    private String empId;

    /**
     * 发货人名称
     */
    @Column(name = "emp_name")
    private String empName;

    /**
     * 发货日期
     */
    @Column(name = "delivered_date")
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    @Column(name = "delivered_time")
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    @Column(name = "recipients_name")
    private String recipientsName;

    /**
     * 收货人手机号
     */
    @Column(name = "recipients_phone")
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    @Column(name = "recipients_address_id")
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 地区
     */
    @Column(name = "area")
    private String area;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 省份
     */
    @Column(name = "province")
    private String province;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 收货时间
     */
    @Column(name = "receive_time")
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    @Column(name = "postage_amount")
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    @Column(name = "postage_template_id")
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    @Column(name = "postage_template_name")
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    @Column(name = "subscript_status")
    private Integer subscriptStatus;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
