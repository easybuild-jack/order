-- ============================================================
-- 订单系统数据库表结构 - PostgreSQL版本
-- 生成时间: 2025-10-25
-- ============================================================

-- 1. 订单信息表
DROP TABLE IF EXISTS order_info CASCADE;
CREATE TABLE order_info (
    order_info_id VARCHAR(50) NOT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    user_id VARCHAR(50) DEFAULT NULL,
    user_third_account VARCHAR(50) DEFAULT NULL,
    user_phone VARCHAR(50) DEFAULT NULL,
    goods_name VARCHAR(50) DEFAULT NULL,
    goods_sku_name VARCHAR(150) DEFAULT NULL,
    goods_pic VARCHAR(200) DEFAULT NULL,
    goods_count INTEGER DEFAULT NULL,
    total_amount NUMERIC(10,2) DEFAULT NULL,
    actual_amount NUMERIC(10,2) DEFAULT NULL,
    order_type INTEGER DEFAULT 0,
    dispatch_type SMALLINT DEFAULT 1,
    invoice_flag SMALLINT DEFAULT 0,
    refund_flag SMALLINT DEFAULT 0,
    refund_status SMALLINT DEFAULT 0,
    refund_amount NUMERIC(10,2) DEFAULT NULL,
    user_remark VARCHAR(200) DEFAULT NULL,
    order_source SMALLINT DEFAULT 0,
    tag_remark VARCHAR(200) DEFAULT NULL,
    order_status SMALLINT DEFAULT 0,
    order_channel INTEGER DEFAULT NULL,
    client_type SMALLINT DEFAULT 0,
    push_flag SMALLINT DEFAULT 0,
    order_remark VARCHAR(200) DEFAULT NULL,
    statistics_flag SMALLINT DEFAULT 0,
    merchant_id VARCHAR(50) DEFAULT NULL,
    merchant_name VARCHAR(50) DEFAULT NULL,
    merchant_remark VARCHAR(200) DEFAULT NULL,
    order_date DATE DEFAULT NULL,
    order_time TIMESTAMP DEFAULT NULL,
    agent_id VARCHAR(50) DEFAULT NULL,
    agent_name VARCHAR(100) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_info_id)
);
COMMENT ON TABLE order_info IS '订单信息';
COMMENT ON COLUMN order_info.order_info_id IS 'OrderInfoId';
COMMENT ON COLUMN order_info.order_no IS '订单编号';
COMMENT ON COLUMN order_info.user_id IS '用户ID';
COMMENT ON COLUMN order_info.user_third_account IS '用户第三方账号，如微信openid';
COMMENT ON COLUMN order_info.user_phone IS '用户电话';
COMMENT ON COLUMN order_info.goods_name IS '商品名称';
COMMENT ON COLUMN order_info.goods_sku_name IS '商品SKU 名称';
COMMENT ON COLUMN order_info.goods_pic IS '商品图片';
COMMENT ON COLUMN order_info.goods_count IS '商品总数量';
COMMENT ON COLUMN order_info.total_amount IS '订单总金额';
COMMENT ON COLUMN order_info.actual_amount IS '实际金额，实际需要支付的金额';
COMMENT ON COLUMN order_info.order_type IS '订单类型 0：线上，1：线下';
COMMENT ON COLUMN order_info.dispatch_type IS '配送方式 0 自提 1 快递 2 虚拟商品';
COMMENT ON COLUMN order_info.invoice_flag IS '是否要发票 0未开发票，1已开票';
COMMENT ON COLUMN order_info.refund_flag IS '售后状态 0：未申请，1：已申请';
COMMENT ON COLUMN order_info.refund_status IS '退款状态 0：未退款，1：全部退款，2：部分退款';
COMMENT ON COLUMN order_info.refund_amount IS '退款金额';
COMMENT ON COLUMN order_info.user_remark IS '买家备注';
COMMENT ON COLUMN order_info.order_source IS '订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店';
COMMENT ON COLUMN order_info.tag_remark IS '标记备注';
COMMENT ON COLUMN order_info.order_status IS '订单状态 0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款';
COMMENT ON COLUMN order_info.order_channel IS '订单渠道';
COMMENT ON COLUMN order_info.client_type IS '客户端类型 0 小程序 1 APP 2 PC';
COMMENT ON COLUMN order_info.push_flag IS '订单推送状态 0：未推送，1：已推送';
COMMENT ON COLUMN order_info.order_remark IS '订单备注';
COMMENT ON COLUMN order_info.statistics_flag IS '统计状态 0未处理 1已处理';
COMMENT ON COLUMN order_info.merchant_id IS '商家ID';
COMMENT ON COLUMN order_info.merchant_name IS '商家名称';
COMMENT ON COLUMN order_info.merchant_remark IS '商家备注';
COMMENT ON COLUMN order_info.order_date IS '订单日期';
COMMENT ON COLUMN order_info.order_time IS '订单时间';
COMMENT ON COLUMN order_info.agent_id IS '代理商ID';
COMMENT ON COLUMN order_info.agent_name IS '供应商名称';
COMMENT ON COLUMN order_info.insert_time IS '插入时间';
COMMENT ON COLUMN order_info.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_info.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_info_order_no ON order_info(order_no);
CREATE INDEX idx_order_info_user_id ON order_info(user_id);
CREATE INDEX idx_order_info_order_status ON order_info(order_status);
CREATE INDEX idx_order_info_order_date ON order_info(order_date);

