/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : personal_cms

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-10-19 13:00:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` char(16) DEFAULT NULL,
  `adminPass` char(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'gao', 'gao');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `category` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category` (`category`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('9', '11');
INSERT INTO `category` VALUES ('1', 'test');

-- ----------------------------
-- Table structure for `title`
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `articleName` char(32) DEFAULT NULL,
  `articleContent` longtext,
  `sort` int(8) DEFAULT NULL,
  `articleImg` char(1) DEFAULT NULL,
  `isShow` tinyint(1) DEFAULT '1',
  `readNum` int(16) NOT NULL DEFAULT '0',
  `date` date DEFAULT '0000-00-00',
  `category` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cateForeign` (`category`),
  CONSTRAINT `forignKey` FOREIGN KEY (`category`) REFERENCES `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES ('11', '22', '<p>55</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('16', 'reer', '<p><strong>fdsfasfds<img src=\" upload/image/20161010/1476064878910027978.png\" title=\"1476064878910027978.png\" alt=\"default.png\" width=\"387\" height=\"2992\"/></strong></p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('18', 'çäºææ¯ä¸ªå¯ç±çå­©å­', '<h1 style=\"font-size: 32px; font-weight: bold; border-bottom: 2px solid rgb(204, 204, 204); padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\">çäºææ¯ä¸ªéå¸¸å¯ç±çå­©å­</h1><p>çäºæå¯ç±åï¼<br/></p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('19', '恩恩', '<p>发的方式</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('20', '王亚敏是个可爱的孩子！', '<p>王亚敏是个非常可爱的孩子！</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('21', 'fadf', '<p>发的方法司法所</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('22', '方法司法所', '<p>发的方法司法所</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('23', 'fdsf', '<p>fdsaf</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('24', 'fdasf', '<p>fad</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('25', 'fdasf', '<p>fad</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('26', 'test', '<p>test</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('28', 'testee', '<p>ee</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('30', 'ert', '<p>afdf</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('33', 'test', '<p>etas</p>', null, null, '0', '0', '2016-10-10', 'test');
INSERT INTO `title` VALUES ('38', '答非', '<p>发地方</p>', null, null, '0', '0', '2016-10-11', '11');
INSERT INTO `title` VALUES ('39', '放大', '<p>萨芬的</p>', null, null, '0', '0', '2016-10-11', '11');
