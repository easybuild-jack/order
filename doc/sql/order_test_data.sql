-- ============================================================
-- 订单测试数据 - PostgreSQL版本
-- 包含：订单信息表(order_info) + 订单商品表(order_goods)
-- 生成时间: 2026-01-29
-- ============================================================

-- 1. 订单信息表测试数据
-- 插入5个测试订单，涵盖不同状态和场景

-- 订单1: 已支付待发货的普通订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1001', 'ORD20260129001', 'U10001', 'wx_openid_001', '13800138001', '张三',
    'iPhone 15 Pro', '深空黑色 256GB', 'https://example.com/iphone15pro.jpg', 1,
    8999.00, 8499.00, 1, 0,
    0, 0.00, '请尽快发货', 2,
    'mall', 'iOS', 1, '优先处理',
    0, 'M001', '苹果官方旗舰店', '贵宾客户',
    '2026-01-29', '2026-01-29 10:30:00', 'A001', '北京代理商',
    NULL, NULL, NULL, NULL,
    NULL, NULL, '2026-01-29 10:30:00', '2026-01-29 10:30:00', 0
);

-- 订单2: 已完成的自提订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1002', 'ORD20260128001', 'U10002', 'wx_openid_002', '13800138002', '李四',
    '小米14 Ultra', '白色 512GB', 'https://example.com/mi14ultra.jpg', 1,
    5999.00, 5699.00, 0, 1,
    0, 0.00, '下班后来取', 4,
    'app', 'Android', 1, '已自提',
    1, 'M002', '小米专卖店', NULL,
    '2026-01-28', '2026-01-28 14:20:00', 'A001', '北京代理商',
    NULL, NULL, 'PL001', '朝阳区自提点',
    NULL, NULL, '2026-01-28 14:20:00', '2026-01-28 16:45:00', 0
);

-- 订单3: 待支付订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1003', 'ORD20260129002', 'U10003', 'alipay_userid_003', '13800138003', '王五',
    'MacBook Pro 14', 'M3 Pro 18GB 512GB 深空灰', 'https://example.com/macbook.jpg', 1,
    15999.00, 15499.00, 1, 0,
    0, 0.00, NULL, 0,
    'mall', 'Web', 0, NULL,
    0, 'M001', '苹果官方旗舰店', NULL,
    '2026-01-29', '2026-01-29 11:15:00', 'A002', '上海代理商',
    NULL, NULL, NULL, NULL,
    NULL, NULL, '2026-01-29 11:15:00', '2026-01-29 11:15:00', 0
);

-- 订单4: 已取消订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1004', 'ORD20260127001', 'U10004', 'wx_openid_004', '13800138004', '赵六',
    'HUAWEI Mate 60 Pro', '雅川青 12GB+512GB', 'https://example.com/mate60.jpg', 1,
    6999.00, 6799.00, 1, 0,
    0, 0.00, '拍错了', 1,
    'wechat', 'WeChat', 0, NULL,
    0, 'M003', '华为授权店', NULL,
    '2026-01-27', '2026-01-27 09:30:00', 'A003', '深圳代理商',
    '用户主动取消', '2026-01-27 09:45:00', NULL, NULL,
    NULL, NULL, '2026-01-27 09:30:00', '2026-01-27 09:45:00', 0
);

-- 订单5: 部分退款的已完成订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1005', 'ORD20260126001', 'U10005', 'wx_openid_005', '13800138005', '孙七',
    'iPad Pro 11', '深空灰色 256GB WIFI版', 'https://example.com/ipadpro.jpg', 2,
    6998.00, 6598.00, 1, 1,
    2, 299.00, '多买了一件', 4,
    'mall', 'iOS', 1, '部分退款已处理',
    1, 'M001', '苹果官方旗舰店', NULL,
    '2026-01-26', '2026-01-26 15:30:00', 'A001', '北京代理商',
    NULL, NULL, NULL, NULL,
    NULL, NULL, '2026-01-26 15:30:00', '2026-01-27 10:20:00', 0
);