-- 创建更新时间触发器函数
CREATE OR REPLACE FUNCTION update_last_update_time()
RETURNS TRIGGER AS $$
BEGIN
    NEW.last_update_time = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- 为order_info表创建触发器
CREATE TRIGGER trg_order_info_update_time
    BEFORE UPDATE ON order_info
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 2. 订单商品表
DROP TABLE IF EXISTS order_goods CASCADE;
CREATE TABLE order_goods (
    order_goods_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    user_id VARCHAR(50) DEFAULT NULL,
    user_third_account VARCHAR(50) DEFAULT NULL,
    user_phone VARCHAR(11) DEFAULT NULL,
    goods_id VARCHAR(50) DEFAULT NULL,
    goods_name VARCHAR(50) DEFAULT NULL,
    goods_no VARCHAR(50) DEFAULT NULL,
    goods_sku_id VARCHAR(50) DEFAULT NULL,
    goods_sku_no VARCHAR(50) DEFAULT NULL,
    goods_sku_name VARCHAR(150) DEFAULT NULL,
    goods_pic_url VARCHAR(200) DEFAULT NULL,
    goods_count INTEGER DEFAULT NULL,
    goods_price NUMERIC(10,2) DEFAULT NULL,
    serial_no VARCHAR(50) DEFAULT NULL,
    goods_type SMALLINT DEFAULT 0,
    gift_flag SMALLINT DEFAULT 0,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_goods_id)
);
COMMENT ON TABLE order_goods IS '订单商品';
COMMENT ON COLUMN order_goods.order_goods_id IS 'OrderGoodsId';
COMMENT ON COLUMN order_goods.order_info_id IS '订单ID';
COMMENT ON COLUMN order_goods.order_no IS '订单编号';
COMMENT ON COLUMN order_goods.user_id IS '用户ID';
COMMENT ON COLUMN order_goods.user_third_account IS '用户第三方账号';
COMMENT ON COLUMN order_goods.user_phone IS '用户手机号';
COMMENT ON COLUMN order_goods.goods_id IS '商品ID';
COMMENT ON COLUMN order_goods.goods_name IS '商品名称';
COMMENT ON COLUMN order_goods.goods_no IS '商品编码';
COMMENT ON COLUMN order_goods.goods_sku_id IS '商品SKUID';
COMMENT ON COLUMN order_goods.goods_sku_no IS 'SKU编码';
COMMENT ON COLUMN order_goods.goods_sku_name IS '商户sku名称';
COMMENT ON COLUMN order_goods.goods_pic_url IS '商品图片';
COMMENT ON COLUMN order_goods.goods_count IS '销售数量';
COMMENT ON COLUMN order_goods.goods_price IS '商品原售价';
COMMENT ON COLUMN order_goods.serial_no IS '产品序列号';
COMMENT ON COLUMN order_goods.goods_type IS '商品类型 0 普通商品 1 虚拟商品';
COMMENT ON COLUMN order_goods.gift_flag IS '是否是赠品 0-否 1-是';
COMMENT ON COLUMN order_goods.insert_time IS '插入时间';
COMMENT ON COLUMN order_goods.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_goods.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_goods_order_info_id ON order_goods(order_info_id);
CREATE INDEX idx_order_goods_order_no ON order_goods(order_no);
CREATE INDEX idx_order_goods_goods_id ON order_goods(goods_id);
CREATE INDEX idx_order_goods_goods_sku_id ON order_goods(goods_sku_id);

