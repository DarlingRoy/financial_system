/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : financial_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-14 23:09:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `sub_product_list` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', '1,2');
INSERT INTO `config` VALUES ('2', '2,3');
INSERT INTO `config` VALUES ('3', null);

-- ----------------------------
-- Table structure for config_assessment
-- ----------------------------
DROP TABLE IF EXISTS `config_assessment`;
CREATE TABLE `config_assessment` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `config` int(16) DEFAULT NULL,
  `grade` char(1) DEFAULT NULL COMMENT '产品评估等级',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评价内容',
  `operator_id` int(16) DEFAULT NULL,
  `assess_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`config`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config_assessment
-- ----------------------------
INSERT INTO `config_assessment` VALUES ('1', '1', 'A', '很好', '1', '2020-06-11 09:58:44', '0');
INSERT INTO `config_assessment` VALUES ('2', '2', 'B', '不错', '2', '2020-06-11 22:06:11', '0');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门名称',
  `type` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'sale', null, '2020-06-05 00:00:00', '0');
INSERT INTO `department` VALUES ('2', 'HR', null, '2020-06-07 00:00:00', '0');
INSERT INTO `department` VALUES ('3', 'administration', null, '2020-06-07 00:00:00', '0');
INSERT INTO `department` VALUES ('4', 'financial', null, '2020-06-07 00:00:00', '0');

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', 'administrator', null);
INSERT INTO `operation` VALUES ('2', 'general_user', null);

-- ----------------------------
-- Table structure for operation_role
-- ----------------------------
DROP TABLE IF EXISTS `operation_role`;
CREATE TABLE `operation_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `operation_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`role_id`),
  KEY `FK_Reference_1` (`operation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of operation_role
