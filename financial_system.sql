/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : financial_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-12 08:51:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `provider` int(16) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `product1_id` int(16) DEFAULT NULL,
  `product2_id` int(16) DEFAULT NULL,
  `product3_id` int(16) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `quota` int(16) DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `stop_issuing_time` datetime DEFAULT NULL,
  `rate_of_return` decimal(11,2) DEFAULT NULL,
  `start_up_point` decimal(11,2) DEFAULT NULL,
  `risk_level` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `create_operator` int(16) DEFAULT NULL,
  `review_operator` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_20` (`provider`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', '1', '套餐A', '1', '2', null, '14.70', '七折', '30', '2020-06-02 22:28:53', '2020-06-17 22:28:58', '0.03', '0.10', '1', '0', '2020-06-11 09:56:47', '2020-06-11 09:56:51', '1', '1');
INSERT INTO `config` VALUES ('2', '2', '套餐B', '2', '3', null, '18.40', '八折', '40', '2020-06-03 22:30:55', '2020-06-16 22:30:59', '0.02', '0.30', '2', '0', '2020-06-11 22:31:06', '2020-06-18 22:31:24', '2', '2');
INSERT INTO `config` VALUES ('3', '3', '光明基金+今明股票', '1', '3', null, '19.80', '九折', '20', '2020-06-02 22:34:00', '2020-06-23 22:34:04', '0.04', '0.40', '1', '0', '2020-06-02 22:34:14', '2020-06-23 22:34:19', '3', '3');

-- ----------------------------
-- Table structure for config_assessment
-- ----------------------------
DROP TABLE IF EXISTS `config_assessment`;
CREATE TABLE `config_assessment` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `config` int(16) DEFAULT NULL,
  `grade` tinyint(4) DEFAULT NULL,
  `description` text,
  `operator` int(16) DEFAULT NULL,
  `assess_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_21` (`config`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config_assessment
-- ----------------------------
INSERT INTO `config_assessment` VALUES ('1', '1', '5', '很好', '1', '2020-06-11 09:58:44', '0');
INSERT INTO `config_assessment` VALUES ('2', '2', '6', '不错', '2', '2020-06-11 22:06:11', '0');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
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
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `operator` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', 'administrator', null, null, '2020-06-07 00:00:00', '0');
INSERT INTO `operation` VALUES ('2', 'general_user', null, null, '2020-06-07 00:00:00', '0');

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
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user` int(16) DEFAULT NULL,
  `repository` int(16) DEFAULT NULL,
  `count` int(16) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `amount` decimal(11,2) DEFAULT NULL,
  `operator` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_18` (`user`),
  KEY `FK_Reference_17` (`repository`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '1', '1', '10.00', '10.00', '1', '2020-06-11 09:49:05', '0');

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
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `provider_id` int(16) DEFAULT NULL,
  `product_type_id` int(16) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `quota` int(16) DEFAULT NULL COMMENT '产品额度',
  `rate_of_return` decimal(11,2) DEFAULT NULL,
  `start_up_point` decimal(11,2) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `stop_issuing_date` date DEFAULT NULL COMMENT '停止发行时间',
  `duration` int(11) DEFAULT NULL COMMENT '定期理财产品的天数',
  `risk_level` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `create_operator` int(16) DEFAULT NULL,
  `review_operator` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_12` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '2', '光明基金', '10.00', '100', '0.01', '0.10', '2020-06-01', '2020-06-30', null, '1', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '1', '1');
INSERT INTO `product` VALUES ('2', '2', '3', '华润债券', '11.00', '90', '0.02', '0.30', '2020-06-01', '2020-06-27', '6', '2', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '2', '2');
INSERT INTO `product` VALUES ('3', '1', '1', '今明股票', '12.00', '70', '0.03', '0.20', '2020-06-01', '2020-06-25', null, '3', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '1', '1');

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
INSERT INTO `product_accessment` VALUES ('3', '3', '15', '产品风险极高，但回报也相当丰富', null, null, null);

-- ----------------------------
-- Table structure for product_role
-- ----------------------------
DROP TABLE IF EXISTS `product_role`;
CREATE TABLE `product_role` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `product_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_22` (`product_id`),
  KEY `FK_Reference_23` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_role
-- ----------------------------
INSERT INTO `product_role` VALUES ('1', '1', '1', '2020-06-10 16:35:53', '0');
INSERT INTO `product_role` VALUES ('2', '2', '2', null, null);

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '股票');
INSERT INTO `product_type` VALUES ('2', ' 基金');
INSERT INTO `product_type` VALUES ('3', ' 债券');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('1', '赵一', '784264272@qq.com', '13763041138', '2020-06-05 00:00:00', '0');
INSERT INTO `provider` VALUES ('2', '李二', '13463742932@qq.com', '13463742932', '2020-06-07 00:00:00', '0');

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `product_id` int(16) DEFAULT NULL,
  `config_id` int(16) DEFAULT NULL,
  `status` varchar(256) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_15` (`product_id`),
  KEY `FK_Reference_16` (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES ('1', '1', '1', '', '1', '2020-06-11 09:53:18', '0');
INSERT INTO `repository` VALUES ('2', '2', '2', '', null, '2020-06-11 09:53:28', null);

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
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `department_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'Mike', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '784264272@qq.com', '13763041138', '2020-06-05 00:00:00', '0');
INSERT INTO `user` VALUES ('2', '2', 'David', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13463742932@qq.com', '13463742932', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('3', '3', 'John', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13630424294@qq.com', '13630424294', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('4', null, 'Alex', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13738424824@qq.com', '13638482943', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('5', null, 'Bill', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473747272@qq.com', '13470424924', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('6', null, '马六', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473647274@qq.com', '13474747474', '2020-06-07 00:00:00', '0');
