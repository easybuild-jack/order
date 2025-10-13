package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 作者: liu yijun
 * 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_pickup")
@Table(name = "order_pickup", comment = "订单提货")
public class OrderPickup extends BaseMyBatisPlusEntity<OrderPickup> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderPickupId", isKey = true, length = 50)
    private String orderPickupId;

    @Column(comment = "订单Id", length = 50)
    private String orderInfoId;

    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    @Column(comment = "提货点Id", length = 50)
    private String pickupLocationId;

    @Column(comment = "提货码", length = 50)
    private String pickupCode;

    @Column(comment = "提货人", length = 50)
    private String pickupUser;

    @Column(comment = "提货人电话", length = 50)
    private String pickupPhone;

    @Column(comment = "提货时间", type = MySqlTypeConstant.TIMESTAMP)
    private LocalDateTime pickupTime;

    @Column(comment = "提货状态 0待提货 1已提货 2已取消", length = 50, defaultValue = "0")
    private Integer pickupStatus;

    @Column(comment = "提货备注")
    private String pickupRemark;

    @Column(length = 100, comment = "省")
    private String province;

    @Column(length = 100, comment = "市")
    private String city;

    @Column(length = 100, comment = "区")
    private String area;

    @Column(length = 100, comment = "详细地址")
    private String address;

    @Column(length = 100, comment = "提货点完整地址")
    private String addressInfo;

    @Column(length = 100, comment = "联系人")
    private String linkMan;

    @Column(length = 100, comment = "联系电话")
    private String linkPhone;

    @Column(length = 100, comment = "经度")
    private String longitude;

    @Column(length = 100, comment = "纬度")
    private String latitude;

    @Column(length = 10, comment = "实收金额", decimalLength = 2)
    private BigDecimal receivedAmount;

    @Column(length = 50, comment = "发货人ID")
    private String deliverId;

    @Column(length = 50, comment = "发货人姓名")
    private String deliverName;

}