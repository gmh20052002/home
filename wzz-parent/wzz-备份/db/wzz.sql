/*
Navicat MySQL Data Transfer

Source Server         : 120.25.226.197
Source Server Version : 50537
Source Host           : 120.25.226.197:3306
Source Database       : wzz

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-12-04 23:11:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for WZZ_BUSINESS_CLASS
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_BUSINESS_CLASS`;
CREATE TABLE `WZZ_BUSINESS_CLASS` (
  `ID` varchar(64) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `PARENT_ID` varchar(64) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业分类';

-- ----------------------------
-- Records of WZZ_BUSINESS_CLASS
-- ----------------------------
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('1', '美食', '0', '美食');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('10', '生活服务', '0', '生活服务');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('11', '旧货店', '0', '旧货店');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('12', '教育培训', '0', '教育培训');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('2', '丽人', '0', '丽人');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('3', '医疗', '0', '医疗');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('4', '汽车', '0', '汽车');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('5', '购物', '0', '购物');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('6', '住宿', '0', '住宿');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('7', '小区', '0', '小区');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('8', '微商', '0', '微商');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('9', '休闲娱乐', '0', '休闲娱乐');
INSERT INTO `WZZ_BUSINESS_CLASS` VALUES ('test', 'test', '0', 'test');

-- ----------------------------
-- Table structure for WZZ_USER
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_USER`;
CREATE TABLE `WZZ_USER` (
  `ID` varchar(64) NOT NULL COMMENT '用户ID',
  `USER_NAME` varchar(100) DEFAULT NULL COMMENT '用户账号',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `IMEI` varchar(100) DEFAULT NULL COMMENT 'IMEI码',
  `USER_CNAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `PROVINCE` varchar(50) DEFAULT NULL COMMENT '省',
  `USER_TYPE` varchar(100) DEFAULT NULL COMMENT '用户类型(user-用户、shoper-商户、vip-vip商户、proxyer-代理)',
  `END_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '到期时间、VIP商户有效',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME_Unique` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP用户信息';

-- ----------------------------
-- Records of WZZ_USER
-- ----------------------------
INSERT INTO `WZZ_USER` VALUES ('001', '18974870731', '123456', 'sdfwer23erterw', '郭明华', null, 'hn', 'user', '2015-11-28 22:32:00');
INSERT INTO `WZZ_USER` VALUES ('002', '18789700861', '123456', null, '王海波', null, '', 'shop', '2015-11-30 19:27:16');
INSERT INTO `WZZ_USER` VALUES ('42fc14b496194a65912b2873c46f6853', '13307620922', '123456', null, '林小宇', null, null, 'proxy', '2015-11-28 22:32:53');

-- ----------------------------
-- Table structure for WZZ_USER_DISCOUNT
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_USER_DISCOUNT`;
CREATE TABLE `WZZ_USER_DISCOUNT` (
  `USER_ID` varchar(64) NOT NULL COMMENT '用户ID',
  `DISC_ID` varchar(64) NOT NULL,
  UNIQUE KEY `Unique_User_DIsc` (`USER_ID`,`DISC_ID`),
  CONSTRAINT `FK_User_DIsc` FOREIGN KEY (`USER_ID`) REFERENCES `WZZ_USER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户优惠劵';

-- ----------------------------
-- Records of WZZ_USER_DISCOUNT
-- ----------------------------

-- ----------------------------
-- Table structure for WZZ_WIFI_SHOP
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_WIFI_SHOP`;
CREATE TABLE `WZZ_WIFI_SHOP` (
  `ID` varchar(64) NOT NULL COMMENT '店铺ID',
  `NAME` varchar(300) NOT NULL COMMENT '店铺名称',
  `ADDRESS` varchar(500) DEFAULT NULL COMMENT '店铺位置',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '描述',
  `CLASS_TYPE1` varchar(200) NOT NULL COMMENT '行业分类',
  `CLASS_TYPE2` varchar(200) NOT NULL COMMENT '行业分类',
  `WORK_TEL` varchar(20) DEFAULT NULL COMMENT '服务热线',
  `OVER_USER` varchar(50) DEFAULT NULL COMMENT '联系人',
  `MOBILE_TEL` varchar(20) DEFAULT NULL COMMENT '手机号',
  `WIFI` varchar(200) NOT NULL COMMENT 'WIFI',
  `WIFI_PASSWORD` varchar(100) NOT NULL COMMENT 'WIFI密码',
  `WIFI_LNG` float(20,5) DEFAULT NULL COMMENT '坐标Y',
  `WIFI_LAT` float(20,5) DEFAULT NULL COMMENT '坐标X',
  `FLOOR` varchar(200) DEFAULT NULL COMMENT '楼层',
  `PROVINCE` varchar(50) DEFAULT NULL COMMENT '省',
  `CITY` varchar(50) DEFAULT NULL COMMENT '市',
  `PIC_URL` varchar(2000) DEFAULT NULL COMMENT '图片地址',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `WIFI_X` float(20,5) DEFAULT NULL COMMENT '坐标Y',
  `WIFI_Y` float(20,5) DEFAULT NULL COMMENT '坐标X',
  `USER_NAME` varchar(100) NOT NULL COMMENT '创建用户手机号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='WIFI店铺';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP
-- ----------------------------
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('067c4f86043547108484b3242d7d994b', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76876', '19.60558', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/257a31070004442fa700d47fada273f9.jpg', '2015-12-04 18:20:42', '2015-12-04 18:20:42', '11303950.00000', '2180041.25000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('359cf03bb14d44b4abe091f40ca1f0ee', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76879', '19.60556', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/e4600de287ad4d81aa0dc5b1899ecc87.jpg', '2015-12-04 18:00:48', '2015-12-04 18:00:48', '11303955.00000', '2180039.25000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('5b20e7a6c9154532891ebed6b0d0f18d', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76887', '19.60552', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/302c47adf81240fe8c6b062a814411a6.jpg', '2015-12-04 18:07:45', '2015-12-04 18:07:45', '11303967.00000', '2180034.75000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('7c8c43a61da7404b80fe8e8cf3792015', '布谷网络科技', '海南省海口市龙华区国贸北路靠近海口金贸大厦', '企业建站、网络推广、电商', 'weishang', 'weishang', '089868521012', '王先生', '17789736151', 'a4:56:02:37:35:41', 'Bugu1668', '110.32191', '20.02766', '12', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/7a7656de1077469bb44f9028183db985.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/f472f2cdbb5f4c129080368ff4086e4f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/1cf29ae3ec594e7e80c73a344261c39d.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/a662444f657a4c61939af23b35308742.jpg', '2015-11-24 09:44:58', '2015-11-24 09:44:58', '11220717.00000', '2226974.50000', '');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('9563483e13284236b5effaf79af8209b', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76879', '19.60556', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/e1a7fa62208b47c197cbffa65b8ac314.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/dfec7f0625b34601ae44c89c527b41a2.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/c69159ec7f3e4b1ebbbccf3f243ada9f.jpg', '2015-12-04 13:18:01', '2015-12-04 13:18:01', '11303955.00000', '2180038.75000', '18789700861');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('bc7fe0bbcdf4422fa8a021c45031b8af', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76879', '19.60556', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/92010dab735a4cf8bb48e6f3e5a6c3c3.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/5d5f8d30042d4e2483a2a3aa41309f8c.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/81c7b27bc68e43b28d1078e3d8f2b4d6.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/5645b02455434f4d9afbeb9992ae8981.jpg', '2015-12-04 17:38:15', '2015-12-04 17:38:15', '11303955.00000', '2180039.00000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('db7437dfd7974948a7d18a892c131b42', '林小宇奶茶店（侨中分店）', '海南省文昌市教育东路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76878', '19.60559', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/4ce919cb049346cdb573c9b82e3cd795.jpg', '2015-12-04 17:42:05', '2015-12-04 17:42:05', '11303951.00000', '2180042.50000', '13307620922');

-- ----------------------------
-- Table structure for WZZ_WIFI_SHOP_DISCOUNT
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_WIFI_SHOP_DISCOUNT`;
CREATE TABLE `WZZ_WIFI_SHOP_DISCOUNT` (
  `ID` varchar(64) NOT NULL,
  `SHOP_ID` varchar(64) DEFAULT NULL COMMENT '店铺ID',
  `TITLE` varchar(500) NOT NULL COMMENT '标题',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '描述',
  `PHONE` varchar(100) DEFAULT NULL COMMENT '电话',
  `START` date DEFAULT NULL COMMENT '开始日期',
  `END` date DEFAULT NULL COMMENT '截止日期',
  PRIMARY KEY (`ID`),
  KEY `FK_Shop_Disc` (`SHOP_ID`),
  CONSTRAINT `FK_Shop_Disc` FOREIGN KEY (`SHOP_ID`) REFERENCES `WZZ_WIFI_SHOP` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠信息';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP_DISCOUNT
-- ----------------------------
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('b260027a-8676-45e2-a0c1-2e47259583aa', '7c8c43a61da7404b80fe8e8cf3792015', '优惠打7折咯。。。', '优惠打7折咯。。。', '11111111111', '2015-12-04', '2015-12-24');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('b6c21302-fb09-47de-962c-c3fe550bf519', '7c8c43a61da7404b80fe8e8cf3792015', '优惠打5折咯。。。', '优惠打5折咯。。。', '11111111111', '2015-12-04', '2015-12-24');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('c795bd92-7b74-4c6f-856d-f80d62d5efb6', '7c8c43a61da7404b80fe8e8cf3792015', '优惠打3折咯。。', '优惠打3折咯。。。', '11111111111', '2015-12-04', '2015-12-24');

-- ----------------------------
-- Table structure for WZZ_WIFI_SHOP_JOB
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_WIFI_SHOP_JOB`;
CREATE TABLE `WZZ_WIFI_SHOP_JOB` (
  `ID` varchar(64) NOT NULL,
  `SHOP_ID` varchar(64) DEFAULT NULL COMMENT '店铺ID',
  `TITLE` varchar(500) NOT NULL COMMENT '标题',
  `JOBDESC` varchar(1000) DEFAULT NULL COMMENT '岗位描述',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '描述',
  `USER` varchar(255) DEFAULT NULL COMMENT '联系人',
  `PHONE` varchar(100) DEFAULT NULL COMMENT '电话',
  `START` date DEFAULT NULL COMMENT '开始日期',
  `END` date DEFAULT NULL COMMENT '截止日期',
  PRIMARY KEY (`ID`),
  KEY `FK_Shop_Job` (`SHOP_ID`),
  CONSTRAINT `FK_Shop_Job` FOREIGN KEY (`SHOP_ID`) REFERENCES `WZZ_WIFI_SHOP` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招聘信息';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP_JOB
-- ----------------------------

-- ----------------------------
-- Table structure for WZZ_WIFI_SHOP_PIC
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_WIFI_SHOP_PIC`;
CREATE TABLE `WZZ_WIFI_SHOP_PIC` (
  `SHOP_ID` varchar(64) DEFAULT NULL COMMENT '店铺ID',
  `PIC_URL` varchar(500) DEFAULT NULL COMMENT '图片地址',
  KEY `FK_Reference_shop` (`SHOP_ID`),
  CONSTRAINT `FK_Reference_shop` FOREIGN KEY (`SHOP_ID`) REFERENCES `WZZ_WIFI_SHOP` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺图片';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP_PIC
-- ----------------------------
