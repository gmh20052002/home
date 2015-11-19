/*
Navicat MySQL Data Transfer

Source Server         : 120.25.226.197
Source Server Version : 50537
Source Host           : 120.25.226.197:3306
Source Database       : wzz

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-11-17 23:06:59
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
  `USER_TYPE` varchar(100) DEFAULT NULL COMMENT '用户类型(user-用户、shoper-商户、proxyer-代理)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP用户信息';

-- ----------------------------
-- Records of WZZ_USER
-- ----------------------------

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='WIFI店铺';

-- ----------------------------
-- Records of WZZ_WIFI_SHOP
-- ----------------------------
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('0fa4212bad954cca8346b73cf217ff44', '测试-布谷网络', '海南省海口市龙华区玉沙横路靠近德派斯大厦', '布谷网络，专注建站、新闻推广、电商运营', 'weishang', 'weishang', '089868521021', '吴先生', '13006002560', 'a4:56:02:37:35:41', 'Bugu1668', '110.32152', '20.02856', '12', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/b155e3d4045b42ad812e049a5925f42f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/a83520f5099d4fa4ab81ffd4098c441c.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/919f3545b414497f99dd6d4c92c68f32.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/14832aa66976443da17e341acc3da60b.jpg', '2015-11-16 09:33:00', '2015-11-16 09:33:00', '11220593.00000', '2227074.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('1eee6b5a73524f23a2b8cad0181d6f72', '哈哈', '海南省文昌市教育路靠近惠群家园', '理你', 'meishi', 'zizhucanting', '66568', '孔雀', '13389894', '40:cb:a8:3f:6f:e8', '458', '110.76926', '19.60603', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/ad20c097f8404aab9bbe7ff16d0dbc1a.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/ab39fec4ede14363ab92c26c0dea9824.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/94af35507a4d4b6fbbf6986ff921df88.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d7f7810dbf4a4bb198a5dbdf7475d9c9.jpg', '2015-11-15 12:26:56', '2015-11-15 12:26:56', '11303953.00000', '2180091.00000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('2527fe6430c34cea8402aa2c67870bd2', '就看看', '海南省文昌市教育路靠近惠群家园', '考虑考虑', 'xiuxianyule', 'dianyingyuan', '55555', '就看看', '555', 'c8:3a:35:24:49:68', '5566', '110.76896', '19.60540', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/e5f140d1c4a0422fb58fc3c637d9e2ad.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d7db16d27dd64b3a9e41bbabdae5f2df.gif,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/3e79939e2c2b47d5a3ee5373b5cbd3c1.png', '2015-11-01 20:23:58', '2015-11-01 20:23:58', '11303986.00000', '2180021.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('28d877a22ed0496dae9176e10cbdcca8', 'HK咯哦', '海南省文昌市教育路靠近惠群家园', '啦啦啦啦啦', 'liren', 'lifadian', '555', '啦咔咔', '556', '28:2c:b2:14:67:10', '5563', '110.76962', '19.60654', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/ad945883a31145da95e830970f0a829b.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/eb51566fe47549579b012bca042a28cd.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/1734e8bac4c54880a3eb53bb87e351f3.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/c60492c0b13a44a48474f289b20449f2.jpg', '2015-11-01 20:43:51', '2015-11-01 20:43:51', '11303937.00000', '2180148.25000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('38bd1ed461904122a30a6a4db247bc9a', '干净利落', '海南省文昌市教育路靠近惠群家园', '可能性', 'zhusu', 'haohuajiudian', '5555', '刚看了', '4566', '28:2c:b2:14:67:10', '5566', '110.76963', '19.60647', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/d6811fa915b64615b809d4b8b92b03dc.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/1c10939673be4c99b9982b2c2d178c39.png', '2015-11-01 12:31:43', '2015-11-01 12:31:43', '11303945.00000', '2180140.50000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('39b224d48ae64873bd0d12b91971d899', '交警', '海南省文昌市教育路靠近惠群家园', '框架POS民工漫', 'meishi', 'rihanliaolidian', '86464', '魔攻咯了', '313165656', '28:2c:b2:14:67:10', '646566565', '110.76904', '19.60589', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/2be870e97f724fdb882b991a28dce365.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/afa3c3605c3b4b5297da7a237d12878d.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/52600c09b0d44f0da96dc99e3340fff2.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/f6e7decc925c4985bcf6610bda4acebb.jpg', '2015-11-15 12:54:16', '2015-11-15 12:54:16', '11303945.00000', '2180076.25000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('494b6dfb004e41289fb1395923b42097', '测试-商铺', '海南省海口市龙华区国贸北路靠近海口金贸大厦', '测试信息', 'xiaoqu', 'qita', '089888888888', '王先生', '17789736151', 'a4:56:02:37:35:41', 'Bugu1668', '110.32192', '20.02758', '12', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/0cd9ee677ed045b4b6dc473394f4e0b2.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/d39ba6abf1ee42ed8b2ff7f476d8e2e3.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/8e78343481334b01b0619c32521c2300.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/4b0ead570819433ca77573666c8d9bc9.jpg', '2015-11-17 14:32:08', '2015-11-17 14:32:08', '11220727.00000', '2226965.50000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('500b7dbd78424ea1bc5cfbbf09bad61a', '香港喜喜茶餐厅国贸玉沙分店', '海南省海口市龙华区玉沙路靠近满记甜品(玉沙路店)', '粤式早茶、糕点、烧腊、快餐', 'meishi', 'gedicaiguan', '089860878787', '吴经理', '13637651255', '64:09:80:18:c0:8e', '60878787', '110.31992', '20.02849', '3', 'hainansheng', 'haikou', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/a761a2dca3214f00a81a18e63ce64802.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/6b34e1e86d614c378f7929fe125d26e7.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/7bc962d91d74409184b0ac0a92b0a521.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/haikou/fe3e88291c2c4a969c96ba4da95a8ed8.jpg', '2015-11-16 10:44:08', '2015-11-16 10:44:08', '11220450.00000', '2227066.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('577ff3a0613145b79979dd6af452b98e', 'logo咯', '海南省文昌市教育路靠近惠群家园', '李隆基', 'meishi', 'zizhucanting', '56465', '空间', '56464', '28:2c:b2:14:67:10', '123456', '110.76917', '19.60619', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/6ec7f6dec5784f618b77d484dabfa943.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/6c12b1e988804d70b391f0eb1719c0df.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/4e056880834b4410afe4bfc199e6a0eb.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/097962f809304a239ad86a12ae53ee31.jpg', '2015-11-15 12:42:26', '2015-11-15 12:42:26', '11303930.00000', '2180109.25000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('74ed0d56e4824288a8b365509adbb850', '好囧', '海南省文昌市教育路靠近惠群家园', 'JJ后咯了', 'meishi', 'huoguodian', '66866868', '加进来', '5646868', '28:2c:b2:14:67:10', '5468668', '110.76904', '19.60627', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/3af931f7b23f4dcbb54b6ae5bdd1ce90.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/b3418da149ae418b9e5667d10de0072f.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/10f8bf5f46434e7a99ded6361bb6406e.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/f1cd5b34c9484f5aa32c1a8669b8dc70.jpg', '2015-11-15 12:37:33', '2015-11-15 12:37:33', '11303910.00000', '2180117.75000');
INSERT INTO `WZZ_WIFI_SHOP` VALUES ('cda73d0c1e3d47649ced12cc0dd9ddb3', '惠群', '海南省文昌市教育路靠近惠群家园', '不错不错', 'meishi', 'xicanting', '145578', '刘丽娜', '1338764488', '28:2c:b2:14:67:10', '15587', '110.76895', '19.60553', '6', 'hainansheng', 'wenchang', 'http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/c5c70f245cef463ab334f6043a80d9af.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/931de9c536d4492b89710e9abbef18eb.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/52da6935aa374e0d83a4ef26f4b19509.jpg,http://www.wangzhizhu.com/gateway/v1/showFtpFile?ftpUrl=/ftpdir/hainansheng/wenchang/60f6d86e84a640b488a47315e12b12e8.jpg', '2015-11-15 12:19:13', '2015-11-15 12:19:13', '11303974.00000', '2180035.75000');
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