-- 订单6: 送到货柜的订单
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1006', 'ORD20260129003', 'U10006', 'alipay_userid_006', '13800138006', '周八',
    '索尼耳机', 'WH-1000XM5 黑色', 'https://example.com/sony_wh1000xm5.jpg', 1,
    2299.00, 2099.00, 99, 0,
    0, 0.00, '请放到货柜A区', 3,
    'app', 'Android', 1, '已送达货柜',
    0, 'M004', '索尼官方店', NULL,
    '2026-01-29', '2026-01-29 08:00:00', 'A002', '上海代理商',
    NULL, NULL, NULL, NULL,
    'C001', '办公楼1号货柜', '2026-01-29 08:00:00', '2026-01-29 09:30:00', 0
);

-- 2. 订单商品表测试数据
-- 对应上述订单，添加详细的商品信息

-- 订单1的商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1001', '1001',
    'G001', 'iPhone 15 Pro', 'IP15P001', 'SKU001', 'IPSKU001', '深空黑色 256GB',
    'https://example.com/iphone15pro.jpg', 1, 8999.00, NULL, 0, 0,
    '2026-01-29 10:30:00', '2026-01-29 10:30:00', 0
);

-- 订单2的商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1002', '1002',
    'G002', '小米14 Ultra', 'MI14U001', 'SKU002', 'MISKU002', '白色 512GB',
    'https://example.com/mi14ultra.jpg', 1, 5999.00, NULL, 0, 0,
    '2026-01-28 14:20:00', '2026-01-28 14:20:00', 0
);

-- 订单3的商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1003', '1003',
    'G003', 'MacBook Pro 14', 'MBP14001', 'SKU003', 'MBSKU003', 'M3 Pro 18GB 512GB 深空灰',
    'https://example.com/macbook.jpg', 1, 15999.00, NULL, 0, 0,
    '2026-01-29 11:15:00', '2026-01-29 11:15:00', 0
);

-- 订单4的商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1004', '1004',
    'G004', 'HUAWEI Mate 60 Pro', 'HW60P001', 'SKU004', 'HWSKU004', '雅川青 12GB+512GB',
    'https://example.com/mate60.jpg', 1, 6999.00, NULL, 0, 0,
    '2026-01-27 09:30:00', '2026-01-27 09:30:00', 0
);

-- 订单5的商品（包含2件商品，其中1件退款）
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1005', '1005',
    'G005', 'iPad Pro 11', 'IPD11001', 'SKU005', 'IPDSKU005', '深空灰色 256GB WIFI版',
    'https://example.com/ipadpro.jpg', 2, 3499.00, NULL, 0, 0,
    '2026-01-26 15:30:00', '2026-01-26 15:30:00', 0
);

-- 订单5的赠品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1006', '1005',
    'G006', 'Apple Pencil', 'APENC001', 'SKU006', 'PENCILSKU001', 'Apple Pencil 第二代',
    'https://example.com/apple_pencil.jpg', 2, 0.00, NULL, 0, 1,
    '2026-01-26 15:30:00', '2026-01-26 15:30:00', 0
);

-- 订单6的商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1007', '1006',
    'G007', '索尼耳机', 'SONY001', 'SKU007', 'SONYSKU001', 'WH-1000XM5 黑色',
    'https://example.com/sony_wh1000xm5.jpg', 1, 2299.00, NULL, 0, 0,
    '2026-01-29 08:00:00', '2026-01-29 08:00:00', 0
);

-- 额外示例：多商品订单
-- 订单7的主订单信息
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1007', 'ORD20260129004', 'U10007', 'wx_openid_007', '13800138007', '吴九',
    '数码配件套装', '多件商品', 'https://example.com/accessories.jpg', 4,
    1697.00, 1497.00, 1, 0,
    0, 0.00, '麻烦包装仔细一点', 2,
    'mall', 'iOS', 1, NULL,
    0, 'M005', '数码配件专营店', NULL,
    '2026-01-29', '2026-01-29 13:20:00', 'A001', '北京代理商',
    NULL, NULL, NULL, NULL,
    NULL, NULL, '2026-01-29 13:20:00', '2026-01-29 13:20:00', 0
);