CREATE TRIGGER trg_order_goods_update_time
    BEFORE UPDATE ON order_goods
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 3. 订单金额表
DROP TABLE IF EXISTS order_amount CASCADE;
CREATE TABLE order_amount (
    order_amount_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    total_amount NUMERIC(10,2) DEFAULT NULL,
    goods_amount NUMERIC(10,2) DEFAULT NULL,
    discount_amount NUMERIC(10,2) DEFAULT NULL,
    discount_after_amount NUMERIC(10,2) DEFAULT NULL,
    postage_amount NUMERIC(10,2) DEFAULT NULL,
    actual_amount NUMERIC(10,2) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_amount_id)
);
COMMENT ON TABLE order_amount IS '订单金额';
COMMENT ON COLUMN order_amount.order_amount_id IS 'OrderAmountId';
COMMENT ON COLUMN order_amount.order_info_id IS '订单信息ID';
COMMENT ON COLUMN order_amount.order_no IS '订单编号';
COMMENT ON COLUMN order_amount.total_amount IS '订单总金额，未打折的所有金额';
COMMENT ON COLUMN order_amount.goods_amount IS '商品总金额，未打折金额';
COMMENT ON COLUMN order_amount.discount_amount IS '优惠金额';
COMMENT ON COLUMN order_amount.discount_after_amount IS '优惠后的金额';
COMMENT ON COLUMN order_amount.postage_amount IS '邮费金额';
COMMENT ON COLUMN order_amount.actual_amount IS '实际金额 优惠后的金额+邮费 最终需要支付的金额';
COMMENT ON COLUMN order_amount.insert_time IS '插入时间';
COMMENT ON COLUMN order_amount.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_amount.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_amount_order_info_id ON order_amount(order_info_id);
CREATE INDEX idx_order_amount_order_no ON order_amount(order_no);

CREATE TRIGGER trg_order_amount_update_time
    BEFORE UPDATE ON order_amount
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 4. 订单优惠表
DROP TABLE IF EXISTS order_discount CASCADE;
CREATE TABLE order_discount (
    order_discount_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    goods_amount NUMERIC(10,2) DEFAULT NULL,
    discount_amount NUMERIC(10,2) DEFAULT NULL,
    discount_after_amount NUMERIC(10,2) DEFAULT NULL,
    user_coupon_ids VARCHAR(500) DEFAULT NULL,
    discount_remark VARCHAR(200) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_discount_id)
);
COMMENT ON TABLE order_discount IS '订单优惠';
COMMENT ON COLUMN order_discount.order_discount_id IS 'OrderDiscountId';
COMMENT ON COLUMN order_discount.order_info_id IS '订单信息ID';
COMMENT ON COLUMN order_discount.order_no IS '订单编号';
COMMENT ON COLUMN order_discount.goods_amount IS '商品总金额';
COMMENT ON COLUMN order_discount.discount_amount IS '优惠金额';
COMMENT ON COLUMN order_discount.discount_after_amount IS '优惠后的金额';
COMMENT ON COLUMN order_discount.user_coupon_ids IS '用户优惠券ID';
COMMENT ON COLUMN order_discount.discount_remark IS '优惠备注 例如：满300减50 *1 现金抵扣券50 *1 限时折扣85折 *1';
COMMENT ON COLUMN order_discount.insert_time IS '插入时间';
COMMENT ON COLUMN order_discount.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_discount.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_discount_order_info_id ON order_discount(order_info_id);
CREATE INDEX idx_order_discount_order_no ON order_discount(order_no);

CREATE TRIGGER trg_order_discount_update_time
    BEFORE UPDATE ON order_discount
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 5. 订单支付表
DROP TABLE IF EXISTS order_pay CASCADE;
CREATE TABLE order_pay (
    order_pay_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    actual_amount NUMERIC(10,2) DEFAULT 0,
    pay_amount NUMERIC(10,2) DEFAULT 0,
    credit_amount NUMERIC(10,2) DEFAULT NULL,
    balance_amount NUMERIC(10,2) DEFAULT NULL,
    pay_status SMALLINT DEFAULT 0,
    third_trade_no VARCHAR(50) DEFAULT NULL,
    third_trade_channel SMALLINT DEFAULT NULL,
    pay_date DATE DEFAULT NULL,
    pay_time TIMESTAMP DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_pay_id)
);
COMMENT ON TABLE order_pay IS '订单支付';
COMMENT ON COLUMN order_pay.order_pay_id IS 'OrderPayId';
COMMENT ON COLUMN order_pay.order_info_id IS '订单信息ID';
COMMENT ON COLUMN order_pay.order_no IS '订单编号';
COMMENT ON COLUMN order_pay.actual_amount IS '实际金额，实际需要支付的金额';
COMMENT ON COLUMN order_pay.pay_amount IS '支付金额';
COMMENT ON COLUMN order_pay.credit_amount IS '支付积分';
COMMENT ON COLUMN order_pay.balance_amount IS '支付余额';
COMMENT ON COLUMN order_pay.pay_status IS '支付状态 0：未支付，1：支付中，2：已支付';
COMMENT ON COLUMN order_pay.third_trade_no IS '第三方交易号';
COMMENT ON COLUMN order_pay.third_trade_channel IS '第三方支付渠道 0 微信 1支付宝 2抖音 3银联';
COMMENT ON COLUMN order_pay.pay_date IS '支付日期';
COMMENT ON COLUMN order_pay.pay_time IS '支付时间';
COMMENT ON COLUMN order_pay.insert_time IS '插入时间';
COMMENT ON COLUMN order_pay.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_pay.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_pay_order_info_id ON order_pay(order_info_id);
CREATE INDEX idx_order_pay_order_no ON order_pay(order_no);
CREATE INDEX idx_order_pay_pay_status ON order_pay(pay_status);
CREATE INDEX idx_order_pay_third_trade_no ON order_pay(third_trade_no);

