/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : financial_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-08 09:14:55
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
  `type` varchar(256) DEFAULT NULL,
  `status` varchar(256) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `rate_of_return` decimal(11,2) DEFAULT NULL,
  `start_up_point` decimal(11,2) DEFAULT NULL,
  `duration` date DEFAULT NULL,
  `due` date DEFAULT NULL,
  `risk_level` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `create_operator` int(16) DEFAULT NULL,
  `review_operator` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_20` (`provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of config_assessment
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_comment
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `provider_id` int(16) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `type` varchar(256) DEFAULT NULL,
  `status` varchar(256) DEFAULT NULL,
  `pricr` decimal(11,2) DEFAULT NULL,
  `rate_of_return` decimal(11,2) DEFAULT NULL,
  `start_up_point` decimal(11,2) DEFAULT NULL,
  `duration` date DEFAULT NULL,
  `due` date DEFAULT NULL,
  `risk_level` tinyint(4) DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `create_operator` int(16) DEFAULT NULL,
  `review_operator` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_12` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '光明基金', null, null, '10.00', '0.01', '0.10', '2020-06-07', '2020-06-07', '1', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '1', '1');
INSERT INTO `product` VALUES ('2', '2', '华润债券', null, null, '11.00', '0.02', '0.30', '2020-06-07', '2020-06-07', '2', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '2', '2');
INSERT INTO `product` VALUES ('3', '1', '今明股票', null, null, '12.00', '0.03', '0.20', '2020-06-07', '2020-06-07', '3', '0', '2020-06-07 00:00:00', '2020-06-07 00:00:00', '1', '1');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_accessment
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_role
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of repository
-- ----------------------------

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
INSERT INTO `role` VALUES ('1', 'administrator', null, null, '2020-06-07 09:51:07.0000', '0');
INSERT INTO `role` VALUES ('2', 'general_user', null, null, '2020-06-07 09:51:30.0000', '0');

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
  `username` varchar(128) DEFAULT NULL unique,
  `password` varchar(256) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_11` (`department_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '赵一', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '784264272@qq.com', '13763041138', '2020-06-05 00:00:00', '0');
INSERT INTO `user` VALUES ('2', '2', '李二', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13463742932@qq.com', '13463742932', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('3', '3', '张三', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13630424294@qq.com', '13630424294', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('4', null, '李四', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13738424824@qq.com', '13638482943', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('5', null, '王五', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473747272@qq.com', '13470424924', '2020-06-07 00:00:00', '0');
INSERT INTO `user` VALUES ('6', null, '马六', '$2a$10$UcpEKf50WNue2LKCTuxQ4ug4g.44d5qmv.uizWl9JRqArK.3SQcbm', '13473647274@qq.com', '13474747474', '2020-06-07 00:00:00', '0');
