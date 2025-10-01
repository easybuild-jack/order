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

/**
 * 作者: liu yijun
 * 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund_goods")
@Table(name = "order_refund_goods", comment = "订单退款商品")
public class OrderRefundGoods extends BaseMyBatisPlusEntity<OrderRefundGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderRefundGoodsId", isKey = true, length = 50)
    private String orderRefundGoodsId;
}