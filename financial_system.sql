/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : financial_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-21 20:08:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `sub_product_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '子产品列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置';

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('2', '2,3');
INSERT INTO `config` VALUES ('3', '1,3');
INSERT INTO `config` VALUES ('6', '1,2');

-- ----------------------------
-- Table structure for config_assessment
-- ----------------------------
DROP TABLE IF EXISTS `config_assessment`;
CREATE TABLE `config_assessment` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '配置评价id',
  `config_id` int(16) DEFAULT NULL COMMENT '配置id',
  `grade` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '配置评估等级',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评价内容',
  `operator_id` int(16) DEFAULT NULL COMMENT '评价人员id',
  `assess_time` datetime DEFAULT NULL COMMENT '评价时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`config_id`),
  KEY `fk_configAssessment_user` (`operator_id`),
  CONSTRAINT `fk_configAssessment_config` FOREIGN KEY (`config_id`) REFERENCES `config` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_configAssessment_user` FOREIGN KEY (`operator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置评价';

-- ----------------------------
-- Records of config_assessment
-- ----------------------------
INSERT INTO `config_assessment` VALUES ('1', '6', 'A', '很好', '1', '2020-06-11 09:58:44', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门';

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限';

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', 'administrator', '/user/insertSelective');
INSERT INTO `operation` VALUES ('2', 'general_user', '/user/selectAll');

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
  KEY `FK_Reference_1` (`operation_id`),
  CONSTRAINT `fk_operationRole_operation` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_operationRole_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限-角色';

-- ----------------------------
-- Records of operation_role
-- ----------------------------
INSERT INTO `operation_role` VALUES ('1', '1', '1', '2020-06-07 00:00:00', '0');
INSERT INTO `operation_role` VALUES ('2', '2', '2', '2020-06-07 00:00:00', '0');
INSERT INTO `operation_role` VALUES ('3', '2', '1', '2020-06-18 12:21:13', '0');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `product_id` int(16) DEFAULT NULL COMMENT '产品id',
  `amount` int(16) DEFAULT NULL COMMENT '金额',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '订单类型，0表示买入，1表示卖出',
  `order_time` datetime DEFAULT NULL COMMENT '订单时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_18` (`user_id`),
  KEY `fk_order_product` (`product_id`),
  CONSTRAINT ` fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_order_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '1', '10', '0', '2020-06-16 09:08:41', '0');
INSERT INTO `order` VALUES ('2', '2', '2', '20', '0', '2020-06-18 09:08:45', '0');
INSERT INTO `order` VALUES ('3', '3', '3', '30', '0', '2020-06-16 09:09:26', '0');
INSERT INTO `order` VALUES ('4', '4', '1', '20', '0', '2020-06-21 20:06:19', '0');
INSERT INTO `order` VALUES ('5', '4', '2', '10', '0', '2020-06-21 20:06:35', '0');
INSERT INTO `order` VALUES ('6', '4', '3', '10', '0', '2020-06-21 20:06:51', '0');

-- ----------------------------
-- Table structure for order_comment
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '订单评价id',
  `order_id` int(16) DEFAULT NULL COMMENT '订单id',
  `grade` tinyint(4) DEFAULT NULL COMMENT '订单评分',
  `desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '订单评价描述',
  `operator_id` int(16) DEFAULT NULL COMMENT '评价人员id',
  `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_14` (`order_id`),
  KEY `fk_orderComment_user` (`operator_id`),
  CONSTRAINT `fk_orderComment_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_orderComment_user` FOREIGN KEY (`operator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单评价';

-- ----------------------------
-- Records of order_comment
-- ----------------------------
INSERT INTO `order_comment` VALUES ('1', '1', '5', '很好', '1', '2020-06-11 09:50:07', '0');
INSERT INTO `order_comment` VALUES ('2', '2', '4', '还行', '2', '2020-06-17 23:10:35', '0');
INSERT INTO `order_comment` VALUES ('3', '3', '5', '不错', '3', '2020-06-17 23:10:54', '0');
INSERT INTO `order_comment` VALUES ('4', '4', '1', '不错啊，能赚到钱', '4', '2020-06-21 20:07:46', '0');

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
  `return_rate` decimal(11,2) DEFAULT NULL COMMENT '收益率',
  `total_amount` int(16) DEFAULT NULL COMMENT '产品额度',
  `remain_amount` decimal(11,2) DEFAULT NULL COMMENT '剩余金额(0.4表示 0.4%）',
  `least_amount` decimal(11,2) DEFAULT NULL COMMENT '起购金额',
  `risk_level` tinyint(4) DEFAULT NULL COMMENT '风险评级（5个）',
  `add_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '入库备注',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `storage_time` datetime DEFAULT NULL COMMENT '入库时间',
  `added_time` datetime DEFAULT NULL COMMENT '上架时间',
  `review_operator_id` int(11) DEFAULT NULL,
  `review_result` char(1) DEFAULT NULL COMMENT '审核结果',
  `review_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '审核备注',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_12` (`provider_id`),
  KEY `fk_product_productType` (`product_type_id`),
  KEY `fk_product_user` (`review_operator_id`),
  CONSTRAINT `fk_product_productType` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_product_provider` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_product_user` FOREIGN KEY (`review_operator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '4', '今明股票', '0', '3.00', '70', '30.00', '1.00', '3', '股票', '3', '2020-06-10 22:14:07', '2020-06-14 22:14:21', '3', 'A', '还可以，通过');
INSERT INTO `product` VALUES ('2', '1', '2', '荣耀基金', '0', '0.90', '200', '130.00', '5.00', '1', '基金', '4', '2020-06-02 22:24:51', '2020-06-14 22:25:01', '1', 'B', '通过');
INSERT INTO `product` VALUES ('3', '2', '3', '罗明债券', '3,2,0', '2.00', '120', '100.00', '2.00', '2', '债券', '4', '2020-06-02 22:29:53', '2020-06-20 22:29:57', '2', 'C', '通过');
INSERT INTO `product` VALUES ('4', '1', '2', '光明基金', '0', '1.00', '100', '80.00', '5.00', '1', '基金', '1', '2020-06-02 22:13:58', null, '1', null, '');
INSERT INTO `product` VALUES ('5', '2', '3', '华润债券', '2,3,0', '2.00', '90', '70.00', '2.00', '2', '债券', '2', '2020-06-09 22:14:02', null, '2', 'A', '待上架');
INSERT INTO `product` VALUES ('6', '1', '1', '套餐A', '3,2,0', '3.00', '50', '30.00', '2.00', '2', '产品包', '4', '2020-06-10 15:02:30', '2020-06-26 15:02:34', '1', 'A', '通过');

-- ----------------------------
-- Table structure for product_assessment
-- ----------------------------
DROP TABLE IF EXISTS `product_assessment`;
CREATE TABLE `product_assessment` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '产品评价id',
  `product_id` int(16) DEFAULT NULL COMMENT '产品id',
  `assess_result` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '产品评价等级',
  `assess_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评价文本',
  `operator_id` int(16) DEFAULT NULL COMMENT '评价人员id',
  `assess_time` datetime DEFAULT NULL COMMENT '评价时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_19` (`product_id`) USING BTREE,
  KEY `fk_productAssessment_user` (`operator_id`),
  CONSTRAINT `fk_productAssessment_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_productAssessment_user` FOREIGN KEY (`operator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品评价';

-- ----------------------------
-- Records of product_assessment
-- ----------------------------
INSERT INTO `product_assessment` VALUES ('1', '1', 'A', '产品风险低，盈利高', '1', '2020-06-10 16:37:28', '0');
INSERT INTO `product_assessment` VALUES ('2', '2', 'B', '产品风险较高，盈利非常高', '2', '2020-06-10 16:39:01', '0');
INSERT INTO `product_assessment` VALUES ('3', '3', 'C', '产品风险极高，但回报也相当丰富', '1', '2020-06-16 16:14:02', '0');
INSERT INTO `product_assessment` VALUES ('4', '1', 'A', '该产品前景不错', '2', '2020-06-16 17:50:45', '0');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品类型id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '产品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品类型';

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '产品包');
INSERT INTO `product_type` VALUES ('2', ' 基金');
INSERT INTO `product_type` VALUES ('3', ' 债券');
INSERT INTO `product_type` VALUES ('4', '股票');

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
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='供应商';

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('1', 'Mike', '784264272@qq.com', '13763041138', '广东省广州市番禺区', '2020-06-05 00:00:00', '0');
INSERT INTO `provider` VALUES ('2', 'David', '13463742932@qq.com', '13463742932', '广东省广州市天河区', '2020-06-07 00:00:00', '0');
INSERT INTO `provider` VALUES ('3', 'John', '13630424294@qq.com', '13630424294', '广东省广州市越秀区', '2020-06-14 16:56:33', '0');
INSERT INTO `provider` VALUES ('4', '得力股票', '13764727427@qq.com', '13764727427', '广东省佛山市三水区', '2020-06-18 15:32:58', '0');
INSERT INTO `provider` VALUES ('5', '罗天科技', '13874272022@qq.com', '13874272022', '广东省深圳市南山区', '2020-06-18 15:33:37', '0');
INSERT INTO `provider` VALUES ('6', '今进股份', '13763401373@qq.com', '13763401373', '广东省深圳市龙岗区', '2020-06-18 15:34:09', '0');
INSERT INTO `provider` VALUES ('7', '光大科技', '13763047204@qq.com', '13763047204', '广东省深圳市南山区', '2020-06-18 15:34:36', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `type` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色类型',
  `status` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色状态',
  `create_time` datetime DEFAULT NULL COMMENT '角色创建时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'administrator', null, null, '2020-06-07 09:51:07', '0');
INSERT INTO `role` VALUES ('2', 'general_user', null, null, '2020-06-07 09:51:30', '0');
INSERT INTO `role` VALUES ('3', 'background_user', null, null, '2020-06-19 22:25:08', '0');
INSERT INTO `role` VALUES ('4', 'sale', null, null, '2020-06-21 13:22:04', '0');
INSERT INTO `role` VALUES ('5', 'hr', null, null, '2020-06-21 13:22:16', '0');
INSERT INTO `role` VALUES ('6', 'financial', null, null, '2020-06-21 13:22:50', '0');

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
  KEY `FK_Reference_9` (`role_id`),
  CONSTRAINT `fk_roleDepartment_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_roleDepartment_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-部门';

-- ----------------------------
-- Records of role_department
-- ----------------------------
INSERT INTO `role_department` VALUES ('1', '1', '4', '2020-06-21 13:23:15', '0');
INSERT INTO `role_department` VALUES ('2', '2', '5', '2020-06-21 13:23:49', '0');
INSERT INTO `role_department` VALUES ('3', '4', '6', '2020-06-21 13:27:00', '0');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '角色-用户id',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `role_id` int(16) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_8` (`user_id`),
  KEY `FK_Reference_10` (`role_id`),
  CONSTRAINT `fk_userRole_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_userRole_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-用户';

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '1', '1', '2020-06-08 09:12:51', '0');
INSERT INTO `role_user` VALUES ('2', '2', '1', '2020-06-08 09:13:03', '0');
INSERT INTO `role_user` VALUES ('3', '3', '1', '2020-06-08 09:13:15', '0');
INSERT INTO `role_user` VALUES ('4', '4', '2', '2020-06-08 09:13:28', '0');
INSERT INTO `role_user` VALUES ('5', '5', '2', '2020-06-08 09:13:38', '0');
INSERT INTO `role_user` VALUES ('6', '6', '2', '2020-06-08 09:13:48', '0');
INSERT INTO `role_user` VALUES ('7', '7', '2', '2020-06-20 21:16:10', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `department_id` int(16) DEFAULT NULL COMMENT '部门id',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户密码',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码',
  `balance` int(16) DEFAULT NULL COMMENT '余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_Reference_11` (`department_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'Mike', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '784264272@qq.com', '13763041138', '600', '2020-06-05 00:00:00', '0');
INSERT INTO `user` VALUES ('2', '2', 'David', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13463742932@qq.com', '13463742932', '500', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('3', '3', 'John', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13630424294@qq.com', '13630424294', '1000', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('4', null, 'Alex', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13738424824@qq.com', '13638482943', '300', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('5', null, 'Bill', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473747272@qq.com', '13470424924', '600', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('6', null, 'Klerk', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473647274@qq.com', '13474747474', '700', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('7', null, 'Amy', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13742740247@qq.com', '13742740247', '500', '2020-06-20 21:26:06', '0');

-- ----------------------------
-- Table structure for user_product
-- ----------------------------
DROP TABLE IF EXISTS `user_product`;
CREATE TABLE `user_product` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '用户产品id',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `product_id` int(16) DEFAULT NULL COMMENT '产品id',
  `holding_share` int(16) DEFAULT NULL COMMENT '持有份额',
  `cumulative_income` decimal(11,2) DEFAULT NULL COMMENT '累计收益',
  PRIMARY KEY (`id`),
  KEY `fk_userProduct_user` (`user_id`),
  KEY `fk_userProduct_product` (`product_id`),
  CONSTRAINT `fk_userProduct_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_userProduct_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户产品';

-- ----------------------------
-- Records of user_product
-- ----------------------------
INSERT INTO `user_product` VALUES ('1', '1', '1', '10', '110.00');
INSERT INTO `user_product` VALUES ('2', '2', '2', '20', '220.00');
INSERT INTO `user_product` VALUES ('3', '3', '3', '30', '2280.00');
