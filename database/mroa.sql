-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: mroa
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_userinfo`
--

DROP TABLE IF EXISTS `base_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_userinfo` (
  `base_id` varchar(64) NOT NULL,
  `base_name` varchar(10) DEFAULT NULL,
  `base_sex` char(10) DEFAULT NULL,
  `base_age` int(11) DEFAULT NULL,
  `base_post_count` int(11) DEFAULT NULL,
  `base_reply_count` int(11) DEFAULT NULL,
  `base_photo` varchar(255) DEFAULT NULL,
  `base_id_card` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`base_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_userinfo`
--

LOCK TABLES `base_userinfo` WRITE;
/*!40000 ALTER TABLE `base_userinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memo`
--

DROP TABLE IF EXISTS `memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memo` (
  `memo_id` varchar(64) NOT NULL,
  `memo_mood_index` tinyint(11) NOT NULL COMMENT '心情指数',
  `memo_stress_index` tinyint(11) NOT NULL COMMENT '压力指数',
  `memo_title` varchar(80) NOT NULL,
  `memo_content` text NOT NULL,
  `memo_year` char(4) NOT NULL,
  `memo_month` char(2) NOT NULL,
  `memo_day` char(2) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`memo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memo`
--

LOCK TABLES `memo` WRITE;
/*!40000 ALTER TABLE `memo` DISABLE KEYS */;
INSERT INTO `memo` VALUES ('0f615a5b-bce0-4d94-ab84-4f7edc893865',2,3,'顶顶顶','vvvv','2016','8','9','admin'),('2e79e22e-8f11-492c-92d6-1c66105d8dd0',4,2,'心情','测试','2016','9','2','admin1'),('34c1cc30-1923-489c-a113-84f6d365fc3d',1,1,'101050501','bmbb','2016','8','16','admin1'),('3bfae433-e37c-4497-8615-ed261568b19d',1,1,'','打算发达所发生的范德萨发生的','2016','8','10','admin1'),('869c84b0-a580-4b29-a886-56c4a16ec82b',1,1,'125102102','0020202','2016','8','4','admin1'),('87839d33-007c-4cef-92e5-340021f462c2',3,3,'标题党','标题党','2016','9','26','admin1'),('8c4d1f09-0489-46ac-83b8-ef3938b24f8b',1,1,'备忘录','另','2016','12','8','admin1'),('a164e12f-a26d-4a83-804b-dff8d1fc9502',1,1,'ss','dfds','2016','12','8','admin'),('ad6d0a11-01ca-4ecc-a474-a9f386996227',3,2,'长城长','vvvvvvv水水水水水','2016','8','10','admin'),('b74cb7e2-149b-4dad-b125-7f04e8eb4911',3,2,'收拾收拾','常常常常','2016','9','24','admin1'),('c24128eb-93ec-42f9-a228-93432d99e13c',3,4,'标题','内容','2016','9','25','admin1'),('cbb8835b-da6d-4aca-8b91-293b7f49a601',2,4,'从机场究竟是','点击打开的进口量厂家可是我','2016','8','3','admin1'),('d58c4b54-e2ed-41e2-b1c7-43dca54ae161',1,1,'测试Admin','啦啦啦德玛西亚','2016','9','19','admin1'),('dea2a0ce-f6b1-424f-a5ed-bee066782ddf',1,1,'是发的撒发的撒发达省份','但是发的撒发的撒发的撒发大水发达省份打算发达省份   ','2016','8','20','admin1'),('e6449365-7382-49bb-aed8-4591f3a3eb11',1,1,'收拾收拾收拾收拾','常常常常常常常常常常\r\n<br>\r\n常常常常常常常常常常\r\n<br>\r\n常常常常常常常常常常','2016','8','8','admin1'),('ebaa27a5-4584-482c-899b-40110b4de16d',2,3,'某某某获得一枚金牌','大家的健康的肯定就看到了大家','2016','8','2','admin1'),('f96aeed8-f012-4dfd-9e23-958b6a3d8147',2,3,'xxxxxxx','<p style=\'color:blue\' >成绩查询经常</p>\r\n\r\n<p style=\'color:red\' >成绩查询经常</p>\r\n\r\n<p style=\'color:red\' >成绩查询经常</p>\r\n\r\n<p style=\'color:red\' >成绩查询经常</p>\r\n','2016','8','1','admin1'),('f97131da-c8ff-40c1-a378-95a576bb92ec',5,5,'打算发达省份','da\'s\'f\'da\'s\'f\'s\'f\'da\'s\'f\'s\'fa\'s\'f\'da\'s\'f','2016','8','11','admin1');
/*!40000 ALTER TABLE `memo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_work`
--

DROP TABLE IF EXISTS `plan_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_work` (
  `plan_id` varchar(64) NOT NULL,
  `plan_content` text NOT NULL,
  `plan_title` varchar(80) NOT NULL,
  `plan_creator` varchar(64) NOT NULL,
  `plan_to` varchar(64) NOT NULL,
  `plan_createtime` datetime NOT NULL,
  `plan_updatetime` datetime NOT NULL,
  `plan_flag` char(1) NOT NULL COMMENT '审批状态',
  `plan_updater` varchar(64) DEFAULT NULL,
  `plan_priority` int(11) DEFAULT 1,
  `plan_complexity` int(11) DEFAULT 1,
  `plan_start` datetime NOT NULL,
  `plan_end` datetime NOT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='任务计划表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_work`