CREATE TRIGGER trg_order_pay_update_time
    BEFORE UPDATE ON order_pay
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 6. 订单发货表
DROP TABLE IF EXISTS order_deliver CASCADE;
CREATE TABLE order_deliver (
    order_deliver_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    express_no VARCHAR(50) DEFAULT NULL,
    express_company_code VARCHAR(50) DEFAULT NULL,
    express_company VARCHAR(50) DEFAULT NULL,
    shop_id VARCHAR(50) DEFAULT NULL,
    shop_name VARCHAR(50) DEFAULT NULL,
    emp_id VARCHAR(50) DEFAULT NULL,
    emp_name VARCHAR(50) DEFAULT NULL,
    delivered_date DATE DEFAULT NULL,
    delivered_time TIMESTAMP DEFAULT NULL,
    recipients_name VARCHAR(50) DEFAULT NULL,
    recipients_phone VARCHAR(50) DEFAULT NULL,
    recipients_address_id VARCHAR(50) DEFAULT NULL,
    address VARCHAR(200) DEFAULT NULL,
    area VARCHAR(50) DEFAULT NULL,
    city VARCHAR(50) DEFAULT NULL,
    province VARCHAR(50) DEFAULT NULL,
    sort SMALLINT DEFAULT NULL,
    status SMALLINT DEFAULT NULL,
    receive_time TIMESTAMP DEFAULT NULL,
    postage_amount NUMERIC(10,2) DEFAULT 0,
    postage_template_id VARCHAR(50) DEFAULT NULL,
    postage_template_name VARCHAR(50) DEFAULT NULL,
    subscript_status SMALLINT DEFAULT NULL,
    remark VARCHAR(200) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_deliver_id)
);
COMMENT ON TABLE order_deliver IS '订单发货';
COMMENT ON COLUMN order_deliver.order_deliver_id IS 'OrderDeliverId';
COMMENT ON COLUMN order_deliver.order_info_id IS '订单ID';
COMMENT ON COLUMN order_deliver.order_no IS '订单编号';
COMMENT ON COLUMN order_deliver.express_no IS '快递单号';
COMMENT ON COLUMN order_deliver.express_company_code IS '快递公司编码';
COMMENT ON COLUMN order_deliver.express_company IS '快递公司';
COMMENT ON COLUMN order_deliver.shop_id IS '发货门店ID';
COMMENT ON COLUMN order_deliver.shop_name IS '发货门店名称';
COMMENT ON COLUMN order_deliver.emp_id IS '发货人ID';
COMMENT ON COLUMN order_deliver.emp_name IS '发货人名称';
COMMENT ON COLUMN order_deliver.delivered_date IS '发货日期';
COMMENT ON COLUMN order_deliver.delivered_time IS '发货时间';
COMMENT ON COLUMN order_deliver.recipients_name IS '收货人名称';
COMMENT ON COLUMN order_deliver.recipients_phone IS '收货人手机号';
COMMENT ON COLUMN order_deliver.recipients_address_id IS '收货地址的ID';
COMMENT ON COLUMN order_deliver.address IS '具体收货地址';
COMMENT ON COLUMN order_deliver.area IS '地区';
COMMENT ON COLUMN order_deliver.city IS '城市';
COMMENT ON COLUMN order_deliver.province IS '省份';
COMMENT ON COLUMN order_deliver.sort IS '排序';
COMMENT ON COLUMN order_deliver.status IS '状态 0:待签收 1已签收';
COMMENT ON COLUMN order_deliver.receive_time IS '收货时间';
COMMENT ON COLUMN order_deliver.postage_amount IS '快递费用';
COMMENT ON COLUMN order_deliver.postage_template_id IS '快递费用模板ID';
COMMENT ON COLUMN order_deliver.postage_template_name IS '快递费用模板名称';
COMMENT ON COLUMN order_deliver.subscript_status IS '订阅状态 0 未订阅 1已订阅';
COMMENT ON COLUMN order_deliver.remark IS '备注';
COMMENT ON COLUMN order_deliver.insert_time IS '插入时间';
COMMENT ON COLUMN order_deliver.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_deliver.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_deliver_order_info_id ON order_deliver(order_info_id);
CREATE INDEX idx_order_deliver_order_no ON order_deliver(order_no);
CREATE INDEX idx_order_deliver_express_no ON order_deliver(express_no);

