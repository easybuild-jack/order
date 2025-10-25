-- ============================================================
-- 订单系统数据库表结构
-- 生成时间: 2025-10-25
-- ============================================================

-- 1. 订单信息表
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
    `order_info_id` VARCHAR(50) NOT NULL COMMENT 'OrderInfoId',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `user_id` VARCHAR(50) DEFAULT NULL COMMENT '用户ID',
    `user_third_account` VARCHAR(50) DEFAULT NULL COMMENT '用户第三方账号，如微信openid',
    `user_phone` VARCHAR(50) DEFAULT NULL COMMENT '用户电话',
    `goods_name` VARCHAR(50) DEFAULT NULL COMMENT '商品名称',
    `goods_sku_name` VARCHAR(150) DEFAULT NULL COMMENT '商品SKU 名称',
    `goods_pic` VARCHAR(200) DEFAULT NULL COMMENT '商品图片',
    `goods_count` INT(10) DEFAULT NULL COMMENT '商品总数量',
    `total_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '订单总金额',
    `actual_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '实际金额，实际需要支付的金额',
    `order_type` INT(5) DEFAULT 0 COMMENT '订单类型 0：线上，1：线下',
    `dispatch_type` INT(2) DEFAULT 1 COMMENT '配送方式 0 自提 1 快递 2 虚拟商品',
    `invoice_flag` INT(2) DEFAULT 0 COMMENT '是否要发票 0未开发票，1已开票',
    `refund_flag` INT(2) DEFAULT 0 COMMENT '售后状态 0：未申请，1：已申请',
    `refund_status` INT(2) DEFAULT 0 COMMENT '退款状态 0：未退款，1：全部退款，2：部分退款',
    `refund_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '退款金额',
    `user_remark` VARCHAR(200) DEFAULT NULL COMMENT '买家备注',
    `order_source` INT(2) DEFAULT 0 COMMENT '订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店',
    `tag_remark` VARCHAR(200) DEFAULT NULL COMMENT '标记备注',
    `order_status` INT(2) DEFAULT 0 COMMENT '订单状态 0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款',
    `order_channel` INT(50) DEFAULT NULL COMMENT '订单渠道',
    `client_type` INT(2) DEFAULT 0 COMMENT '客户端类型 0 小程序 1 APP 2 PC',
    `push_flag` INT(2) DEFAULT 0 COMMENT '订单推送状态 0：未推送，1：已推送',
    `order_remark` VARCHAR(200) DEFAULT NULL COMMENT '订单备注',
    `statistics_flag` INT(2) DEFAULT 0 COMMENT '统计状态 0未处理 1已处理',
    `merchant_id` VARCHAR(50) DEFAULT NULL COMMENT '商家ID',
    `merchant_name` VARCHAR(50) DEFAULT NULL COMMENT '商家名称',
    `merchant_remark` VARCHAR(200) DEFAULT NULL COMMENT '商家备注',
    `order_date` DATE DEFAULT NULL COMMENT '订单日期',
    `order_time` TIMESTAMP NULL DEFAULT NULL COMMENT '订单时间',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_order_status` (`order_status`),
    KEY `idx_order_date` (`order_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单信息';

-- 2. 订单商品表
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
    `order_goods_id` VARCHAR(50) NOT NULL COMMENT 'OrderGoodsId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `user_id` VARCHAR(50) DEFAULT NULL COMMENT '用户ID',
    `user_third_account` VARCHAR(50) DEFAULT NULL COMMENT '用户第三方账号',
    `user_phone` VARCHAR(11) DEFAULT NULL COMMENT '用户手机号',
    `goods_id` VARCHAR(50) DEFAULT NULL COMMENT '商品ID',
    `goods_name` VARCHAR(50) DEFAULT NULL COMMENT '商品名称',
    `goods_no` VARCHAR(50) DEFAULT NULL COMMENT '商品编码',
    `goods_sku_id` VARCHAR(50) DEFAULT NULL COMMENT '商品SKUID',
    `goods_sku_no` VARCHAR(50) DEFAULT NULL COMMENT 'SKU编码',
    `goods_sku_name` VARCHAR(150) DEFAULT NULL COMMENT '商户sku名称',
    `goods_pic_url` VARCHAR(200) DEFAULT NULL COMMENT '商品图片',
    `goods_count` INT(10) DEFAULT NULL COMMENT '销售数量',
    `goods_price` DECIMAL(10,2) DEFAULT NULL COMMENT '商品原售价',
    `serial_no` VARCHAR(50) DEFAULT NULL COMMENT '产品序列号',
    `goods_type` INT(2) DEFAULT 0 COMMENT '商品类型 0 普通商品 1 虚拟商品',
    `gift_flag` INT(2) DEFAULT 0 COMMENT '是否是赠品 0-否 1-是',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_goods_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_goods_id` (`goods_id`),
    KEY `idx_goods_sku_id` (`goods_sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品';

-- 3. 订单金额表
DROP TABLE IF EXISTS `order_amount`;
CREATE TABLE `order_amount` (
    `order_amount_id` VARCHAR(50) NOT NULL COMMENT 'OrderAmountId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单信息ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `total_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '订单总金额，未打折的所有金额',
    `goods_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '商品总金额，未打折金额',
    `discount_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '优惠金额',
    `discount_after_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '优惠后的金额',
    `postage_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '邮费金额',
    `actual_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '实际金额 优惠后的金额+邮费 最终需要支付的金额',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_amount_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单金额';

-- 4. 订单优惠表
DROP TABLE IF EXISTS `order_discount`;
CREATE TABLE `order_discount` (
    `order_discount_id` VARCHAR(50) NOT NULL COMMENT 'OrderDiscountId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单信息ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `goods_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '商品总金额',
    `discount_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '优惠金额',
    `discount_after_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '优惠后的金额',
    `user_coupon_ids` VARCHAR(500) DEFAULT NULL COMMENT '用户优惠券ID',
    `discount_remark` VARCHAR(200) DEFAULT NULL COMMENT '优惠备注 例如：满300减50 *1 现金抵扣券50 *1 限时折扣85折 *1',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_discount_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单优惠';

-- 5. 订单支付表
DROP TABLE IF EXISTS `order_pay`;
CREATE TABLE `order_pay` (
    `order_pay_id` VARCHAR(50) NOT NULL COMMENT 'OrderPayId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单信息ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `actual_amount` DECIMAL(2,0) DEFAULT 0 COMMENT '实际金额，实际需要支付的金额',
    `pay_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '支付金额',
    `credit_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '支付积分',
    `balance_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '支付余额',
    `pay_status` INT(2) DEFAULT 0 COMMENT '支付状态 0：未支付，1：支付中，2：已支付',
    `third_trade_no` VARCHAR(50) DEFAULT NULL COMMENT '第三方交易号',
    `third_trade_channel` INT(2) DEFAULT NULL COMMENT '第三方支付渠道 0 微信 1支付宝 2抖音 3银联',
    `pay_date` DATE DEFAULT NULL COMMENT '支付日期',
    `pay_time` TIMESTAMP NULL DEFAULT NULL COMMENT '支付时间',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_pay_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_pay_status` (`pay_status`),
    KEY `idx_third_trade_no` (`third_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单支付';

-- 6. 订单发货表
DROP TABLE IF EXISTS `order_deliver`;
CREATE TABLE `order_deliver` (
    `order_deliver_id` VARCHAR(50) NOT NULL COMMENT 'OrderDeliverId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `express_no` VARCHAR(50) DEFAULT NULL COMMENT '快递单号',
    `express_company_code` VARCHAR(50) DEFAULT NULL COMMENT '快递公司编码',
    `express_company` VARCHAR(50) DEFAULT NULL COMMENT '快递公司',
    `shop_id` VARCHAR(50) DEFAULT NULL COMMENT '发货门店ID',
    `shop_name` VARCHAR(50) DEFAULT NULL COMMENT '发货门店名称',
    `emp_id` VARCHAR(50) DEFAULT NULL COMMENT '发货人ID',
    `emp_name` VARCHAR(50) DEFAULT NULL COMMENT '发货人名称',
    `delivered_date` DATE DEFAULT NULL COMMENT '发货日期',
    `delivered_time` DATETIME DEFAULT NULL COMMENT '发货时间',
    `recipients_name` VARCHAR(50) DEFAULT NULL COMMENT '收货人名称',
    `recipients_phone` VARCHAR(50) DEFAULT NULL COMMENT '收货人手机号',
    `recipients_address_id` VARCHAR(50) DEFAULT NULL COMMENT '收货地址的ID',
    `address` VARCHAR(200) DEFAULT NULL COMMENT '具体收货地址',
    `area` VARCHAR(50) DEFAULT NULL COMMENT '地区',
    `city` VARCHAR(50) DEFAULT NULL COMMENT '城市',
    `province` VARCHAR(50) DEFAULT NULL COMMENT '省份',
    `sort` INT(2) DEFAULT NULL COMMENT '排序',
    `status` INT(2) DEFAULT NULL COMMENT '状态 0:待签收 1已签收',
    `receive_time` DATETIME DEFAULT NULL COMMENT '收货时间',
    `postage_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '快递费用',
    `postage_template_id` VARCHAR(50) DEFAULT NULL COMMENT '快递费用模板ID',
    `postage_template_name` VARCHAR(50) DEFAULT NULL COMMENT '快递费用模板名称',
    `subscript_status` INT(2) DEFAULT NULL COMMENT '订阅状态 0 未订阅 1已订阅',
    `remark` VARCHAR(200) DEFAULT NULL COMMENT '备注',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_deliver_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_express_no` (`express_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单发货';

-- 7. 订单发货商品表
DROP TABLE IF EXISTS `order_deliver_goods`;
CREATE TABLE `order_deliver_goods` (
    `order_deliver_goods_id` VARCHAR(50) NOT NULL COMMENT 'OrderDeliverGoodsId',
    `order_deliver_id` VARCHAR(50) DEFAULT NULL COMMENT '发货ID',
    `goods_id` VARCHAR(50) DEFAULT NULL COMMENT '商品ID',
    `goods_name` VARCHAR(50) DEFAULT NULL COMMENT '商品名称',
    `goods_no` VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
    `goods_sku_id` VARCHAR(50) DEFAULT NULL COMMENT '商品SKUID',
    `goods_sku_name` VARCHAR(150) DEFAULT NULL COMMENT '商品SKU名称',
    `goods_sku_no` VARCHAR(50) DEFAULT NULL COMMENT '商品SKU编号',
    `goods_count` INT(10) DEFAULT NULL COMMENT '商品数量',
    `goods_pic_url` VARCHAR(200) DEFAULT NULL COMMENT '商品图片URL',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_deliver_goods_id`),
    KEY `idx_order_deliver_id` (`order_deliver_id`),
    KEY `idx_goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单发货商品';

-- 8. 订单提货表
DROP TABLE IF EXISTS `order_pickup`;
CREATE TABLE `order_pickup` (
    `order_pickup_id` VARCHAR(50) NOT NULL COMMENT 'OrderPickupId',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单Id',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `pickup_location_id` VARCHAR(50) DEFAULT NULL COMMENT '提货点Id',
    `pickup_code` VARCHAR(50) DEFAULT NULL COMMENT '提货码',
    `pickup_user` VARCHAR(50) DEFAULT NULL COMMENT '提货人',
    `pickup_phone` VARCHAR(50) DEFAULT NULL COMMENT '提货人电话',
    `pickup_time` TIMESTAMP NULL DEFAULT NULL COMMENT '提货时间',
    `pickup_status` INT(50) DEFAULT 0 COMMENT '提货状态 0待提货 1已提货 2已取消',
    `pickup_remark` VARCHAR(255) DEFAULT NULL COMMENT '提货备注',
    `province` VARCHAR(100) DEFAULT NULL COMMENT '省',
    `city` VARCHAR(100) DEFAULT NULL COMMENT '市',
    `area` VARCHAR(100) DEFAULT NULL COMMENT '区',
    `address` VARCHAR(100) DEFAULT NULL COMMENT '详细地址',
    `address_info` VARCHAR(100) DEFAULT NULL COMMENT '提货点完整地址',
    `link_man` VARCHAR(100) DEFAULT NULL COMMENT '联系人',
    `link_phone` VARCHAR(100) DEFAULT NULL COMMENT '联系电话',
    `longitude` VARCHAR(100) DEFAULT NULL COMMENT '经度',
    `latitude` VARCHAR(100) DEFAULT NULL COMMENT '纬度',
    `received_amount` DECIMAL(10,2) DEFAULT NULL COMMENT '实收金额',
    `deliver_id` VARCHAR(50) DEFAULT NULL COMMENT '发货人ID',
    `deliver_name` VARCHAR(50) DEFAULT NULL COMMENT '发货人姓名',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_pickup_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_pickup_code` (`pickup_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单提货';

-- 9. 提货点信息表
DROP TABLE IF EXISTS `pickup_location`;
CREATE TABLE `pickup_location` (
    `pickup_location_id` VARCHAR(50) NOT NULL COMMENT 'PickupLocationId',
    `location_name` VARCHAR(100) DEFAULT NULL COMMENT '提货点名称',
    `province` VARCHAR(100) DEFAULT NULL COMMENT '省',
    `city` VARCHAR(100) DEFAULT NULL COMMENT '市',
    `area` VARCHAR(100) DEFAULT NULL COMMENT '区',
    `address` VARCHAR(100) DEFAULT NULL COMMENT '详细地址',
    `address_info` VARCHAR(100) DEFAULT NULL COMMENT '提货点完整地址',
    `link_man` VARCHAR(100) DEFAULT NULL COMMENT '联系人',
    `link_phone` VARCHAR(100) DEFAULT NULL COMMENT '联系电话',
    `business_hours` VARCHAR(100) DEFAULT NULL COMMENT '营业时间',
    `longitude` VARCHAR(100) DEFAULT NULL COMMENT '经度',
    `latitude` VARCHAR(100) DEFAULT NULL COMMENT '纬度',
    `forbidden_flag` INT(2) DEFAULT 0 COMMENT '禁用状态 0可用，1禁用',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`pickup_location_id`),
    KEY `idx_location_name` (`location_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='提货点信息';

-- 10. 订单退款表
DROP TABLE IF EXISTS `order_refund`;
CREATE TABLE `order_refund` (
    `order_refund_id` VARCHAR(50) NOT NULL COMMENT 'OrderRefundId',
    `order_refund_no` VARCHAR(50) DEFAULT NULL COMMENT '退款单号',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单信息ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `order_pay_id` VARCHAR(50) DEFAULT NULL COMMENT '支付记录ID',
    `user_id` VARCHAR(50) DEFAULT NULL COMMENT '用户ID',
    `user_phone` VARCHAR(50) DEFAULT NULL COMMENT '用户电话',
    `refund_type` INT(2) DEFAULT 0 COMMENT '退款类型 0 仅退款 1 退货退款',
    `refund_source` INT(2) DEFAULT 0 COMMENT '退款来源 0 用户申请 1 商家发起 2 系统发起',
    `refund_status` INT(2) DEFAULT 0 COMMENT '退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭',
    `refund_channel` INT(2) DEFAULT 0 COMMENT '退款渠道 0 原路退回 1 退至余额 2 线下打款',
    `refund_reason_type` INT(5) DEFAULT 0 COMMENT '退款原因类型',
    `refund_reason` VARCHAR(200) DEFAULT NULL COMMENT '退款原因说明',
    `apply_remark` VARCHAR(200) DEFAULT NULL COMMENT '退款申请备注（用户填写）',
    `audit_remark` VARCHAR(200) DEFAULT NULL COMMENT '退款审核备注（客服填写）',
    `handle_remark` VARCHAR(200) DEFAULT NULL COMMENT '退款处理备注（财务填写）',
    `refund_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '退款申请金额',
    `refund_freight_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '退款运费金额',
    `refund_credit_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '退款积分抵扣金额',
    `refund_coupon_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '退款优惠券抵扣金额',
    `refund_evidence_pics` VARCHAR(500) DEFAULT NULL COMMENT '退款凭证图片，多个以逗号分隔',
    `return_express_company` VARCHAR(100) DEFAULT NULL COMMENT '退回物流公司',
    `return_express_no` VARCHAR(50) DEFAULT NULL COMMENT '退回物流单号',
    `auditor_id` VARCHAR(50) DEFAULT NULL COMMENT '审核人ID',
    `auditor_name` VARCHAR(50) DEFAULT NULL COMMENT '审核人姓名',
    `audit_time` DATETIME DEFAULT NULL COMMENT '审核时间',
    `handler_id` VARCHAR(50) DEFAULT NULL COMMENT '处理人ID',
    `handler_name` VARCHAR(50) DEFAULT NULL COMMENT '处理人姓名',
    `handle_time` DATETIME DEFAULT NULL COMMENT '处理时间',
    `refund_trade_no` VARCHAR(50) DEFAULT NULL COMMENT '退款交易号',
    `refund_complete_time` DATETIME DEFAULT NULL COMMENT '退款完成时间',
    `receive_confirm_time` DATETIME DEFAULT NULL COMMENT '用户收货确认时间（用于退货退款）',
    `contact_phone` VARCHAR(50) DEFAULT NULL COMMENT '联系电话',
    `contact_name` VARCHAR(50) DEFAULT NULL COMMENT '联系人',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_refund_id`),
    KEY `idx_order_refund_no` (`order_refund_no`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_refund_status` (`refund_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退款';

-- 11. 订单退款商品表
DROP TABLE IF EXISTS `order_refund_goods`;
CREATE TABLE `order_refund_goods` (
    `order_refund_goods_id` VARCHAR(50) NOT NULL COMMENT 'OrderRefundGoodsId',
    `order_refund_id` VARCHAR(50) DEFAULT NULL COMMENT '退款记录ID',
    `order_info_id` VARCHAR(50) DEFAULT NULL COMMENT '订单信息ID',
    `order_no` VARCHAR(50) DEFAULT NULL COMMENT '订单编号',
    `order_goods_id` VARCHAR(50) DEFAULT NULL COMMENT '订单商品记录ID',
    `goods_id` VARCHAR(50) DEFAULT NULL COMMENT '商品ID',
    `goods_sku_id` VARCHAR(50) DEFAULT NULL COMMENT '商品SKU ID',
    `goods_name` VARCHAR(150) DEFAULT NULL COMMENT '商品名称',
    `goods_sku_name` VARCHAR(200) DEFAULT NULL COMMENT '商品SKU 名称',
    `goods_pic` VARCHAR(200) DEFAULT NULL COMMENT '商品图片',
    `goods_spec_json` TEXT DEFAULT NULL COMMENT '商品规格JSON（用于回显）',
    `goods_price` DECIMAL(10,2) DEFAULT NULL COMMENT '商品单价',
    `goods_actual_price` DECIMAL(10,2) DEFAULT NULL COMMENT '商品实际支付单价',
    `refund_real_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '实际退款金额',
    `return_quantity` INT(10) DEFAULT NULL COMMENT '退货数量',
    `return_finish_time` DATETIME DEFAULT NULL COMMENT '退货完成时间',
    `express_company` VARCHAR(100) DEFAULT NULL COMMENT '快递公司',
    `express_company_code` VARCHAR(100) DEFAULT NULL COMMENT '快递公司代码',
    `express_no` VARCHAR(100) DEFAULT NULL COMMENT '快递单号',
    `remark` VARCHAR(200) DEFAULT NULL COMMENT '备注',
    `insert_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    `last_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `deleted` INT(2) NOT NULL DEFAULT 0 COMMENT '删除标记，0否 1是',
    PRIMARY KEY (`order_refund_goods_id`),
    KEY `idx_order_refund_id` (`order_refund_id`),
    KEY `idx_order_info_id` (`order_info_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退款商品';

