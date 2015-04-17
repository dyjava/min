/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.3-m13 : Database - member
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`member` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `member`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardid` varchar(20) DEFAULT NULL COMMENT '卡号',
  `name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `person` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `type` varchar(20) DEFAULT NULL COMMENT '行业类别',
  `ctime` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `cmoney` double DEFAULT NULL COMMENT '注册资本',
  `ctype` varchar(20) DEFAULT NULL COMMENT '企业性质',
  `cage` int(11) DEFAULT NULL COMMENT '经营年限',
  `used` varchar(50) DEFAULT NULL COMMENT '业务范围',
  `area` varchar(20) DEFAULT NULL COMMENT '业务区域',
  `web` varchar(200) DEFAULT NULL COMMENT '公司网站',
  `tel` varchar(20) DEFAULT NULL COMMENT '公司电话',
  `cz` varchar(20) DEFAULT NULL COMMENT '传真',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `weixin` varchar(20) DEFAULT NULL COMMENT '微信',
  `num` int(11) DEFAULT NULL COMMENT '人员工数',
  `others` varchar(500) DEFAULT NULL COMMENT '其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`id`,`cardid`,`name`,`address`,`person`,`type`,`ctime`,`cmoney`,`ctype`,`cage`,`used`,`area`,`web`,`tel`,`cz`,`email`,`weixin`,`num`,`others`) values (1,'1','1','1','1','11','1',1,'1',11,'1111','ws','g','g','gg','gf','ff',0,'dd');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