-- 订单7的多个商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES 
(
    'OG1008', '1007',
    'G008', '无线充电器', 'WC001', 'SKU008', 'WCSKU001', '20W快充版',
    'https://example.com/wireless_charger.jpg', 1, 199.00, NULL, 0, 0,
    '2026-01-29 13:20:00', '2026-01-29 13:20:00', 0
),
(
    'OG1009', '1007',
    'G009', 'Type-C数据线', 'TC001', 'SKU009', 'TCSKU001', '1.5米编织线',
    'https://example.com/typec_cable.jpg', 2, 49.00, NULL, 0, 0,
    '2026-01-29 13:20:00', '2026-01-29 13:20:00', 0
),
(
    'OG1010', '1007',
    'G010', '手机壳', 'CASE001', 'SKU010', 'CASESKU001', '硅胶透明保护壳',
    'https://example.com/phone_case.jpg', 1, 89.00, NULL, 0, 0,
    '2026-01-29 13:20:00', '2026-01-29 13:20:00', 0
);

-- 虚拟商品订单示例
-- 订单8：虚拟商品（充值卡）
INSERT INTO order_info (
    order_id, order_no, user_id, user_third_account, user_phone, user_name,
    goods_name, goods_sku_name, goods_pic, goods_count,
    total_amount, actual_pay_amount, dispatch_type, invoice_flag,
    refund_status, refund_amount, user_remark, order_status,
    order_channel, client_type, push_flag, order_remark,
    statistics_flag, merchant_id, merchant_name, merchant_remark,
    order_date, order_time, agent_id, agent_name,
    cancel_remark, cancel_time, pickup_location_id, pickup_location_name,
    container_id, container_name, insert_time, last_update_time, deleted
) VALUES (
    '1008', 'ORD20260129005', 'U10008', 'alipay_userid_008', '13800138008', '郑十',
    'App Store充值卡', '500元面值', 'https://example.com/appstore_card.jpg', 1,
    500.00, 480.00, 2, 0,
    0, 0.00, NULL, 4,
    'app', 'iOS', 1, '已自动发货',
    1, 'M006', '数字商品专营', NULL,
    '2026-01-29', '2026-01-29 14:00:00', NULL, NULL,
    NULL, NULL, NULL, NULL,
    NULL, NULL, '2026-01-29 14:00:00', '2026-01-29 14:00:05', 0
);

-- 订单8的虚拟商品
INSERT INTO order_goods (
    order_goods_id, order_id,
    goods_id, goods_name, goods_no, goods_sku_id, goods_sku_no, goods_sku_name,
    goods_pic_url, goods_count, goods_price, serial_no, goods_type, gift_flag,
    insert_time, last_update_time, deleted
) VALUES (
    'OG1011', '1008',
    'G011', 'App Store充值卡', 'ASC500', 'SKU011', 'ASCSKU500', '500元面值',
    'https://example.com/appstore_card.jpg', 1, 500.00, 'ASC500-2026012900001', 1, 0,
    '2026-01-29 14:00:00', '2026-01-29 14:00:00', 0
);

-- 数据统计查询示例
-- 查看订单数量
-- SELECT order_status, COUNT(*) as count FROM order_info WHERE deleted = 0 GROUP BY order_status;

-- 查看订单总金额
-- SELECT SUM(actual_pay_amount) as total_amount FROM order_info WHERE deleted = 0 AND order_status IN (2,3,4);

-- 查看订单商品明细
-- SELECT oi.order_no, oi.user_name, og.goods_name, og.goods_sku_name, og.goods_count, og.goods_price 
-- FROM order_info oi 
-- INNER JOIN order_goods og ON oi.order_id = og.order_id
-- WHERE oi.deleted = 0 AND og.deleted = 0;
