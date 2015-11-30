/*
Navicat MySQL Data Transfer

Source Server         : 120.25.226.197
Source Server Version : 50537
Source Host           : 120.25.226.197:3306
Source Database       : wzz

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-11-30 22:32:56
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
INSERT INTO `WZZ_USER` VALUES ('', 'dddd', 'dddd', null, null, null, null, null, null);
INSERT INTO `WZZ_USER` VALUES ('001', '18974870731', '123456', 'sdfwer23erterw', '郭明华', null, 'hn', 'user', '2015-11-28 22:32:00');
INSERT INTO `WZZ_USER` VALUES ('002', '18789700861', '123456', null, '王海波', null, '', 'shop', '2015-11-30 19:27:16');
INSERT INTO `WZZ_USER` VALUES ('42fc14b496194a65912b2873c46f6853', '13307620922', '123456', null, '林小宇', null, null, 'proxy', '2015-11-28 22:32:53');

-- ----------------------------
-- Table structure for WZZ_USER_DISCOUNT
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_USER_DISCOUNT`;
CREATE TABLE `WZZ_USER_DISCOUNT` (
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `DISC_ID` varchar(64) DEFAULT NULL,
  KEY `FK_User_DIsc` (`USER_ID`),
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
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('7c8c43a61da7404b80fe8e8cf3792015', '布谷网络科技', '海南省海口市龙华区国贸北路靠近海口金贸大厦', '企业建站、网络推广、电商', 'weishang', 'weishang', '089868521012', '王先生', '17789736151', 'a4:56:02:37:35:41', 'Bugu1668', '110.32191', '20.02766', '12', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/7a7656de1077469bb44f9028183db985.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/f472f2cdbb5f4c129080368ff4086e4f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/1cf29ae3ec594e7e80c73a344261c39d.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/a662444f657a4c61939af23b35308742.jpg', '2015-11-24 09:44:58', '2015-11-24 09:44:58', '11220717.00000', '2226974.50000', '');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('85065c468e454c1b92049442d6c50061', '林小宇奶茶店（侨中分店）', '海南省文昌市文中路靠近中共文昌市委党校', '好吃又好喝的奶茶店', 'meishi', 'xiaochikuaicandian', '13307620922', '林小宇', '13307620922', 'd0:c7:c0:12:e4:26', '13034984965', '110.75906', '19.60574', '1', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/abdbbca8a47a4d21842c00aa99e63884.jpg', '2015-11-30 09:57:21', '2015-11-30 09:57:21', '11303021.00000', '2180059.00000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('9efea8e40f064f2bb024f4a2f4e191d5', '阿坝', '海南省文昌市教育路靠近惠群家园', '哈哈', 'meishi', 'huoguodian', '555', '阿坝', '112555555', '28:2c:b2:14:67:10', '123456', '110.76903', '19.60561', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/a53409ff52e64eca8035014a121310f5.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/f54aa14133cd4c5fb8e7340b6941b7de.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/59d3bcd40b9b4fbaa59fdeef91cc8089.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/98ce637a69a54180861f90535b45ab42.jpg', '2015-11-22 23:01:08', '2015-11-22 23:01:08', '11303972.00000', '2180045.00000', '');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('a41968971604430893795d2c4182011e', '林小宇奶茶店（侨中分店）', '海南省文昌市教育路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76890', '19.60557', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/7767edbd600d4787842a2243013875e5.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/156a09ccf61f441ebc4e8f6c1bc620b1.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/2107b76516854e8a94e2ba3befedc30f.jpg', '2015-11-29 10:49:15', '2015-11-29 10:49:15', '11303964.00000', '2180040.75000', '13307620922');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('fed3d9260993405689f172fda6d4fdbe', '林小宇奶茶店（侨中分店）', '海南省文昌市教育路靠近惠群家园', '好吃又好喝的奶茶店', 'meishi', 'huoguodian', '13307620922', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.76891', '19.60574', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/f3ec4be612e9442eacc53cb7753c7411.jpg', '2015-11-30 09:44:34', '2015-11-30 09:44:34', '11303948.00000', '2180059.00000', '13307620922');

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
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('788d33d0fa384641a9e7fb1ac000bb3d', null, '满100减30', '进店消费返利', '13307620922', '2015-11-30', '2015-12-08');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('81cc5ae329de4d3296f58e474a4f4035', null, '咯破坏', '听你', '13307620922', '2015-11-30', '2015-11-30');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('8c167390e71d40f29edafdcf87414d31', null, '100减50', '进店消费满100省', '13307620922', '2015-11-30', '2015-12-04');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('b0f6dff1ce8b427f8708e2f84930828c', 'fed3d9260993405689f172fda6d4fdbe', '满100减50', '进店优惠哦', '13307620922', '2015-11-30', '2015-12-05');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('e855600fb7d54bccaa5ababe19db6622', null, '满100减30', '只要有本优惠卷，进店消费可以返利', '13307620922', '2015-11-30', '2015-12-06');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('ecf246bb-7b5a-4a61-98dc-65fc5e56459c', 'a41968971604430893795d2c4182011e', '限时优惠，全场5折', '林小宇奶茶店（侨中分店），限时优惠，全场5折', '13307620922', '2015-12-12', '2015-12-14');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('fed3d9260993405689f172fda6d4fdbe', null, '满100减30', '进店消费返利', '13307620922', '2015-11-30', '2015-12-08');

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
INSERT INTO `WZZ_WIFI_SHOP_JOB` VALUES ('ecf246bb-7b5a-4a61-98dc-65fc5e56459c', 'a41968971604430893795d2c4182011e', '招聘店长', '负责分店事务', '林小宇奶茶店（侨中分店），招聘服务员，待遇从优', '林小宇', '13307620922', '2015-12-12', '2015-12-30');

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