CREATE TRIGGER trg_order_deliver_update_time
    BEFORE UPDATE ON order_deliver
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 7. 订单发货商品表
DROP TABLE IF EXISTS order_deliver_goods CASCADE;
CREATE TABLE order_deliver_goods (
    order_deliver_goods_id VARCHAR(50) NOT NULL,
    order_deliver_id VARCHAR(50) DEFAULT NULL,
    goods_id VARCHAR(50) DEFAULT NULL,
    goods_name VARCHAR(50) DEFAULT NULL,
    goods_no VARCHAR(50) DEFAULT NULL,
    goods_sku_id VARCHAR(50) DEFAULT NULL,
    goods_sku_name VARCHAR(150) DEFAULT NULL,
    goods_sku_no VARCHAR(50) DEFAULT NULL,
    goods_count INTEGER DEFAULT NULL,
    goods_pic_url VARCHAR(200) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_deliver_goods_id)
);
COMMENT ON TABLE order_deliver_goods IS '订单发货商品';
COMMENT ON COLUMN order_deliver_goods.order_deliver_goods_id IS 'OrderDeliverGoodsId';
COMMENT ON COLUMN order_deliver_goods.order_deliver_id IS '发货ID';
COMMENT ON COLUMN order_deliver_goods.goods_id IS '商品ID';
COMMENT ON COLUMN order_deliver_goods.goods_name IS '商品名称';
COMMENT ON COLUMN order_deliver_goods.goods_no IS '商品编号';
COMMENT ON COLUMN order_deliver_goods.goods_sku_id IS '商品SKUID';
COMMENT ON COLUMN order_deliver_goods.goods_sku_name IS '商品SKU名称';
COMMENT ON COLUMN order_deliver_goods.goods_sku_no IS '商品SKU编号';
COMMENT ON COLUMN order_deliver_goods.goods_count IS '商品数量';
COMMENT ON COLUMN order_deliver_goods.goods_pic_url IS '商品图片URL';
COMMENT ON COLUMN order_deliver_goods.insert_time IS '插入时间';
COMMENT ON COLUMN order_deliver_goods.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_deliver_goods.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_deliver_goods_order_deliver_id ON order_deliver_goods(order_deliver_id);
CREATE INDEX idx_order_deliver_goods_goods_id ON order_deliver_goods(goods_id);

CREATE TRIGGER trg_order_deliver_goods_update_time
    BEFORE UPDATE ON order_deliver_goods
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 8. 订单提货表
DROP TABLE IF EXISTS order_pickup CASCADE;
CREATE TABLE order_pickup (
    order_pickup_id VARCHAR(50) NOT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    pickup_location_id VARCHAR(50) DEFAULT NULL,
    pickup_code VARCHAR(50) DEFAULT NULL,
    pickup_user VARCHAR(50) DEFAULT NULL,
    pickup_phone VARCHAR(50) DEFAULT NULL,
    pickup_time TIMESTAMP DEFAULT NULL,
    pickup_status INTEGER DEFAULT 0,
    pickup_remark VARCHAR(255) DEFAULT NULL,
    province VARCHAR(100) DEFAULT NULL,
    city VARCHAR(100) DEFAULT NULL,
    area VARCHAR(100) DEFAULT NULL,
    address VARCHAR(100) DEFAULT NULL,
    address_info VARCHAR(100) DEFAULT NULL,
    link_man VARCHAR(100) DEFAULT NULL,
    link_phone VARCHAR(100) DEFAULT NULL,
    longitude VARCHAR(100) DEFAULT NULL,
    latitude VARCHAR(100) DEFAULT NULL,
    received_amount NUMERIC(10,2) DEFAULT NULL,
    deliver_id VARCHAR(50) DEFAULT NULL,
    deliver_name VARCHAR(50) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_pickup_id)
);
COMMENT ON TABLE order_pickup IS '订单提货';
COMMENT ON COLUMN order_pickup.order_pickup_id IS 'OrderPickupId';
COMMENT ON COLUMN order_pickup.order_info_id IS '订单Id';
COMMENT ON COLUMN order_pickup.order_no IS '订单编号';
COMMENT ON COLUMN order_pickup.pickup_location_id IS '提货点Id';
COMMENT ON COLUMN order_pickup.pickup_code IS '提货码';
COMMENT ON COLUMN order_pickup.pickup_user IS '提货人';
COMMENT ON COLUMN order_pickup.pickup_phone IS '提货人电话';
COMMENT ON COLUMN order_pickup.pickup_time IS '提货时间';
COMMENT ON COLUMN order_pickup.pickup_status IS '提货状态 0待提货 1已提货 2已取消';
COMMENT ON COLUMN order_pickup.pickup_remark IS '提货备注';
COMMENT ON COLUMN order_pickup.province IS '省';
COMMENT ON COLUMN order_pickup.city IS '市';
COMMENT ON COLUMN order_pickup.area IS '区';
COMMENT ON COLUMN order_pickup.address IS '详细地址';
COMMENT ON COLUMN order_pickup.address_info IS '提货点完整地址';
COMMENT ON COLUMN order_pickup.link_man IS '联系人';
COMMENT ON COLUMN order_pickup.link_phone IS '联系电话';
COMMENT ON COLUMN order_pickup.longitude IS '经度';
COMMENT ON COLUMN order_pickup.latitude IS '纬度';
COMMENT ON COLUMN order_pickup.received_amount IS '实收金额';
COMMENT ON COLUMN order_pickup.deliver_id IS '发货人ID';
COMMENT ON COLUMN order_pickup.deliver_name IS '发货人姓名';
COMMENT ON COLUMN order_pickup.insert_time IS '插入时间';
COMMENT ON COLUMN order_pickup.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_pickup.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_pickup_order_info_id ON order_pickup(order_info_id);
CREATE INDEX idx_order_pickup_order_no ON order_pickup(order_no);
CREATE INDEX idx_order_pickup_pickup_code ON order_pickup(pickup_code);

