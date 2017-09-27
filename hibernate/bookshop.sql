/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-28 03:28:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) NOT NULL,
  `Author` varchar(16) NOT NULL,
  `PublisherId` int(4) NOT NULL,
  `UnitPrice` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_books` (`PublisherId`),
  CONSTRAINT `FK_books` FOREIGN KEY (`PublisherId`) REFERENCES `publishers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4954 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('4939', 'C++ Primer中文版', '（美）Stanley B。', '2', '55');
INSERT INTO `books` VALUES ('4943', 'Effective C# 中', '（美）瓦格纳 著', '2', '45');
INSERT INTO `books` VALUES ('4944', 'C程序设计语言', '（美）克尼汉', '3', '30');
INSERT INTO `books` VALUES ('4946', '框架设计（第2版)', '（美）瑞奇特', '1', '68');
INSERT INTO `books` VALUES ('4947', 'C++程序设计教程', '钱能  著', '1', '40');
INSERT INTO `books` VALUES ('4953', 'Web应用开发技术', '崔尚森，张白一', '3', '56');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CourseId` int(4) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `identitycard`
-- ----------------------------
DROP TABLE IF EXISTS `identitycard`;
CREATE TABLE `identitycard` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `CardNo` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identitycard
-- ----------------------------
INSERT INTO `identitycard` VALUES ('1', '320107000000000001');
INSERT INTO `identitycard` VALUES ('2', '320107000000000002');
INSERT INTO `identitycard` VALUES ('3', '320107000000000003');
INSERT INTO `identitycard` VALUES ('4', '320107000000000004');
INSERT INTO `identitycard` VALUES ('5', '320107000000000005');
INSERT INTO `identitycard` VALUES ('6', '320107000000000006');
INSERT INTO `identitycard` VALUES ('7', '320107000000000007');

-- ----------------------------
-- Table structure for `identitycard_zj`
-- ----------------------------
DROP TABLE IF EXISTS `identitycard_zj`;
CREATE TABLE `identitycard_zj` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `CardNo` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of identitycard_zj
-- ----------------------------
INSERT INTO `identitycard_zj` VALUES ('1', '320107000000000001');
INSERT INTO `identitycard_zj` VALUES ('2', '320107000000000002');
INSERT INTO `identitycard_zj` VALUES ('3', '320107000000000003');
INSERT INTO `identitycard_zj` VALUES ('4', '320107000000000004');
INSERT INTO `identitycard_zj` VALUES ('5', '320107000000000005');
INSERT INTO `identitycard_zj` VALUES ('6', '320107000000000006');
INSERT INTO `identitycard_zj` VALUES ('7', '320107000000000007');

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) DEFAULT NULL,
  `Sex` varchar(4) DEFAULT NULL,
  `Age` int(4) DEFAULT NULL,
  `CardId` int(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `CardId` (`CardId`),
  CONSTRAINT `people_ibfk_1` FOREIGN KEY (`CardId`) REFERENCES `identitycard` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', 'zhangsan', '男', '21', '1');
INSERT INTO `people` VALUES ('2', 'lisi', '男', '22', '2');
INSERT INTO `people` VALUES ('3', 'wangwu', '男', '23', '3');
INSERT INTO `people` VALUES ('4', 'zhaoliu', '男', '24', '4');
INSERT INTO `people` VALUES ('5', 'qianqie', '男', '25', '5');
INSERT INTO `people` VALUES ('6', 'sunba', '男', '26', '6');
INSERT INTO `people` VALUES ('7', 'qingqiu', '男', '27', '7');

-- ----------------------------
-- Table structure for `people_zj`
-- ----------------------------
DROP TABLE IF EXISTS `people_zj`;
CREATE TABLE `people_zj` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) DEFAULT NULL,
  `Sex` varchar(4) DEFAULT NULL,
  `Age` int(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `people_zj_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `identitycard_zj` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people_zj
-- ----------------------------
INSERT INTO `people_zj` VALUES ('1', 'zhangsan', '男', '21');
INSERT INTO `people_zj` VALUES ('2', 'lisi', '男', '22');
INSERT INTO `people_zj` VALUES ('3', 'wangwu', '男', '23');
INSERT INTO `people_zj` VALUES ('4', 'zhaoliu', '男', '24');
INSERT INTO `people_zj` VALUES ('5', 'qianqie', '男', '25');
INSERT INTO `people_zj` VALUES ('6', 'sunba', '男', '26');
INSERT INTO `people_zj` VALUES ('7', 'qingqiu', '男', '27');

-- ----------------------------
-- Table structure for `publishers`
-- ----------------------------
DROP TABLE IF EXISTS `publishers`;
CREATE TABLE `publishers` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(16) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of publishers
-- ----------------------------
INSERT INTO `publishers` VALUES ('1', '清华大学出版社');
INSERT INTO `publishers` VALUES ('2', '人民邮电出版社');
INSERT INTO `publishers` VALUES ('3', '机械工业出版社');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `Sid` int(4) NOT NULL,
  `Cid` int(4) NOT NULL,
  PRIMARY KEY (`Cid`,`Sid`),
  KEY `FK_sc` (`Sid`),
  KEY `sc` (`Cid`),
  CONSTRAINT `FK_cid` FOREIGN KEY (`Cid`) REFERENCES `course` (`CourseId`),
  CONSTRAINT `FK_sid` FOREIGN KEY (`Sid`) REFERENCES `student` (`StudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of sc
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `StudentId` int(4) NOT NULL AUTO_INCREMENT,
  `StudentName` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`StudentId`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(50) DEFAULT NULL,
  `LoginPwd` varchar(16) DEFAULT NULL,
  `Name` varchar(16) DEFAULT NULL,
  `Address` varchar(16) DEFAULT NULL,
  `Phone` varchar(16) DEFAULT NULL,
  `Mail` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'bobo', '123456', '张三', '北京', '010 5555', 'bobo3@d.c');
INSERT INTO `user` VALUES ('2', 'bobo', '123456', '张三', '北京', '010 5555', 'bobo3@d.c');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(50) DEFAULT NULL,
  `LoginPwd` varchar(16) DEFAULT NULL,
  `Name` varchar(16) DEFAULT NULL,
  `Address` varchar(16) DEFAULT NULL,
  `Phone` varchar(16) DEFAULT NULL,
  `Mail` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'jingjing', 'jingjing', 'Jing Jing', 'GuangZhou', '88888888', 'jingjing@sina.co');
INSERT INTO `users` VALUES ('2', 'bobo', '123456', '张三', '北京', '010 5555555', 'bobo3@d.c');
INSERT INTO `users` VALUES ('3', 'user', '123456', 'user', 'asd', '11111111111', '1@1.c');
INSERT INTO `users` VALUES ('4', 'admin', '123456', 'admin', 'admin', '13456', '123456@s.c');
INSERT INTO `users` VALUES ('5', '恰嬉猫', '070115', 'qiaximao', '上海市华夏路', '13774210000', 'qiximao@163.com');
INSERT INTO `users` VALUES ('6', '王强', '991221', 'wangqiang', '北京软件大学', '12334567891', 'wangqiang@163.co');
INSERT INTO `users` VALUES ('7', '申波', 'shenbo', 'shenbo', 'Beijing', '010-64324947', 'shenbo@263.com');
INSERT INTO `users` VALUES ('8', 'zhangsan', '123456', '张三', '江苏南京', '02512345678', '123@qq.com');
INSERT INTO `users` VALUES ('9', 'zhangsan', '123456', '张三', '江苏南京', '02512345678', '123@qq.com');
