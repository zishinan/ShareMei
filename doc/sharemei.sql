/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : sharemei

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-07-16 18:42:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dir`
-- ----------------------------
DROP TABLE IF EXISTS `dir`;
CREATE TABLE `dir` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `dir_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dir
-- ----------------------------
INSERT INTO `dir` VALUES ('1', '电子产品', 'dzcp', '1', '0');
INSERT INTO `dir` VALUES ('2', '手机', 'sj', '1', '1');
INSERT INTO `dir` VALUES ('3', '服饰', 'fs', '1', '0');
INSERT INTO `dir` VALUES ('5', '笔记本', 'bjb', '1', '1');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `dir_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `spic` varchar(255) DEFAULT NULL,
  `salePrice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `storeNum` int(11) DEFAULT NULL,
  `costPrice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