CREATE TRIGGER trg_order_pickup_update_time
    BEFORE UPDATE ON order_pickup
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 9. 提货点信息表
DROP TABLE IF EXISTS pickup_location CASCADE;
CREATE TABLE pickup_location (
    pickup_location_id VARCHAR(50) NOT NULL,
    location_name VARCHAR(100) DEFAULT NULL,
    province VARCHAR(100) DEFAULT NULL,
    city VARCHAR(100) DEFAULT NULL,
    area VARCHAR(100) DEFAULT NULL,
    address VARCHAR(100) DEFAULT NULL,
    address_info VARCHAR(100) DEFAULT NULL,
    link_man VARCHAR(100) DEFAULT NULL,
    link_phone VARCHAR(100) DEFAULT NULL,
    business_hours VARCHAR(100) DEFAULT NULL,
    longitude VARCHAR(100) DEFAULT NULL,
    latitude VARCHAR(100) DEFAULT NULL,
    forbidden_flag SMALLINT DEFAULT 0,
    merchant_id VARCHAR(50) DEFAULT NULL,
    merchant_name VARCHAR(100) DEFAULT NULL,
    agent_id VARCHAR(50) DEFAULT NULL,
    agent_name VARCHAR(100) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (pickup_location_id)
);
COMMENT ON TABLE pickup_location IS '提货点信息';
COMMENT ON COLUMN pickup_location.pickup_location_id IS 'PickupLocationId';
COMMENT ON COLUMN pickup_location.location_name IS '提货点名称';
COMMENT ON COLUMN pickup_location.province IS '省';
COMMENT ON COLUMN pickup_location.city IS '市';
COMMENT ON COLUMN pickup_location.area IS '区';
COMMENT ON COLUMN pickup_location.address IS '详细地址';
COMMENT ON COLUMN pickup_location.address_info IS '提货点完整地址';
COMMENT ON COLUMN pickup_location.link_man IS '联系人';
COMMENT ON COLUMN pickup_location.link_phone IS '联系电话';
COMMENT ON COLUMN pickup_location.business_hours IS '营业时间';
COMMENT ON COLUMN pickup_location.longitude IS '经度';
COMMENT ON COLUMN pickup_location.latitude IS '纬度';
COMMENT ON COLUMN pickup_location.forbidden_flag IS '禁用状态 0可用，1禁用';
COMMENT ON COLUMN pickup_location.merchant_id IS '门店ID';
COMMENT ON COLUMN pickup_location.merchant_name IS '门店名称';
COMMENT ON COLUMN pickup_location.agent_id IS '代理商ID';
COMMENT ON COLUMN pickup_location.agent_name IS '代理商名称';
COMMENT ON COLUMN pickup_location.insert_time IS '插入时间';
COMMENT ON COLUMN pickup_location.last_update_time IS '最后更新时间';
COMMENT ON COLUMN pickup_location.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_pickup_location_location_name ON pickup_location(location_name);

