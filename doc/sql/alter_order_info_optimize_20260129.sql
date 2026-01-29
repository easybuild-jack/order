-- ============================================================
-- 订单信息表字段优化脚本
-- 变更说明: 
--   1. 删除冗余字段: order_source, refund_flag, tag_remark
--   2. 修改 order_channel 默认值为 'mall'
-- 变更时间: 2026-01-29
-- ============================================================

-- ============================================================
-- MySQL 版本
-- ============================================================

-- 删除冗余字段
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `order_source`;
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `refund_flag`;
ALTER TABLE `order_info` DROP COLUMN IF EXISTS `tag_remark`;

-- 修改 order_channel 默认值
ALTER TABLE `order_info` MODIFY COLUMN `order_channel` VARCHAR(50) DEFAULT 'mall' COMMENT '订单渠道';

-- 更新已有数据中 order_channel 为空的记录
UPDATE `order_info` SET `order_channel` = 'mall' WHERE `order_channel` IS NULL;


-- ============================================================
-- PostgreSQL 版本
-- ============================================================

-- 删除冗余字段
-- ALTER TABLE order_info DROP COLUMN IF EXISTS order_source;
-- ALTER TABLE order_info DROP COLUMN IF EXISTS refund_flag;
-- ALTER TABLE order_info DROP COLUMN IF EXISTS tag_remark;

-- 修改 order_channel 默认值
-- ALTER TABLE order_info ALTER COLUMN order_channel SET DEFAULT 'mall';
-- COMMENT ON COLUMN order_info.order_channel IS '订单渠道';

-- 更新已有数据中 order_channel 为空的记录
-- UPDATE order_info SET order_channel = 'mall' WHERE order_channel IS NULL;
