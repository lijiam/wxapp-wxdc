/*
 Navicat Premium Data Transfer

 Source Server         : 106.14.202.226
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 106.14.202.226:3306
 Source Schema         : resdb

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 19/08/2018 15:56:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单主键',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '0==删除 1==显示',
  `balance_status` int(11) NULL DEFAULT NULL COMMENT '1==未付款2==已付款3==已失效',
  `total_price` double(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小程序openid',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `yhqid` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠券主键',
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `je` int(255) NULL DEFAULT NULL COMMENT '金额',
  `mzje` int(255) NULL DEFAULT NULL COMMENT '满足金额',
  `mztj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '满足条件',
  PRIMARY KEY (`yhqid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`  (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜的主键',
  `dish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜名',
  `dish_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜的路径',
  `hot_status` int(11) NULL DEFAULT NULL COMMENT '1==不辣 2==微辣 3==中辣 4==超辣',
  `praise_times` int(11) NULL DEFAULT NULL COMMENT '点赞次数',
  `is_sign` int(11) NULL DEFAULT NULL COMMENT '0==不是招牌 1==招牌',
  `is_new_dish` int(11) NULL DEFAULT NULL COMMENT '0==不是新品 1=新品',
  `sales_volume` int(11) NULL DEFAULT NULL COMMENT '菜的销量',
  `dish_price` double(10, 2) NULL DEFAULT NULL COMMENT '菜的价格',
  `dish_type` int(11) NULL DEFAULT NULL COMMENT '1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水',
  `dish_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜的描述',
  PRIMARY KEY (`dish_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dish_type
-- ----------------------------
DROP TABLE IF EXISTS `dish_type`;
CREATE TABLE `dish_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜的类型主键',
  `dish_type` int(11) NULL DEFAULT NULL COMMENT '1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类名字',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for my_coupon
-- ----------------------------
DROP TABLE IF EXISTS `my_coupon`;
CREATE TABLE `my_coupon`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小程序openid',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `yhqid` int(11) NULL DEFAULT NULL COMMENT '优惠券id',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失效时间',
  `is_delete` int(255) NULL DEFAULT NULL COMMENT '0==删除 1==显示',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `open_id`(`open_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for res_table
-- ----------------------------
DROP TABLE IF EXISTS `res_table`;
CREATE TABLE `res_table`  (
  `table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '桌子主键',
  `max_seating` int(11) NOT NULL,
  `table_status` int(11) NOT NULL,
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约主键',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小程序openId',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `table_id` int(11) NULL DEFAULT NULL COMMENT '桌子id',
  `reserve_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约号码',
  `reserve_status` int(11) NULL DEFAULT NULL COMMENT '0==失效 1==预约 2== 等待 3==无法预约',
  `reserve_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约时间',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(11) NULL DEFAULT 1 COMMENT '0==删除  1==显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `shop_cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车主键',
  `balance_id` int(11) NULL DEFAULT NULL COMMENT '订单主键',
  `dish_id` int(11) NULL DEFAULT NULL COMMENT '菜单主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜名',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `count` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`shop_cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
