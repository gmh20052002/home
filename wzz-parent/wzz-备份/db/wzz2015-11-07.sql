/*
Navicat MySQL Data Transfer

Source Server         : 120.25.226.197
Source Server Version : 50537
Source Host           : 120.25.226.197:3306
Source Database       : wzz

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-11-07 10:31:01
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
  `IMEI` varchar(100) DEFAULT NULL COMMENT 'IMEI码',
  `USER_CNAME` varchar(200) DEFAULT NULL COMMENT '用户名称',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '描述',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP用户信息';

-- ----------------------------
-- Records of WZZ_USER
-- ----------------------------
INSERT INTO `WZZ_USER` VALUES ('18888888888', '18888888888', '18888888888', '王海波', '18888888888', null);

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='WIFI店铺';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP
-- ----------------------------
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('1575ebca46554baf889d3f20e39bd332', '谢娜', '海南省文昌市教育路靠近惠群家园', '麻将连连看咯你555', 'zhusu', 'jingjixingjiudian', '55555', '谢娜', '13384679447', '28:2c:b2:14:67:10', '123456', '110.76963', '19.60648', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/b2691bffd9ee4312b34a7d871c4e7534.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/4ac8c22f12f346f980fdaaecba8a990f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/a2ffb3a6d5964bbeb329487e0727b2e7.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/e8f08800f890421a84cdd50f6f4e9d8c.jpg', '2015-11-01 18:16:04', '2015-11-01 18:16:04', '11303945.00000', '2180141.25000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('200', '林小宇火锅店', '海南省文昌市教育路靠近惠群家园', '店铺描述', 'meishi', 'huoguodian', '0898-55555555', '林小宇', '13307620922', '28:2c:b2:14:67:10', '12345678', '111.00000', '20.00000', '2', '海南省', '文昌市', 'http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40f0ff85cbcad64034f78f01990.jpg,http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40f0ff85cbcad64034f78f01990.jpg', '2015-10-31 22:23:48', '2015-10-26 08:00:00', '500.00000', '500.00000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('201', '王海波餐厅', '海南省文昌市教育路靠近惠群家园', '店铺描述', 'meishi', 'huoguodian', '0898-55555555', '王海波', '13307620922', '28:2c:b2:14:67:11', '12345678', '111.00000', '20.00000', '2', '海南省', '文昌市', 'http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40f0ff85cbcad64034f78f01990.jpg,http://e.hiphotos.baidu.com/image/pic/item/72f082025aafa40f0ff85cbcad64034f78f01990.jpg', '2015-10-29 20:48:02', '2015-10-26 08:00:00', '300.00000', '400.00000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('251d32d63dd047768f28ed9873080ddc', '好粥道文昌分店', '海南省文昌市滨湾路靠近下村', '好吃好吃好好吃', 'meishi', 'xiaochikuaicandian', '4445555', '林小宇', '13307620922', '28:2c:b2:14:67:10', '123456789', '110.77743', '19.60859', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/b078340f6377450cb0d8f494a3ec0b61.png,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/1f883e7837294978a0bdca260956fb55.png,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/07c1c44859594b979f2600a1e49991b4.png,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/315ad726efec42ac8dd822e8344d42da.png', '2015-11-01 21:29:18', '2015-11-01 21:29:18', '11304475.00000', '2180375.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('2527fe6430c34cea8402aa2c67870bd2', '就看看', '海南省文昌市教育路靠近惠群家园', '考虑考虑', 'xiuxianyule', 'dianyingyuan', '55555', '就看看', '555', 'c8:3a:35:24:49:68', '5566', '110.76896', '19.60540', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/e5f140d1c4a0422fb58fc3c637d9e2ad.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d7db16d27dd64b3a9e41bbabdae5f2df.gif,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/3e79939e2c2b47d5a3ee5373b5cbd3c1.png', '2015-11-01 20:23:58', '2015-11-01 20:23:58', '11303986.00000', '2180021.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('28d877a22ed0496dae9176e10cbdcca8', 'HK咯哦', '海南省文昌市教育路靠近惠群家园', '啦啦啦啦啦', 'liren', 'lifadian', '555', '啦咔咔', '556', '28:2c:b2:14:67:10', '5563', '110.76962', '19.60654', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/ad945883a31145da95e830970f0a829b.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/eb51566fe47549579b012bca042a28cd.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/1734e8bac4c54880a3eb53bb87e351f3.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/c60492c0b13a44a48474f289b20449f2.jpg', '2015-11-01 20:43:51', '2015-11-01 20:43:51', '11303937.00000', '2180148.25000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('38bd1ed461904122a30a6a4db247bc9a', '干净利落', '海南省文昌市教育路靠近惠群家园', '可能性', 'zhusu', 'haohuajiudian', '5555', '刚看了', '4566', '28:2c:b2:14:67:10', '5566', '110.76963', '19.60647', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d6811fa915b64615b809d4b8b92b03dc.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/1c10939673be4c99b9982b2c2d178c39.png', '2015-11-01 12:31:43', '2015-11-01 12:31:43', '11303945.00000', '2180140.50000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('c6ef5bd2f99b495b8eb9a7007e0b464c', '何炅的店铺', '海南省文昌市教育路靠近惠群家园', '公积金明年', 'meishi', 'xicanting', '6655', '林小宇', '1334948864', '28:2c:b2:14:67:10', '123456', '110.76962', '19.60654', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/69a03635508945178cdee6c045b40ff5.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d1995f19bdbb406493e9b529992ad81d.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/7ac4046ede374800b345aa36add17f8d.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/6dae85c549b248bcbd756dedf0a2a1c3.jpg', '2015-11-01 12:41:17', '2015-11-01 12:41:17', '11303937.00000', '2180148.50000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('dddf3db21b2e402ea64c0a6266a45d4c', '考虑考虑', '海南省文昌市教育路靠近惠群家园', '啦啦啦啦啦', 'zhusu', 'jingjixingjiudian', '555', '考虑考虑', '5555', 'c8:3a:35:24:49:68', '555', '110.76902', '19.60552', '555', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/ce9f442e965e4de0a35c576bc18a376b.jpeg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/0e45f5ad62bb4b858936147e94b96300.jpeg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/b596f97995cf4ac2a7c3e8259905ca31.jpeg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/c4a174b4586c4382bda1d9489dfb5328.jpeg', '2015-11-01 21:10:02', '2015-11-01 21:10:02', '11303981.00000', '2180034.00000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('e5cada0183084a24bb40a1d097e6a0e8', '测试-汇隆大厦', '海南省海口市美兰区蓝天路靠近三湘人家(蓝天店)', '中心地段，交通方便', 'xiuxianyule', 'jiuba', '0898000000', '王先生', '18789700861', 'c0:61:18:ff:db:ba', '089811', '110.35714', '20.02514', '12', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/55f59dcac4aa49c182426c76c13e994f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/67e6f11284724cdeb6718a8fe2aabfef.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/8af4eced9c614ca0b894cdd80c244e09.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/be4ea3688d26483990bc10513e0b9038.jpg', '2015-11-01 22:26:09', '2015-11-01 22:26:09', '11224267.00000', '2226694.50000');

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
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('223', '200', '招聘服务员，待遇从优', '期待您的加盟！hhhhhh', '13307620922', '2015-10-30', '2015-11-30');
INSERT INTO `WZZ_WIFI_SHOP_DISCOUNT` VALUES ('225', '200', '发布优惠信息，全场打5折', '优惠信息，全场打5折', '13307620922', '2015-10-30', '2015-11-30');

-- ----------------------------
-- Table structure for WZZ_WIFI_SHOP_JOB
-- ----------------------------
DROP TABLE IF EXISTS `WZZ_WIFI_SHOP_JOB`;
CREATE TABLE `WZZ_WIFI_SHOP_JOB` (
  `ID` varchar(64) NOT NULL,
  `SHOP_ID` varchar(64) DEFAULT NULL COMMENT '店铺ID',
  `TITLE` varchar(500) NOT NULL COMMENT '标题',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '描述',
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
INSERT INTO `WZZ_WIFI_SHOP_JOB` VALUES ('222', '201', '招聘厨师，待遇从优', '', '13307620922', '2015-10-30', '2015-11-30');

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