CREATE TRIGGER trg_pickup_location_update_time
    BEFORE UPDATE ON pickup_location
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 10. 订单退款表
DROP TABLE IF EXISTS order_refund CASCADE;
CREATE TABLE order_refund (
    order_refund_id VARCHAR(50) NOT NULL,
    order_refund_no VARCHAR(50) DEFAULT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    order_pay_id VARCHAR(50) DEFAULT NULL,
    user_id VARCHAR(50) DEFAULT NULL,
    user_phone VARCHAR(50) DEFAULT NULL,
    refund_type SMALLINT DEFAULT 0,
    refund_source SMALLINT DEFAULT 0,
    refund_status SMALLINT DEFAULT 0,
    refund_channel SMALLINT DEFAULT 0,
    refund_reason_type INTEGER DEFAULT 0,
    refund_reason VARCHAR(200) DEFAULT NULL,
    apply_remark VARCHAR(200) DEFAULT NULL,
    audit_remark VARCHAR(200) DEFAULT NULL,
    handle_remark VARCHAR(200) DEFAULT NULL,
    refund_amount NUMERIC(10,2) DEFAULT 0,
    refund_freight_amount NUMERIC(10,2) DEFAULT 0,
    refund_credit_amount NUMERIC(10,2) DEFAULT 0,
    refund_coupon_amount NUMERIC(10,2) DEFAULT 0,
    refund_evidence_pics VARCHAR(500) DEFAULT NULL,
    return_express_company VARCHAR(100) DEFAULT NULL,
    return_express_no VARCHAR(50) DEFAULT NULL,
    auditor_id VARCHAR(50) DEFAULT NULL,
    auditor_name VARCHAR(50) DEFAULT NULL,
    audit_time TIMESTAMP DEFAULT NULL,
    handler_id VARCHAR(50) DEFAULT NULL,
    handler_name VARCHAR(50) DEFAULT NULL,
    handle_time TIMESTAMP DEFAULT NULL,
    refund_trade_no VARCHAR(50) DEFAULT NULL,
    refund_complete_time TIMESTAMP DEFAULT NULL,
    receive_confirm_time TIMESTAMP DEFAULT NULL,
    contact_phone VARCHAR(50) DEFAULT NULL,
    contact_name VARCHAR(50) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_refund_id)
);
COMMENT ON TABLE order_refund IS '订单退款';
COMMENT ON COLUMN order_refund.order_refund_id IS 'OrderRefundId';
COMMENT ON COLUMN order_refund.order_refund_no IS '退款单号';
COMMENT ON COLUMN order_refund.order_info_id IS '订单信息ID';
COMMENT ON COLUMN order_refund.order_no IS '订单编号';
COMMENT ON COLUMN order_refund.order_pay_id IS '支付记录ID';
COMMENT ON COLUMN order_refund.user_id IS '用户ID';
COMMENT ON COLUMN order_refund.user_phone IS '用户电话';
COMMENT ON COLUMN order_refund.refund_type IS '退款类型 0 仅退款 1 退货退款';
COMMENT ON COLUMN order_refund.refund_source IS '退款来源 0 用户申请 1 商家发起 2 系统发起';
COMMENT ON COLUMN order_refund.refund_status IS '退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭';
COMMENT ON COLUMN order_refund.refund_channel IS '退款渠道 0 原路退回 1 退至余额 2 线下打款';
COMMENT ON COLUMN order_refund.refund_reason_type IS '退款原因类型';
COMMENT ON COLUMN order_refund.refund_reason IS '退款原因说明';
COMMENT ON COLUMN order_refund.apply_remark IS '退款申请备注（用户填写）';
COMMENT ON COLUMN order_refund.audit_remark IS '退款审核备注（客服填写）';
COMMENT ON COLUMN order_refund.handle_remark IS '退款处理备注（财务填写）';
COMMENT ON COLUMN order_refund.refund_amount IS '退款申请金额';
COMMENT ON COLUMN order_refund.refund_freight_amount IS '退款运费金额';
COMMENT ON COLUMN order_refund.refund_credit_amount IS '退款积分抵扣金额';
COMMENT ON COLUMN order_refund.refund_coupon_amount IS '退款优惠券抵扣金额';
COMMENT ON COLUMN order_refund.refund_evidence_pics IS '退款凭证图片，多个以逗号分隔';
COMMENT ON COLUMN order_refund.return_express_company IS '退回物流公司';
COMMENT ON COLUMN order_refund.return_express_no IS '退回物流单号';
COMMENT ON COLUMN order_refund.auditor_id IS '审核人ID';
COMMENT ON COLUMN order_refund.auditor_name IS '审核人姓名';
COMMENT ON COLUMN order_refund.audit_time IS '审核时间';
COMMENT ON COLUMN order_refund.handler_id IS '处理人ID';
COMMENT ON COLUMN order_refund.handler_name IS '处理人姓名';
COMMENT ON COLUMN order_refund.handle_time IS '处理时间';
COMMENT ON COLUMN order_refund.refund_trade_no IS '退款交易号';
COMMENT ON COLUMN order_refund.refund_complete_time IS '退款完成时间';
COMMENT ON COLUMN order_refund.receive_confirm_time IS '用户收货确认时间（用于退货退款）';
COMMENT ON COLUMN order_refund.contact_phone IS '联系电话';
COMMENT ON COLUMN order_refund.contact_name IS '联系人';
COMMENT ON COLUMN order_refund.insert_time IS '插入时间';
COMMENT ON COLUMN order_refund.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_refund.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_refund_order_refund_no ON order_refund(order_refund_no);
CREATE INDEX idx_order_refund_order_info_id ON order_refund(order_info_id);
CREATE INDEX idx_order_refund_order_no ON order_refund(order_no);
CREATE INDEX idx_order_refund_refund_status ON order_refund(refund_status);

