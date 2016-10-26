/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : personal_cms

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2016-10-26 21:03:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `adminName` char(16) default NULL,
  `adminPass` char(16) default NULL,
  `sessionid` char(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'gao', 'gao', '6978ECE923507C64DB275F1D16DF6066');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(8) NOT NULL auto_increment,
  `category` char(32) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('18', '223');
INSERT INTO `category` VALUES ('19', '2233333');
INSERT INTO `category` VALUES ('14', 'tes');
INSERT INTO `category` VALUES ('15', 'test2');
INSERT INTO `category` VALUES ('16', 'test233');
INSERT INTO `category` VALUES ('17', 'test233eeee');

-- ----------------------------
-- Table structure for `title`
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` int(8) NOT NULL auto_increment,
  `articleName` char(32) default NULL,
  `articleContent` longtext,
  `sort` int(8) default NULL,
  `articleImg` char(1) default NULL,
  `isShow` char(2) default '1',
  `readNum` int(16) NOT NULL default '0',
  `date` date default '0000-00-00',
  `category` char(32) default NULL,
  PRIMARY KEY  (`id`),
  KEY `cateForeign` (`category`),
  CONSTRAINT `c_key` FOREIGN KEY (`category`) REFERENCES `category` (`category`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES ('2', 'fdadddd', '<p>fd</p>', null, null, '是', '0', '2016-11-18', '223');
INSERT INTO `title` VALUES ('3', 'ee', '<p>ee</p>', null, null, '是', '0', '2016-10-21', 'test233eeee');
INSERT INTO `title` VALUES ('4', '4', '<p>额的萨芬</p><p><br/></p>', null, null, '是', '520', '2016-10-20', 'test233');
INSERT INTO `title` VALUES ('5', 'ddd', '<p>fd</p>', null, null, '是', '0', '2016-12-16', '2233333');
INSERT INTO `title` VALUES ('6', 'dd1', '<p>fd</p>', null, null, '是', '0', '2016-04-18', 'test2');
INSERT INTO `title` VALUES ('7', '地方萨芬', '<p>fd</p>', null, null, '是', '0', '2016-09-14', 'tes');
