-- ============================================================
-- 订单信息表字段变更脚本
-- 变更说明: 
--   1. 删除存货点字段(store_id, store_name)，新增提货点和货柜字段
--   2. 新增用户名称字段(user_name)
--   3. 删除订单类型字段(order_type)
--   4. 修改订单渠道(order_channel)和客户端类型(client_type)为VARCHAR类型
--   5. 删除取消原因类型字段(cancel_reason_type)
-- 变更时间: 2026-01-29
-- ============================================================

-- ============================================================
-- MySQL 版本
-- ============================================================

-- 删除旧字段（如果存在）
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `store_id`;
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `store_name`;
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `order_type`;
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `cancel_reason_type`;

-- 新增用户名称
ALTER TABLE `order_info` ADD COLUMN `user_name` VARCHAR(50) DEFAULT NULL COMMENT '用户名称';

-- 新增提货点ID
ALTER TABLE `order_info` ADD COLUMN `pickup_location_id` VARCHAR(50) DEFAULT NULL COMMENT '提货点ID';

-- 新增提货点名称
ALTER TABLE `order_info` ADD COLUMN `pickup_location_name` VARCHAR(100) DEFAULT NULL COMMENT '提货点名称';

-- 新增货柜ID
ALTER TABLE `order_info` ADD COLUMN `container_id` VARCHAR(50) DEFAULT NULL COMMENT '货柜ID';

-- 新增货柜名称
ALTER TABLE `order_info` ADD COLUMN `container_name` VARCHAR(100) DEFAULT NULL COMMENT '货柜名称';

-- 修改订单渠道字段类型
ALTER TABLE `order_info` MODIFY COLUMN `order_channel` VARCHAR(50) DEFAULT NULL COMMENT '订单渠道';

-- 修改客户端类型字段类型
ALTER TABLE `order_info` MODIFY COLUMN `client_type` VARCHAR(50) DEFAULT NULL COMMENT '客户端类型';


-- ============================================================
-- PostgreSQL 版本
-- ============================================================

-- 删除旧字段（如果存在）
-- ALTER TABLE order_info DROP COLUMN IF EXISTS store_id;
-- ALTER TABLE order_info DROP COLUMN IF EXISTS store_name;
-- ALTER TABLE order_info DROP COLUMN IF EXISTS order_type;
-- ALTER TABLE order_info DROP COLUMN IF EXISTS cancel_reason_type;

-- 新增用户名称
-- ALTER TABLE order_info ADD COLUMN user_name VARCHAR(50) DEFAULT NULL;
-- COMMENT ON COLUMN order_info.user_name IS '用户名称';

-- 新增提货点ID
-- ALTER TABLE order_info ADD COLUMN pickup_location_id VARCHAR(50) DEFAULT NULL;
-- COMMENT ON COLUMN order_info.pickup_location_id IS '提货点ID';

-- 新增提货点名称
-- ALTER TABLE order_info ADD COLUMN pickup_location_name VARCHAR(100) DEFAULT NULL;
-- COMMENT ON COLUMN order_info.pickup_location_name IS '提货点名称';

-- 新增货柜ID
-- ALTER TABLE order_info ADD COLUMN container_id VARCHAR(50) DEFAULT NULL;
-- COMMENT ON COLUMN order_info.container_id IS '货柜ID';

-- 新增货柜名称
-- ALTER TABLE order_info ADD COLUMN container_name VARCHAR(100) DEFAULT NULL;
-- COMMENT ON COLUMN order_info.container_name IS '货柜名称';

-- 修改订单渠道字段类型
-- ALTER TABLE order_info ALTER COLUMN order_channel TYPE VARCHAR(50);
-- COMMENT ON COLUMN order_info.order_channel IS '订单渠道';

-- 修改客户端类型字段类型
-- ALTER TABLE order_info ALTER COLUMN client_type TYPE VARCHAR(50);
-- COMMENT ON COLUMN order_info.client_type IS '客户端类型';