CREATE TRIGGER trg_order_refund_update_time
    BEFORE UPDATE ON order_refund
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

-- 11. 订单退款商品表
DROP TABLE IF EXISTS order_refund_goods CASCADE;
CREATE TABLE order_refund_goods (
    order_refund_goods_id VARCHAR(50) NOT NULL,
    order_refund_id VARCHAR(50) DEFAULT NULL,
    order_info_id VARCHAR(50) DEFAULT NULL,
    order_no VARCHAR(50) DEFAULT NULL,
    order_goods_id VARCHAR(50) DEFAULT NULL,
    goods_id VARCHAR(50) DEFAULT NULL,
    goods_sku_id VARCHAR(50) DEFAULT NULL,
    goods_name VARCHAR(150) DEFAULT NULL,
    goods_sku_name VARCHAR(200) DEFAULT NULL,
    goods_pic VARCHAR(200) DEFAULT NULL,
    goods_spec_json TEXT DEFAULT NULL,
    goods_price NUMERIC(10,2) DEFAULT NULL,
    goods_actual_price NUMERIC(10,2) DEFAULT NULL,
    refund_real_amount NUMERIC(10,2) DEFAULT 0,
    return_quantity INTEGER DEFAULT NULL,
    return_finish_time TIMESTAMP DEFAULT NULL,
    express_company VARCHAR(100) DEFAULT NULL,
    express_company_code VARCHAR(100) DEFAULT NULL,
    express_no VARCHAR(100) DEFAULT NULL,
    remark VARCHAR(200) DEFAULT NULL,
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted SMALLINT NOT NULL DEFAULT 0,
    PRIMARY KEY (order_refund_goods_id)
);
COMMENT ON TABLE order_refund_goods IS '订单退款商品';
COMMENT ON COLUMN order_refund_goods.order_refund_goods_id IS 'OrderRefundGoodsId';
COMMENT ON COLUMN order_refund_goods.order_refund_id IS '退款记录ID';
COMMENT ON COLUMN order_refund_goods.order_info_id IS '订单信息ID';
COMMENT ON COLUMN order_refund_goods.order_no IS '订单编号';
COMMENT ON COLUMN order_refund_goods.order_goods_id IS '订单商品记录ID';
COMMENT ON COLUMN order_refund_goods.goods_id IS '商品ID';
COMMENT ON COLUMN order_refund_goods.goods_sku_id IS '商品SKU ID';
COMMENT ON COLUMN order_refund_goods.goods_name IS '商品名称';
COMMENT ON COLUMN order_refund_goods.goods_sku_name IS '商品SKU 名称';
COMMENT ON COLUMN order_refund_goods.goods_pic IS '商品图片';
COMMENT ON COLUMN order_refund_goods.goods_spec_json IS '商品规格JSON（用于回显）';
COMMENT ON COLUMN order_refund_goods.goods_price IS '商品单价';
COMMENT ON COLUMN order_refund_goods.goods_actual_price IS '商品实际支付单价';
COMMENT ON COLUMN order_refund_goods.refund_real_amount IS '实际退款金额';
COMMENT ON COLUMN order_refund_goods.return_quantity IS '退货数量';
COMMENT ON COLUMN order_refund_goods.return_finish_time IS '退货完成时间';
COMMENT ON COLUMN order_refund_goods.express_company IS '快递公司';
COMMENT ON COLUMN order_refund_goods.express_company_code IS '快递公司代码';
COMMENT ON COLUMN order_refund_goods.express_no IS '快递单号';
COMMENT ON COLUMN order_refund_goods.remark IS '备注';
COMMENT ON COLUMN order_refund_goods.insert_time IS '插入时间';
COMMENT ON COLUMN order_refund_goods.last_update_time IS '最后更新时间';
COMMENT ON COLUMN order_refund_goods.deleted IS '删除标记，0否 1是';

CREATE INDEX idx_order_refund_goods_order_refund_id ON order_refund_goods(order_refund_id);
CREATE INDEX idx_order_refund_goods_order_info_id ON order_refund_goods(order_info_id);
CREATE INDEX idx_order_refund_goods_order_no ON order_refund_goods(order_no);
CREATE INDEX idx_order_refund_goods_goods_id ON order_refund_goods(goods_id);

CREATE TRIGGER trg_order_refund_goods_update_time
    BEFORE UPDATE ON order_refund_goods
    FOR EACH ROW
    EXECUTE FUNCTION update_last_update_time();

