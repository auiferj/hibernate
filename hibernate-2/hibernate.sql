/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-14 23:17:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张小明');
INSERT INTO `t_user` VALUES ('2', '小小刚');
INSERT INTO `t_user` VALUES ('3', '王晓红');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '白百合');

-- ----------------------------
-- Table structure for `user_addresslist`
-- ----------------------------
DROP TABLE IF EXISTS `user_addresslist`;
CREATE TABLE `user_addresslist` (
  `userId` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `idx` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`idx`),
  KEY `FK50E5983EA26599CE` (`userId`),
  CONSTRAINT `FK50E5983EA26599CE` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_addresslist
-- ----------------------------
INSERT INTO `user_addresslist` VALUES ('1', '天通苑西三区27号楼', '0');
INSERT INTO `user_addresslist` VALUES ('1', '天通苑西二区22号楼', '1');
INSERT INTO `user_addresslist` VALUES ('1', '天通苑北一区17号楼', '2');

-- ----------------------------
-- Table structure for `user_addressmap`
-- ----------------------------
DROP TABLE IF EXISTS `user_addressmap`;
CREATE TABLE `user_addressmap` (
  `userId` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `key_` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`,`key_`),
  KEY `FK9F8349BCA26599CE` (`userId`),
  CONSTRAINT `FK9F8349BCA26599CE` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_addressmap
-- ----------------------------
INSERT INTO `user_addressmap` VALUES ('1', '天通苑二区', '公司');
INSERT INTO `user_addressmap` VALUES ('1', '天通苑三区', '家庭');

-- ----------------------------
-- Table structure for `user_addressset`
-- ----------------------------
DROP TABLE IF EXISTS `user_addressset`;
CREATE TABLE `user_addressset` (
  `userId` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  KEY `FK9F8360C2A26599CE` (`userId`),
  CONSTRAINT `FK9F8360C2A26599CE` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_addressset
-- ----------------------------
INSERT INTO `user_addressset` VALUES ('1', '天通苑三区');
INSERT INTO `user_addressset` VALUES ('1', '天通苑二区');
