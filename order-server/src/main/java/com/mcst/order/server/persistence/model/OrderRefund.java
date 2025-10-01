package com.mcst.order.server.persistence.model;

import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
/**
* 作者: liu yijun
* 日期: 2025-01-20
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund")
@Table(name = "order_refund", comment = "订单退款")
public class OrderRefund extends BaseMyBatisPlusEntity<OrderRefund> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderRefundId", isKey = true, length = 50)
    private String orderRefundId;
}