-- ----------------------------
INSERT INTO `operation_role` VALUES ('1', '1', '1', '2020-06-07 00:00:00', '0');
INSERT INTO `operation_role` VALUES ('2', '2', '2', '2020-06-07 00:00:00', '0');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
  `purchase_price` decimal(11,2) DEFAULT NULL COMMENT '购买金额',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_18` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '1', '2020-06-01 21:48:23', '2020-06-26 21:48:27', '10.00', '0');
INSERT INTO `order` VALUES ('2', '2', '2', '2020-06-01 21:48:40', '2020-06-28 21:48:43', '20.00', '0');
INSERT INTO `order` VALUES ('3', '3', '3', '2020-06-03 21:48:53', '2020-06-24 21:49:02', '30.00', '0');

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `order` int(16) DEFAULT NULL,
  `grade` tinyint(4) DEFAULT NULL,
  `desc` text,
  `operator` int(16) DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_14` (`order`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_comment
-- ----------------------------
INSERT INTO `order_comment` VALUES ('1', '1', '5', '很好', '1', '2020-06-11 09:50:07', '0');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `provider_id` int(16) DEFAULT NULL COMMENT '供应商id',
  `product_type_id` int(16) DEFAULT NULL COMMENT '产品类型id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '产品名称',
  `duration` varchar(255) DEFAULT NULL COMMENT '期长',
  `rate_of_return` decimal(11,2) DEFAULT NULL COMMENT '收益率',
  `total_amount` int(16) DEFAULT NULL COMMENT '产品额度',
  `remain_amout` decimal(11,2) DEFAULT NULL COMMENT '剩余金额(0.4表示 0.4%）',
  `start_up_amount` decimal(11,2) DEFAULT NULL COMMENT '起购金额',
  `risk_level` tinyint(4) DEFAULT NULL COMMENT '风险评级（5个）',
  `storage_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入库备注',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `storage_time` datetime DEFAULT NULL COMMENT '入库时间',
  `added_time` datetime DEFAULT NULL COMMENT '上架时间',
  `review_operator_id` int(11) DEFAULT NULL,
  `review_result` tinyint(1) DEFAULT NULL COMMENT '审核结果',
  `review_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_12` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '1', '今明股票', '0', '3.00', '70', '30.00', '1.00', '3', '股票', '4', '2020-06-10 22:14:07', '2020-06-14 22:14:21', '3', '1', '通过');
INSERT INTO `product` VALUES ('2', '1', '2', '荣耀基金', '0', '0.90', '200', '130.00', '5.00', '1', '基金', '4', '2020-06-02 22:24:51', '2020-06-14 22:25:01', '1', '1', '通过');
INSERT INTO `product` VALUES ('3', '2', '3', '罗明债券', '3,2,0', '2.00', '120', '100.00', '2.00', '2', '债券', '4', '2020-06-02 22:29:53', '2020-06-20 22:29:57', '2', '1', '通过');
INSERT INTO `product` VALUES ('4', '1', '2', '光明基金', '0', '1.00', '100', '80.00', '5.00', '1', '基金', '1', '2020-06-02 22:13:58', null, null, null, '');
INSERT INTO `product` VALUES ('5', '2', '3', '华润债券', '2,3,0', '2.00', '90', '70.00', '2.00', '2', '债券', '2', '2020-06-09 22:14:02', null, '2', '1', '待上架');

-- ----------------------------
-- Table structure for product_accessment
-- ----------------------------
DROP TABLE IF EXISTS `product_accessment`;
CREATE TABLE `product_accessment` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `product` int(16) DEFAULT NULL,
  `grade` int(16) DEFAULT NULL,
  `desc` text,
  `operator` int(16) DEFAULT NULL,
  `assess_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_19` (`product`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_accessment
-- ----------------------------
INSERT INTO `product_accessment` VALUES ('1', '1', '5', '产品风险低，盈利高', '1', '2020-06-10 16:37:28', '0');
INSERT INTO `product_accessment` VALUES ('2', '2', '10', '产品风险较高，盈利非常高', '2', '2020-06-10 16:39:01', '0');
INSERT INTO `product_accessment` VALUES ('3', '3', '15', '产品风险极高，但回报也相当丰富', '1', null, null);

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '股票');
INSERT INTO `product_type` VALUES ('2', ' 基金');
INSERT INTO `product_type` VALUES ('3', ' 债券');
INSERT INTO `product_type` VALUES ('4', '产品包');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '供应商id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '供应商名称',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮件',
  `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('1', 'Mike', '784264272@qq.com', '13763041138', '广东省广州市番禺区', '2020-06-05 00:00:00', '0');
INSERT INTO `provider` VALUES ('2', 'David', '13463742932@qq.com', '13463742932', '广东省广州市天河区', '2020-06-07 00:00:00', '0');
INSERT INTO `provider` VALUES ('3', 'John', '13630424294@qq.com', '13630424294', '广东省广州市越秀区', '2020-06-14 16:56:33', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `status` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'administrator', null, null, '2020-06-07 09:51:07', '0');
INSERT INTO `role` VALUES ('2', 'general_user', null, null, '2020-06-07 09:51:30', '0');

-- ----------------------------
-- Table structure for role_department
-- ----------------------------
DROP TABLE IF EXISTS `role_department`;
CREATE TABLE `role_department` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '角色-部门中间表id',
  `department_id` int(16) DEFAULT NULL COMMENT '部门id',
  `role_id` int(16) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`department_id`),
  KEY `FK_Reference_9` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_department
-- ----------------------------

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_8` (`user_id`),
  KEY `FK_Reference_10` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '1', '1', '2020-06-08 09:12:51', '0');
INSERT INTO `role_user` VALUES ('2', '2', '1', '2020-06-08 09:13:03', '0');
INSERT INTO `role_user` VALUES ('3', '3', '1', '2020-06-08 09:13:15', '0');
INSERT INTO `role_user` VALUES ('4', '4', '2', '2020-06-08 09:13:28', '0');
INSERT INTO `role_user` VALUES ('5', '5', '2', '2020-06-08 09:13:38', '0');
INSERT INTO `role_user` VALUES ('6', '6', '2', '2020-06-08 09:13:48', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `department_id` int(16) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_Reference_11` (`department_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'Mike', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '784264272@qq.com', '13763041138', '2020-06-05 00:00:00', '0');
INSERT INTO `user` VALUES ('2', '2', 'David', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13463742932@qq.com', '13463742932', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('3', '3', 'John', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13630424294@qq.com', '13630424294', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('4', null, 'Alex', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13738424824@qq.com', '13638482943', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('5', null, 'Bill', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473747272@qq.com', '13470424924', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('6', null, 'Klerk', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473647274@qq.com', '13474747474', '2020-06-07 00:00:00', '0');
