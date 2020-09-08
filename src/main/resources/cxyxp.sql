/*
Navicat MySQL Data Transfer

Source Server         : 阿里
Source Server Version : 50728
Source Host           : www.cxysl.cn:3306
Source Database       : cxyxp

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-07-09 11:25:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(255) NOT NULL AUTO_INCREMENT COMMENT '顾客id',
  `customerName` varchar(100) DEFAULT NULL COMMENT '顾客姓名',
  `customerSex` varchar(100) DEFAULT NULL COMMENT '顾客性别',
  `customerPhone` varchar(100) DEFAULT NULL COMMENT '顾客电话',
  `customerAddress` varchar(100) DEFAULT NULL COMMENT '顾客收货地址',
  `customerPicture` varchar(100) DEFAULT NULL COMMENT '顾客头像',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='顾客信息表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('2', '周星驰', '男', '15145629463', '中国香港', 'http://www.cxysl.cn/images/WX_img/t/zxc.jpg');
INSERT INTO `customer` VALUES ('3', '胡歌', '男', '13746519465', '上海', 'http://www.cxysl.cn/images/WX_img/t/hg.jpg');
INSERT INTO `customer` VALUES ('4', 'Taylor Swift', '女', '946215', '美国', 'http://www.cxysl.cn/images/WX_img/t/tay.jpg');
INSERT INTO `customer` VALUES ('5', '张国荣', '男', '984621', '香港', 'http://www.cxysl.cn/images/WX_img/t/zgr.jpg');
INSERT INTO `customer` VALUES ('6', '赫本', '女', '946521', '英国', 'http://www.cxysl.cn/images/WX_img/t/hb.jpg');
INSERT INTO `customer` VALUES ('7', '陈世锦', '男', '10086', '公安', 'http://www.cxysl.cn/images/WX_img/t/csj.jpg');
INSERT INTO `customer` VALUES ('8', '罗青', '女', '10010', '公安', 'http://www.cxysl.cn/images/WX_img/t/lq.jpg');
INSERT INTO `customer` VALUES ('9', '陈红文', '男', '10011', '公安', 'http://www.cxysl.cn/images/WX_img/t/chw.jpg');
INSERT INTO `customer` VALUES ('10', '老张蒙', '男', '9527', '监利', 'http://www.cxysl.cn/images/WX_img/t/zm.jpg');
INSERT INTO `customer` VALUES ('11', '董思危', '男', '9527', '宜昌', 'http://www.cxysl.cn/images/WX_img/t/dsw.jpg');
INSERT INTO `customer` VALUES ('12', '如来佛祖', '男', '11111', '西天', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('13', '白龙马', '公', '7641381', '东海龙宫', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('14', '宋正慧', '女', '15759159298', '厦门', 'http://www.cxysl.cn/images/WX_img/t/szh.jpg');
INSERT INTO `customer` VALUES ('15', '习大大', '男', '17684569751', '北京', 'http://www.cxysl.cn/images/WX_img/t/err0.jpg');
INSERT INTO `customer` VALUES ('37', '周润发', '男', '952712138', '香港', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('41', '李连杰', '男', '7.88414', '香港', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('42', '成龙', '男', '12131315', '香港', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('44', '111', '11', '1111', '1111', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('45', '憨批', '私密', '12345678911', '哈哈哈', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('46', '出来了', '私密', '135', '翼', 'http://www.cxysl.cn/images/WX_img/none.jpg');
INSERT INTO `customer` VALUES ('47', '曹林子', '女', '13114310866', '武汉晴川学院', 'http://www.cxysl.cn/images/WX_img/t/clz.jpg');

-- ----------------------------
-- Table structure for customerLogin
-- ----------------------------
DROP TABLE IF EXISTS `customerLogin`;
CREATE TABLE `customerLogin` (
  `username` varchar(100) NOT NULL COMMENT '账号',
  `pwd` varchar(100) NOT NULL COMMENT '密码',
  `customerId` int(11) DEFAULT NULL COMMENT '顾客id',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客微信小程序登入的账号密码';

-- ----------------------------
-- Records of customerLogin
-- ----------------------------
INSERT INTO `customerLogin` VALUES ('111', '111', '44');
INSERT INTO `customerLogin` VALUES ('123', '123', '45');
INSERT INTO `customerLogin` VALUES ('习大大', '123456', '1');
INSERT INTO `customerLogin` VALUES ('周星驰', '123456', '2');
INSERT INTO `customerLogin` VALUES ('张国荣', '12138', '5');
INSERT INTO `customerLogin` VALUES ('成龙', '12138952700', '42');
INSERT INTO `customerLogin` VALUES ('曹林子', '123', '47');
INSERT INTO `customerLogin` VALUES ('李连杰', '9527', '41');
INSERT INTO `customerLogin` VALUES ('罗青', '980118', '8');
INSERT INTO `customerLogin` VALUES ('考虑考虑', '125', '46');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodsName` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `goodsPicture` varchar(100) DEFAULT NULL COMMENT '商品主图片',
  `purchasePrice` double(10,2) DEFAULT NULL COMMENT '商品进价',
  `goodsPrice` double DEFAULT NULL COMMENT '商品售价',
  `goodsCount` int(11) DEFAULT NULL COMMENT '商品库存量',
  `goodsDescribe` varchar(100) DEFAULT NULL COMMENT '商品说明',
  `goodLabel1` varchar(100) DEFAULT NULL COMMENT '标签1',
  `goodLabel2` varchar(100) DEFAULT NULL COMMENT '标签2',
  `goodLabel3` varchar(100) DEFAULT NULL COMMENT '标签3',
  `goodsUpdates` varchar(2) DEFAULT NULL COMMENT '商品上下架状态',
  `typeId` int(11) DEFAULT NULL COMMENT '商品类别',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '裤子', 'https://www.cxysl.cn/images/FZ/tb_kz01.jpg', '50.00', '88.88', '12200', '特步2019年最潮款女裤', '特价', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('2', '休闲裤', 'https://www.cxysl.cn/images/FZ/tb_kz02.jpg', '70.00', '100.5', '9522', '特步2020最新款休闲裤', '潮流', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('3', '运动裤', 'https://www.cxysl.cn/images/FZ/tb_kz03.jpg', '50.00', '89.5', '12138', '特步2019年销量最高裤子', '特价', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('4', '跑鞋', 'https://www.cxysl.cn/images/FZ/tb_xz01.jpg', '70.00', '100.5', '9524', '特步2020最新款跑鞋', '潮流', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('5', '球鞋', 'https://www.cxysl.cn/images/FZ/tb_xz02.jpg', '50.00', '89.5', '12138', '特步2019年销量最高球鞋', '特价', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('6', '休闲鞋', 'https://www.cxysl.cn/images/FZ/tb_xz03.jpg', '70.00', '100.5', '9527', '特步2020最新款休闲鞋', '潮流', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('7', '运动装', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', '50.00', '89.5', '12133', '特步2020最新运动装', '特价', '最新款', '凉快', 'y', '1');
INSERT INTO `goods` VALUES ('8', '运动裤', 'https://www.cxysl.cn/images/FZ/hh_kz01.jpg', '70.00', '100.5', '9526', '花花公子2020年最新运动裤', '潮流', '最新款', '凉快', 'y', '2');
INSERT INTO `goods` VALUES ('9', '工装裤', 'https://www.cxysl.cn/images/FZ/hh_kz02.jpg', '50.00', '89.5', '12138', '花花公子最潮工装裤', '特价', '最新款', '凉快', 'y', '2');
INSERT INTO `goods` VALUES ('10', '外套', 'https://www.cxysl.cn/images/FZ/hh_sy02.jpg', '70.00', '100.5', '9527', '花花公子2020最新款男士外套', '潮流', '最新款', '凉快', 'y', '2');
INSERT INTO `goods` VALUES ('12', '外套', 'https://www.cxysl.cn/images/FZ/hh_wt22.jpg', '70.00', '100.5', '9527', '花花公子2020最潮款男士外套', '潮流', '最新款', '凉快', 'n', '2');
INSERT INTO `goods` VALUES ('13', '球鞋', 'https://www.cxysl.cn/images/FZ/hh_wz01.jpg', '50.00', '89.5', '12138', '花花公子2020年最新球鞋', '特价', '最新款', '凉快', 'y', '2');
INSERT INTO `goods` VALUES ('14', 'T恤衫', 'https://www.cxysl.cn/images/FZ/hh_sy01.jpg', '70.00', '100.5', '9526', '花花公子2020最新款T恤衫', '潮流', '最新款', '凉快', 'y', '2');
INSERT INTO `goods` VALUES ('15', '裤子', 'https://www.cxysl.cn/images/FZ/ad_kz01.jpg', '50.00', '89.5', '12138', '阿迪达斯2019年最潮裤子', '特价', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('16', '运动裤', 'https://www.cxysl.cn/images/FZ/ad_kz02.jpg', '70.00', '100.5', '9525', '阿迪达斯2020年最新男士运动裤', '潮流', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('17', 'T恤衫', 'https://www.cxysl.cn/images/FZ/ad_sy01.jpg', '50.00', '89.5', '12138', '阿迪达斯年度销量最高T血衫', '特价', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('18', '短袖', 'https://www.cxysl.cn/images/FZ/ad_sy03.jpg', '70.00', '100.5', '9527', '阿迪达斯2019年最潮短袖', '潮流', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('19', 'T恤衫', 'https://www.cxysl.cn/images/FZ/ad_sy02.jpg', '50.00', '89.5', '12138', '阿迪达斯2020年最新T血衫', '特价', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('20', '板鞋', 'https://www.cxysl.cn/images/FZ/ad_xz01.jpg', '70.00', '100.5', '9527', '阿迪达斯最新款板鞋', '潮流', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('21', '球鞋', 'https://www.cxysl.cn/images/FZ/ad_xz03.jpg', '50.00', '89.5', '12132', '阿迪达斯2020最潮球鞋', '特价', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('22', '跑鞋', 'https://www.cxysl.cn/images/FZ/ad_xz06.jpg', '70.00', '100.5', '9527', '阿迪达斯2019年最新款跑鞋', '潮流', '最新款', '凉快', 'y', '3');
INSERT INTO `goods` VALUES ('23', '鞋子', 'https://www.cxysl.cn/images/FZ/ad_xz04.jpg', '600.00', '1250', '12138', '阿迪达斯2020最新款女鞋', '潮流', '冬季', '时尚', 'y', '3');
INSERT INTO `goods` VALUES ('28', '外套', 'https://www.cxysl.cn/images/FZ/ln_sy01.jpg', '70.00', '100.5', '495', '李宁2020年最新外套', '特价', '最新款', '凉快', 'y', '4');
INSERT INTO `goods` VALUES ('29', '运动装', 'https://www.cxysl.cn/images/FZ/ln_sy02.jpg', '70.00', '100.5', '500', '李宁2020年最潮运动装', '潮流', '最新款', '凉快', 'y', '4');
INSERT INTO `goods` VALUES ('30', '跑鞋', 'https://www.cxysl.cn/images/FZ/ln_xz01.jpg', '120.00', '189', '12134', '李宁年度销量最高跑鞋', '特价', '最新款', '凉快', 'y', '4');
INSERT INTO `goods` VALUES ('31', '球鞋', 'https://www.cxysl.cn/images/FZ/ln_xz02.jpg', '15.00', '60', '12138', '李宁2019年旧款鞋子打折出售', '潮流', '最新款', '凉快', 'y', '4');
INSERT INTO `goods` VALUES ('32', '鞋子', 'https://www.cxysl.cn/images/FZ/ad_xz05.jpg', '30.00', '120', '9526', '阿迪达斯旧款鞋子', '黑色', '潮流', '特价', 'y', '3');
INSERT INTO `goods` VALUES ('33', '空', 'http://www.cxysl.cn/images/WX_img/none.jpg', '0.00', '1000', '10086', 'none', '特价', '最新款', '凉快', 'y', '4');
INSERT INTO `goods` VALUES ('34', '无图片', 'http://www.cxysl.cn/images/WX_img/none.jpg', '10.00', '30', '10180', '暂无图片', '潮流', '最新款', '凉快', 'y', '4');

-- ----------------------------
-- Table structure for goodsPicture
-- ----------------------------
DROP TABLE IF EXISTS `goodsPicture`;
CREATE TABLE `goodsPicture` (
  `pictureId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pictureOne` varchar(255) DEFAULT NULL COMMENT '图片1',
  `pictureTwo` varchar(255) DEFAULT NULL COMMENT '图片2',
  `pictureThree` varchar(255) DEFAULT NULL COMMENT '图片3',
  `pictureFour` varchar(255) DEFAULT NULL COMMENT '图片4',
  `pictureFive` varchar(255) DEFAULT NULL COMMENT '图片5',
  `goodsId` varchar(255) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`pictureId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='商品的图片，默认5张，做轮播图';

-- ----------------------------
-- Records of goodsPicture
-- ----------------------------
INSERT INTO `goodsPicture` VALUES ('1', 'https://www.cxysl.cn/images/FZ/tb_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz01.jpg', '1');
INSERT INTO `goodsPicture` VALUES ('2', 'https://www.cxysl.cn/images/FZ/tb_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz02.jpg', '2');
INSERT INTO `goodsPicture` VALUES ('3', 'https://www.cxysl.cn/images/FZ/tb_kz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_kz03.jpg', '3');
INSERT INTO `goodsPicture` VALUES ('4', 'https://www.cxysl.cn/images/FZ/tb_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz01.jpg', '4');
INSERT INTO `goodsPicture` VALUES ('14', 'https://www.cxysl.cn/images/FZ/tb_xz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz02.jpg', '5');
INSERT INTO `goodsPicture` VALUES ('16', 'https://www.cxysl.cn/images/FZ/tb_xz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_xz03.jpg', '6');
INSERT INTO `goodsPicture` VALUES ('20', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', '7');
INSERT INTO `goodsPicture` VALUES ('21', 'https://www.cxysl.cn/images/FZ/hh_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_kz01.jpg', '8');
INSERT INTO `goodsPicture` VALUES ('22', 'https://www.cxysl.cn/images/FZ/hh_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_kz02.jpg', '9');
INSERT INTO `goodsPicture` VALUES ('23', 'https://www.cxysl.cn/images/FZ/hh_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_sy02.jpg', '10');
INSERT INTO `goodsPicture` VALUES ('24', 'https://www.cxysl.cn/images/FZ/hh_wt22.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_wt22.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_wt22.jpg', '12');
INSERT INTO `goodsPicture` VALUES ('25', 'https://www.cxysl.cn/images/FZ/hh_wz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_wz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_wz01.jpg', '13');
INSERT INTO `goodsPicture` VALUES ('26', 'https://www.cxysl.cn/images/FZ/hh_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/hh_sy01.jpg', '14');
INSERT INTO `goodsPicture` VALUES ('27', 'https://www.cxysl.cn/images/FZ/ad_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_kz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_kz01.jpg', '15');
INSERT INTO `goodsPicture` VALUES ('28', 'https://www.cxysl.cn/images/FZ/ad_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_kz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_kz02.jpg', '16');
INSERT INTO `goodsPicture` VALUES ('29', 'https://www.cxysl.cn/images/FZ/ad_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy01.jpg', '17');
INSERT INTO `goodsPicture` VALUES ('30', 'https://www.cxysl.cn/images/FZ/ad_sy03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy03.jpg', '18');
INSERT INTO `goodsPicture` VALUES ('31', 'https://www.cxysl.cn/images/FZ/ad_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_sy02.jpg', '19');
INSERT INTO `goodsPicture` VALUES ('32', 'https://www.cxysl.cn/images/FZ/ad_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz01.jpg', '20');
INSERT INTO `goodsPicture` VALUES ('33', 'https://www.cxysl.cn/images/FZ/ad_xz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz03.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz03.jpg', '21');
INSERT INTO `goodsPicture` VALUES ('34', 'https://www.cxysl.cn/images/FZ/ad_xz06.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz06.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz06.jpg', '22');
INSERT INTO `goodsPicture` VALUES ('35', 'https://www.cxysl.cn/images/FZ/ad_xz04.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz04.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz04.jpg', '23');
INSERT INTO `goodsPicture` VALUES ('36', 'https://www.cxysl.cn/images/FZ/ln_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_sy01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_sy01.jpg', '28');
INSERT INTO `goodsPicture` VALUES ('37', 'https://www.cxysl.cn/images/FZ/ln_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_sy02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_sy02.jpg', '29');
INSERT INTO `goodsPicture` VALUES ('38', 'https://www.cxysl.cn/images/FZ/ln_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_xz01.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_xz01.jpg', '30');
INSERT INTO `goodsPicture` VALUES ('39', 'https://www.cxysl.cn/images/FZ/ln_xz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_xz02.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ln_xz02.jpg', '31');
INSERT INTO `goodsPicture` VALUES ('40', 'https://www.cxysl.cn/images/FZ/ad_xz05.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz05.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'https://www.cxysl.cn/images/FZ/ad_xz05.jpg', '32');
INSERT INTO `goodsPicture` VALUES ('41', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', '33');
INSERT INTO `goodsPicture` VALUES ('42', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', 'http://www.cxysl.cn/images/WX_img/none.jpg', '34');

-- ----------------------------
-- Table structure for goodsPurchase
-- ----------------------------
DROP TABLE IF EXISTS `goodsPurchase`;
CREATE TABLE `goodsPurchase` (
  `purchaseId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `purchaseCount` int(11) DEFAULT NULL COMMENT '采购数量',
  `purchasePrice` double DEFAULT NULL COMMENT '进价',
  `purchaseDate` varchar(100) DEFAULT NULL COMMENT '采购日期',
  `goodsName` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`purchaseId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='商品采购记录表';

-- ----------------------------
-- Records of goodsPurchase
-- ----------------------------
INSERT INTO `goodsPurchase` VALUES ('1', '100', '55', '2020.1.1', '测试', '1');
INSERT INTO `goodsPurchase` VALUES ('2', '100', '55', '2020.1.1', '测试', '2');
INSERT INTO `goodsPurchase` VALUES ('3', '100', '55', '2020.1.1', '测试', '3');
INSERT INTO `goodsPurchase` VALUES ('4', '-6', '30', ' 2020-01-01  18:53', '衬衣', '32');
INSERT INTO `goodsPurchase` VALUES ('5', '10086', '100', ' 2020-01-01  18:55', '空', '33');
INSERT INTO `goodsPurchase` VALUES ('6', '10010', '10', ' 2020-01-01  19:13', '无图片', '34');
INSERT INTO `goodsPurchase` VALUES ('7', '10', '10', ' 2020-01-01  20:49', '无图片', '34');
INSERT INTO `goodsPurchase` VALUES ('8', '80', '10', ' 2020-01-03  10:19', '无图片', '34');
INSERT INTO `goodsPurchase` VALUES ('9', '80', '10', ' 2020-01-03  14:03', '无图片', '34');
INSERT INTO `goodsPurchase` VALUES ('10', '2', '50', ' 2020-01-04  16:53', 'T恤衫', '1');
INSERT INTO `goodsPurchase` VALUES ('11', '-2', '50', ' 2020-01-04  16:53', 'T恤衫', '1');
INSERT INTO `goodsPurchase` VALUES ('12', '2', '50', ' 2020-01-06  11:09', 'T恤衫', '1');
INSERT INTO `goodsPurchase` VALUES ('13', '2', '50', ' 2020-05-14  16:59', '裤子', '1');
INSERT INTO `goodsPurchase` VALUES ('14', '3', '50', ' 2020-05-22  15:31', '裤子', '1');
INSERT INTO `goodsPurchase` VALUES ('15', '4', '0', ' 2020-05-28  12:30', '空', '33');
INSERT INTO `goodsPurchase` VALUES ('16', '-4', '0', ' 2020-05-28  12:30', '空', '33');
INSERT INTO `goodsPurchase` VALUES ('17', '70', '50', ' 2020-06-17  17:39', '裤子', '1');

-- ----------------------------
-- Table structure for goodsType
-- ----------------------------
DROP TABLE IF EXISTS `goodsType`;
CREATE TABLE `goodsType` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类别名',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of goodsType
-- ----------------------------
INSERT INTO `goodsType` VALUES ('1', '特步');
INSERT INTO `goodsType` VALUES ('2', '花花公子');
INSERT INTO `goodsType` VALUES ('3', '阿迪达斯');
INSERT INTO `goodsType` VALUES ('4', '李宁');

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `expressId` varchar(100) DEFAULT NULL COMMENT 'id',
  `orderId` int(11) DEFAULT NULL COMMENT '订单号id',
  `customerId` int(11) DEFAULT NULL COMMENT '顾客id',
  `customerName` varchar(100) DEFAULT NULL COMMENT '顾客名字',
  `customerAddress` varchar(100) DEFAULT NULL COMMENT '顾客收货地址',
  `customerPhone` varchar(100) DEFAULT NULL COMMENT '顾客电话',
  `logisticsState` varchar(100) DEFAULT NULL COMMENT '物流状态',
  `logisticsAddress` varchar(100) DEFAULT NULL COMMENT '物流出发地'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流信息表';

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('001', '1', '7', '陈世锦', '公安', '10086', '已收货', '武汉');
INSERT INTO `logistics` VALUES ('002', '2', '8', '罗青', '公安', '10010', '已收货', '公安');
INSERT INTO `logistics` VALUES ('003', '3', '10', '老张蒙', '监利', '9527', '待发货', '武汉');
INSERT INTO `logistics` VALUES ('004', '4', '13', '白龙马', '东海', '7641381', '待发货', '武汉');
INSERT INTO `logistics` VALUES ('005', '5', '4', 'Taylor Swift', '美国', '946215', '待发货', '美国');
INSERT INTO `logistics` VALUES ('006', '6', '14', '宋正慧', '厦门', '15759159298', '待发货', '厦门');
INSERT INTO `logistics` VALUES ('007', '7', '20', '阿萨德', '地球', '10011', '待发货', '武汉');
INSERT INTO `logistics` VALUES ('v769eomss9', '14', '9', '陈红文', '公安', '10011', '待收货', '武汉');

-- ----------------------------
-- Table structure for orderDetails
-- ----------------------------
DROP TABLE IF EXISTS `orderDetails`;
CREATE TABLE `orderDetails` (
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `goodsName` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `buyCount` int(11) DEFAULT NULL COMMENT '购买数量',
  `goodsPrice` double DEFAULT NULL COMMENT '商品价格',
  `orderId` int(11) DEFAULT NULL COMMENT '订单号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表';

-- ----------------------------
-- Records of orderDetails
-- ----------------------------
INSERT INTO `orderDetails` VALUES ('1', 'T恤衫', '1', '88.88', '1');
INSERT INTO `orderDetails` VALUES ('30', 'WIFI', '1', '189', '1');
INSERT INTO `orderDetails` VALUES ('31', '水杯', '2', '60', '2');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '1', '120', '2');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '1', '120', '6');
INSERT INTO `orderDetails` VALUES ('1', 'T恤衫', '1', '88.88', '6');
INSERT INTO `orderDetails` VALUES ('22', '机械键盘', '1', '100.5', '6');
INSERT INTO `orderDetails` VALUES ('28', '板鞋', '2', '100.5', '3');
INSERT INTO `orderDetails` VALUES ('20', '短裤', '4', '100.5', '3');
INSERT INTO `orderDetails` VALUES ('31', '水杯', '1', '60', '4');
INSERT INTO `orderDetails` VALUES ('32', 'T恤衫', '1', '88.88', '4');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '10', '120', '5');
INSERT INTO `orderDetails` VALUES ('1', 'T恤衫', '100', '88.88', '5');
INSERT INTO `orderDetails` VALUES ('20', '短裤', '10', '100.5', '5');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '2', '120', '12');
INSERT INTO `orderDetails` VALUES ('31', '水杯', '1', '60', '14');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '1', '120', '14');
INSERT INTO `orderDetails` VALUES ('2', '2020最新款', '10', '100.05', '23');
INSERT INTO `orderDetails` VALUES ('1', '2019年最新版终结者键盘上架', '5', '88.88', '23');
INSERT INTO `orderDetails` VALUES ('14', '2020最新款', '1', '100.5', '23');
INSERT INTO `orderDetails` VALUES ('8', '犹如肌肤般光滑，手感极好', '1', '100.5', '23');
INSERT INTO `orderDetails` VALUES ('8', '犹如肌肤般光滑，手感极好', '1', '100.5', '24');
INSERT INTO `orderDetails` VALUES ('1', '2019年最新版终结者键盘上架', '5', '88.88', '27');
INSERT INTO `orderDetails` VALUES ('14', '2020最新款', '1', '100.5', '28');
INSERT INTO `orderDetails` VALUES ('30', 'WIFI', '1', '189', '32');
INSERT INTO `orderDetails` VALUES ('1', '2019年最新版终结者键盘上架', '4', '88.88', '34');
INSERT INTO `orderDetails` VALUES ('4', '2020最新款', '1', '100.5', '34');
INSERT INTO `orderDetails` VALUES ('2', '2020最新款', '2', '100.05', '35');
INSERT INTO `orderDetails` VALUES ('1', '2019年最新版终结者键盘上架', '2', '88.88', '35');
INSERT INTO `orderDetails` VALUES ('4', '2020最新款', '1', '100.5', '35');
INSERT INTO `orderDetails` VALUES ('7', '2019年最新版终结者键盘上架', '1', '89.5', '35');
INSERT INTO `orderDetails` VALUES ('2', '2020最新款', '2', '100.05', '36');
INSERT INTO `orderDetails` VALUES ('1', '2019年最新版终结者键盘上架', '2', '88.88', '36');
INSERT INTO `orderDetails` VALUES ('4', '2020最新款', '1', '100.5', '36');
INSERT INTO `orderDetails` VALUES ('7', '2019年最新版终结者键盘上架', '1', '89.5', '36');
INSERT INTO `orderDetails` VALUES ('32', '衬衣', '1', '120', '37');
INSERT INTO `orderDetails` VALUES ('28', '外套', '1', '100.5', '38');
INSERT INTO `orderDetails` VALUES ('1', '特步2019年最潮款女裤', '1', '88.88', '39');
INSERT INTO `orderDetails` VALUES ('16', '阿迪达斯2020年最新男士运动裤', '1', '100.5', '39');
INSERT INTO `orderDetails` VALUES ('21', '阿迪达斯2020最潮球鞋', '3', '89.5', '39');
INSERT INTO `orderDetails` VALUES ('28', '李宁2020年最新外套', '1', '100.5', '39');
INSERT INTO `orderDetails` VALUES ('1', '特步2019年最潮款女裤', '1', '88.88', '40');
INSERT INTO `orderDetails` VALUES ('16', '阿迪达斯2020年最新男士运动裤', '1', '100.5', '40');
INSERT INTO `orderDetails` VALUES ('21', '阿迪达斯2020最潮球鞋', '3', '89.5', '40');
INSERT INTO `orderDetails` VALUES ('28', '李宁2020年最新外套', '1', '100.5', '40');
INSERT INTO `orderDetails` VALUES ('28', '李宁2020年最新外套', '1', '100.5', '41');
INSERT INTO `orderDetails` VALUES ('28', '李宁2020年最新外套', '1', '100.5', '42');
INSERT INTO `orderDetails` VALUES ('7', '运动装', '1', '89.5', '43');
INSERT INTO `orderDetails` VALUES ('7', '运动装', '1', '89.5', '44');
INSERT INTO `orderDetails` VALUES ('2', '休闲裤', '1', '100.5', '45');
INSERT INTO `orderDetails` VALUES ('7', '特步2020最新运动装', '1', '89.5', '46');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `customerName` varchar(100) DEFAULT NULL COMMENT '顾客名',
  `customerId` int(11) NOT NULL COMMENT '顾客id',
  `orderPrice` double DEFAULT NULL COMMENT '订单总金额',
  `orderDate` varchar(100) DEFAULT NULL COMMENT '下单日期',
  `orderState` varchar(100) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '陈世锦', '7', '378.38', '2020-01-02   9:12', '已支付');
INSERT INTO `orders` VALUES ('2', '罗青', '8', '240', '2020-01-02   10:10', '已支付');
INSERT INTO `orders` VALUES ('3', '老张蒙', '10', '603', '2020-02-31   15:10', '待付款');
INSERT INTO `orders` VALUES ('4', '白龙马', '13', '148.88', '2020-02-15    05:20', '待付款');
INSERT INTO `orders` VALUES ('5', 'Taylor Swift', '4', '11093', '2019-11-11    20:40', '已支付');
INSERT INTO `orders` VALUES ('6', '宋正慧', '14', '309.38', '2019-12-12    12:20', '已支付');
INSERT INTO `orders` VALUES ('7', '阿萨德', '20', '200', '2019-10-10     11:11', '待付款');
INSERT INTO `orders` VALUES ('12', '董思危', '11', '240', '2020-01-06  11:21', '待付款');
INSERT INTO `orders` VALUES ('14', '陈红文', '9', '180', '2020-01-07  18:36', '待付款');
INSERT INTO `orders` VALUES ('23', '周星驰', '2', '1645.9', ' 2020-01-14  19:44', '待付款');
INSERT INTO `orders` VALUES ('24', '周星驰', '2', '100.5', ' 2020-01-14  20:29', '已支付');
INSERT INTO `orders` VALUES ('27', '周星驰', '2', '444.4', ' 2020-01-15  10:29', '待付款');
INSERT INTO `orders` VALUES ('28', '周星驰', '2', '100.5', ' 2020-01-15  10:29', '待付款');
INSERT INTO `orders` VALUES ('32', '周星驰', '2', '189', ' 2020-01-15  11:40', '待付款');
INSERT INTO `orders` VALUES ('33', '周星驰', '2', '100.5', ' 2020-01-15  20:03', '待付款');
INSERT INTO `orders` VALUES ('34', '周星驰', '2', '456.02', ' 2020-01-16  10:53', '待付款');
INSERT INTO `orders` VALUES ('35', '周星驰', '2', '567.86', ' 2020-02-24  14:17', '待付款');
INSERT INTO `orders` VALUES ('36', '周星驰', '2', '567.86', ' 2020-02-24  14:17', '待付款');
INSERT INTO `orders` VALUES ('37', '周星驰', '2', '120', ' 2020-02-24  14:30', '待付款');
INSERT INTO `orders` VALUES ('38', '周星驰', '2', '100.5', ' 2020-05-14  17:00', '待付款');
INSERT INTO `orders` VALUES ('39', '周星驰', '2', '558.38', ' 2020-05-22  15:26', '待付款');
INSERT INTO `orders` VALUES ('40', '周星驰', '2', '558.38', ' 2020-05-22  15:26', '待付款');
INSERT INTO `orders` VALUES ('41', '周星驰', '2', '100.5', ' 2020-05-23  09:42', '待付款');
INSERT INTO `orders` VALUES ('42', '周星驰', '2', '100.5', ' 2020-05-23  09:42', '待付款');
INSERT INTO `orders` VALUES ('43', '周星驰', '2', '89.5', ' 2020-05-23  09:43', '待付款');
INSERT INTO `orders` VALUES ('44', '曹林子', '47', '89.5', ' 2020-06-10  23:11', '待付款');
INSERT INTO `orders` VALUES ('45', '曹林子', '47', '100.5', ' 2020-06-10  23:11', '待付款');
INSERT INTO `orders` VALUES ('46', '曹林子', '47', '89.5', ' 2020-06-10  23:11', '待付款');

-- ----------------------------
-- Table structure for shoppingcar
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `goodsName` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `goodsPicture` varchar(100) DEFAULT NULL COMMENT '商品主图片',
  `goodsPrice` double DEFAULT NULL,
  `buyCount` int(11) DEFAULT NULL COMMENT '购买数量',
  `goodsDescribe` varchar(100) DEFAULT NULL COMMENT '商品说明',
  `customerId` int(11) DEFAULT NULL COMMENT '顾客id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of shoppingcar
-- ----------------------------
INSERT INTO `shoppingcar` VALUES ('1', 'T恤衫', 'http://www.cxysl.cn/images/WX_img/f/n01.jpg', '88.88', '2', '2019年最新版终结者键盘上架', '1');
INSERT INTO `shoppingcar` VALUES ('1', 'T恤衫', 'http://www.cxysl.cn/images/WX_img/f/n01.jpg', '88.88', '1', '2019年最新版终结者键盘上架', '44');
INSERT INTO `shoppingcar` VALUES ('8', '鼠标', 'http://www.cxysl.cn/images/WX_img/sb.jpg', '100.5', '1', '犹如肌肤般光滑，手感极好', '45');
INSERT INTO `shoppingcar` VALUES ('1', '裤子', 'https://www.cxysl.cn/images/FZ/tb_kz01.jpg', '88.88', '1', '特步2019年最潮款女裤', '2');
INSERT INTO `shoppingcar` VALUES ('16', '运动裤', 'https://www.cxysl.cn/images/FZ/ad_kz02.jpg', '100.5', '1', '阿迪达斯2020年最新男士运动裤', '2');
INSERT INTO `shoppingcar` VALUES ('21', '球鞋', 'https://www.cxysl.cn/images/FZ/ad_xz03.jpg', '89.5', '2', '阿迪达斯2020最潮球鞋', '2');
INSERT INTO `shoppingcar` VALUES ('28', '外套', 'https://www.cxysl.cn/images/FZ/ln_sy01.jpg', '100.5', '1', '李宁2020年最新外套', '2');
INSERT INTO `shoppingcar` VALUES ('7', '运动装', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', '89.5', '2', '特步2020最新运动装', '2');
INSERT INTO `shoppingcar` VALUES ('7', '运动装', 'https://www.cxysl.cn/images/FZ/tb_yd01.jpg', '89.5', '1', '特步2020最新运动装', '47');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uname` varchar(100) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='后台管理员账号密码';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '463572181@qq.com', '123');
INSERT INTO `t_user` VALUES ('2', '609064894@qq.com', '111');
INSERT INTO `t_user` VALUES ('3', '123@qq.com', '123');
INSERT INTO `t_user` VALUES ('32', '111@qq.com', '111');