--

LOCK TABLES `plan_work` WRITE;
/*!40000 ALTER TABLE `plan_work` DISABLE KEYS */;
INSERT INTO `plan_work` VALUES ('1c1eeff0-b761-4ffa-b271-3db7afb757ef','第一周工作计划','明日科技周计划','admin1','xiaoke','2016-12-08 10:31:47','2016-12-08 10:32:11','2','xiaoke',5,5,'2016-12-08 10:31:25','2016-12-08 10:31:25'),('49afb9c6-de46-43e1-b10c-6027630ba4b9','A计划，申报。修改问卷调查的数据库','任务计划申请','admin1','admin1','2016-09-26 08:51:42','2016-12-07 16:12:02','2','刘娜',3,2,'2016-09-26 08:50:31','2016-09-26 08:50:31'),('7d1b3fd7-6ea2-45ce-ae8e-83cc383e8e18','写文档','我的工作计划','admin1','mr','2016-12-08 11:00:02','2016-12-08 11:00:02','1','明日科技',1,1,'2016-12-08 10:59:22','2016-12-10 10:59:22'),('7ebd4223-b10e-4f93-8820-68b8c49598e0','统计部门人员工作完成情况','统计工作完成情况','admin1','admin1','2016-12-08 10:56:34','2016-12-08 10:56:34','1','明日科技',1,1,'2016-12-08 10:55:40','2016-12-10 10:55:40');
/*!40000 ALTER TABLE `plan_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_login`
--

DROP TABLE IF EXISTS `sys_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wxname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login`
--

LOCK TABLES `sys_login` WRITE;
/*!40000 ALTER TABLE `sys_login` DISABLE KEYS */;
INSERT INTO `sys_login` VALUES (1,'mr','fdb390e945559e74475ed8c8bbb48ca5','80303857@qq.com','明日科技'),(4,'admin1','21232f297a57a5a743894a0e4a801fc3','80303857@qq.com','刘娜'),(5,'admin2','21232f297a57a5a743894a0e4a801fc3','80303857@qq.com','明日'),(6,'admin3','21232f297a57a5a743894a0e4a801fc3','80303857@qq.com','迪迪'),(26,'请叫我大王','e10adc3949ba59abbe56e057f20f883e','893808512@qq.com','请叫我大王'),(27,'xiaoke','e068ef92aa755ecd329e67489e21773c','xiaoke@163.com','xiaoke');
/*!40000 ALTER TABLE `sys_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_login_role`
--

DROP TABLE IF EXISTS `sys_login_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户角色对照表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_role`
--

LOCK TABLES `sys_login_role` WRITE;
/*!40000 ALTER TABLE `sys_login_role` DISABLE KEYS */;
INSERT INTO `sys_login_role` VALUES (1,4,1,'admin1'),(2,21,2,'admin2'),(3,1,3,'mr'),(4,23,5,'admin3'),(5,24,3,'aaxxss'),(6,25,3,'aa789456'),(7,26,3,'请叫我大王'),(8,27,3,'xiaoke');
/*!40000 ALTER TABLE `sys_login_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(20) NOT NULL,
  `permission_menu_name` varchar(20) NOT NULL,
  `permission_menu_pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `permission_name_UNIQUE` (`permission_name`),
  UNIQUE KEY `permission_menu_name_UNIQUE` (`permission_menu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'xinwgl','新闻管理1',0),(2,'yonggxx','用工信息',0),(3,'zhaopxx','招聘信息',0),(4,'qiywh','企业文化',0),(6,'zengj','增加',1),(7,'maic','卖场',0),(8,'quanxian','权限设置',NULL);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(20) NOT NULL,
  `role_pid` int(11) NOT NULL,
  `role_group` varchar(10) DEFAULT NULL,
  `role_groupname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_desc_UNIQUE` (`role_desc`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'kfbzg','开发部主管',0,'kaifabu','开发部'),(2,'cpbzg','产品部主管',0,'chanpinbu','产品部'),(3,'zhbzg','综合部主管',0,'zonghebu','综合部'),(4,'role','权限分配',-1,'-1','-1'),(5,'bjbzg','编辑部主管',0,'bianjibu','编辑部'),(6,'kfbzy','开发部组员',1,'kaifabu','开发部'),(7,'cpbzy','产品部组员',2,'chanpinbu','产品部'),(8,'zhbzy','综合部组员',3,'zonghebu','综合部'),(9,'bjbzy','编辑部组员',4,'bianjibu','编辑部');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='角色，权限对照表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (13,1,1,'admin'),(14,1,6,'admin'),(15,1,2,'admin'),(16,1,3,'admin'),(17,1,4,'admin'),(18,1,7,'admin');
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 21:53:17
