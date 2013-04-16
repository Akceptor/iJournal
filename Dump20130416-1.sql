CREATE DATABASE  IF NOT EXISTS `ijournal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ijournal`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: ijournal
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `activity_type` int(11) NOT NULL,
  `activity_name` varchar(45) NOT NULL,
  PRIMARY KEY (`activity_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (1,'Лекція'),(2,'Лабораторна'),(3,'Практична');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates`
--

DROP TABLE IF EXISTS `dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dates` (
  `date_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`date_id`)
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates`
--

LOCK TABLES `dates` WRITE;
/*!40000 ALTER TABLE `dates` DISABLE KEYS */;
INSERT INTO `dates` VALUES (1,'2012-09-01'),(2,'2012-09-02'),(3,'2012-09-03'),(4,'2012-09-04'),(5,'2012-09-05'),(6,'2012-09-06'),(7,'2012-09-07'),(8,'2012-09-08'),(9,'2012-09-09'),(10,'2012-09-10'),(11,'2012-09-11'),(12,'2012-09-12'),(13,'2012-09-13'),(14,'2012-09-14'),(15,'2012-09-15'),(16,'2012-09-16'),(17,'2012-09-17'),(18,'2012-09-18'),(19,'2012-09-19'),(20,'2012-09-20'),(21,'2012-09-21'),(22,'2012-09-22'),(23,'2012-09-23'),(24,'2012-09-24'),(25,'2012-09-25'),(26,'2012-09-26'),(27,'2012-09-27'),(28,'2012-09-28'),(29,'2012-09-29'),(30,'2012-09-30'),(31,'2012-10-01'),(32,'2012-10-02'),(33,'2012-10-03'),(34,'2012-10-04'),(35,'2012-10-05'),(36,'2012-10-06'),(37,'2012-10-07'),(38,'2012-10-08'),(39,'2012-10-09'),(40,'2012-10-10'),(41,'2012-10-11'),(42,'2012-10-12'),(43,'2012-10-13'),(44,'2012-10-14'),(45,'2012-10-15'),(46,'2012-10-16'),(47,'2012-10-17'),(48,'2012-10-18'),(49,'2012-10-19'),(50,'2012-10-20'),(51,'2012-10-21'),(52,'2012-10-22'),(53,'2012-10-23'),(54,'2012-10-24'),(55,'2012-10-25'),(56,'2012-10-26'),(57,'2012-10-27'),(58,'2012-10-28'),(59,'2012-10-29'),(60,'2012-10-30'),(61,'2012-10-31'),(62,'2012-11-01'),(63,'2012-11-02'),(64,'2012-11-03'),(65,'2012-11-04'),(66,'2012-11-05'),(67,'2012-11-06'),(68,'2012-11-07'),(69,'2012-11-08'),(70,'2012-11-09'),(71,'2012-11-10'),(72,'2012-11-11'),(73,'2012-11-12'),(74,'2012-11-13'),(75,'2012-11-14'),(76,'2012-11-15'),(77,'2012-11-16'),(78,'2012-11-17'),(79,'2012-11-18'),(80,'2012-11-19'),(81,'2012-11-20'),(82,'2012-11-21'),(83,'2012-11-22'),(84,'2012-11-23'),(85,'2012-11-24'),(86,'2012-11-25'),(87,'2012-11-26'),(88,'2012-11-27'),(89,'2012-11-28'),(90,'2012-11-29'),(91,'2012-11-30'),(92,'2012-12-01'),(93,'2012-12-02'),(94,'2012-12-03'),(95,'2012-12-04'),(96,'2012-12-05'),(97,'2012-12-06'),(98,'2012-12-07'),(99,'2012-12-08'),(100,'2012-12-09'),(101,'2012-12-10'),(102,'2012-12-11'),(103,'2012-12-12'),(104,'2012-12-13'),(105,'2012-12-14'),(106,'2012-12-15'),(107,'2012-12-16'),(108,'2012-12-17'),(109,'2012-12-18'),(110,'2012-12-19'),(111,'2012-12-20'),(112,'2012-12-21'),(113,'2012-12-22'),(114,'2012-12-23'),(115,'2012-12-24'),(116,'2012-12-25'),(117,'2012-12-26'),(118,'2012-12-27'),(119,'2012-12-28'),(120,'2012-12-29'),(121,'2012-12-30'),(122,'2012-12-31'),(123,'2013-01-01'),(124,'2013-01-02'),(125,'2013-01-03'),(126,'2013-01-04'),(127,'2013-01-05'),(128,'2013-01-06'),(129,'2013-01-07'),(130,'2013-01-08'),(131,'2013-01-09'),(132,'2013-01-10'),(133,'2013-01-11'),(134,'2013-01-12'),(135,'2013-01-13'),(136,'2013-01-14'),(137,'2013-01-15'),(138,'2013-01-16'),(139,'2013-01-17'),(140,'2013-01-18'),(141,'2013-01-19'),(142,'2013-01-20'),(143,'2013-01-21'),(144,'2013-01-22'),(145,'2013-01-23'),(146,'2013-01-24'),(147,'2013-01-25'),(148,'2013-01-26'),(149,'2013-01-27'),(150,'2013-01-28'),(151,'2013-01-29'),(152,'2013-01-30'),(153,'2013-01-31'),(154,'2013-02-01'),(155,'2013-02-02'),(156,'2013-02-03'),(157,'2013-02-04'),(158,'2013-02-05'),(159,'2013-02-06'),(160,'2013-02-07'),(161,'2013-02-08'),(162,'2013-02-09'),(163,'2013-02-10'),(164,'2013-02-11'),(165,'2013-02-12'),(166,'2013-02-13'),(167,'2013-02-14'),(168,'2013-02-15'),(169,'2013-02-16'),(170,'2013-02-17'),(171,'2013-02-18'),(172,'2013-02-19'),(173,'2013-02-20'),(174,'2013-02-21'),(175,'2013-02-22'),(176,'2013-02-23'),(177,'2013-02-24'),(178,'2013-02-25'),(179,'2013-02-26'),(180,'2013-02-27'),(181,'2013-02-28'),(182,'2013-03-01'),(183,'2013-03-02'),(184,'2013-03-03'),(185,'2013-03-04'),(186,'2013-03-05'),(187,'2013-03-06'),(188,'2013-03-07'),(189,'2013-03-08'),(190,'2013-03-09'),(191,'2013-03-10'),(192,'2013-03-11'),(193,'2013-03-12'),(194,'2013-03-13'),(195,'2013-03-14'),(196,'2013-03-15'),(197,'2013-03-16'),(198,'2013-03-17'),(199,'2013-03-18'),(200,'2013-03-19'),(201,'2013-03-20'),(202,'2013-03-21'),(203,'2013-03-22'),(204,'2013-03-23'),(205,'2013-03-24'),(206,'2013-03-25'),(207,'2013-03-26'),(208,'2013-03-27'),(209,'2013-03-28'),(210,'2013-03-29'),(211,'2013-03-30'),(212,'2013-03-31'),(213,'2013-04-01'),(214,'2013-04-02'),(215,'2013-04-03'),(216,'2013-04-04'),(217,'2013-04-05'),(218,'2013-04-06'),(219,'2013-04-07'),(220,'2013-04-08'),(221,'2013-04-09'),(222,'2013-04-10'),(223,'2013-04-11'),(224,'2013-04-12'),(225,'2013-04-13'),(226,'2013-04-14'),(227,'2013-04-15'),(228,'2013-04-16'),(229,'2013-04-17'),(230,'2013-04-18'),(231,'2013-04-19'),(232,'2013-04-20'),(233,'2013-04-21'),(234,'2013-04-22'),(235,'2013-04-23'),(236,'2013-04-24'),(237,'2013-04-25'),(238,'2013-04-26'),(239,'2013-04-27'),(240,'2013-04-28'),(241,'2013-04-29'),(242,'2013-04-30'),(243,'2013-05-01'),(244,'2013-05-02'),(245,'2013-05-03'),(246,'2013-05-04'),(247,'2013-05-05'),(248,'2013-05-06'),(249,'2013-05-07'),(250,'2013-05-08'),(251,'2013-05-09'),(252,'2013-05-10'),(253,'2013-05-11'),(254,'2013-05-12'),(255,'2013-05-13'),(256,'2013-05-14'),(257,'2013-05-15'),(258,'2013-05-16'),(259,'2013-05-17'),(260,'2013-05-18'),(261,'2013-05-19'),(262,'2013-05-20'),(263,'2013-05-21'),(264,'2013-05-22'),(265,'2013-05-23'),(266,'2013-05-24'),(267,'2013-05-25'),(268,'2013-05-26'),(269,'2013-05-27'),(270,'2013-05-28'),(271,'2013-05-29'),(272,'2013-05-30'),(273,'2013-05-31');
/*!40000 ALTER TABLE `dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name_UNIQUE` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'MVT-01'),(2,'MVT-02'),(3,'MVT-03'),(4,'MVT-04'),(100,'Pink Floyd'),(0,'Без групи');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL DEFAULT '0',
  `subject_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL DEFAULT '0',
  `absense` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lesson_id`),
  UNIQUE KEY `lesson_id_UNIQUE` (`lesson_id`),
  KEY `fk_student_id_idx` (`subject_id`),
  KEY `fk_subject_id_idx` (`subject_id`),
  KEY `fk_student_id` (`student_id`),
  KEY `fk_subject_id_idx1` (`subject_id`),
  CONSTRAINT `fk_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,1,1,3,'1'),(2,1,1,4,'0'),(3,1,1,0,'1'),(4,1,1,5,'1'),(5,1,1,2,'0'),(6,1,1,0,'1'),(7,2,1,3,'0'),(8,2,1,3,'0'),(9,2,1,3,'0'),(10,2,1,3,'0'),(11,2,1,3,'0'),(12,2,1,0,'1'),(13,3,1,3,'2'),(14,3,1,0,'0'),(15,3,1,0,'0'),(16,3,1,0,'0'),(17,3,1,0,'0'),(18,3,1,0,'1'),(19,4,1,1,'0'),(20,4,1,0,'0'),(21,4,1,0,'0'),(22,4,1,0,'0'),(23,4,1,0,'0'),(24,4,1,5,'0'),(25,5,1,3,'0'),(26,5,1,0,'0'),(27,5,1,5,'0'),(28,5,1,0,'0'),(29,5,1,0,'0'),(30,5,1,5,'0'),(31,6,1,5,'1'),(32,6,1,0,'1'),(33,6,1,0,'0'),(34,6,1,0,'0'),(35,6,1,0,'0'),(36,6,1,0,'1'),(37,1,2,0,'0'),(38,1,2,1,'0'),(39,1,2,0,'0'),(40,1,2,0,'0'),(41,1,2,0,'0'),(42,1,2,0,'0'),(43,2,2,0,'0'),(44,2,2,0,'0'),(45,2,2,0,'0'),(46,2,2,0,'0'),(47,2,2,3,'0'),(48,2,2,0,'1'),(49,3,2,0,'0'),(50,3,2,0,'0'),(51,3,2,2,'0'),(52,3,2,0,'0'),(53,3,2,0,'0'),(54,3,2,0,'0'),(55,4,2,0,'0'),(56,4,2,0,'0'),(57,4,2,0,'0'),(58,4,2,0,'0'),(59,4,2,0,'0'),(60,4,2,0,'0'),(61,5,2,1,'0'),(62,5,2,0,'0'),(63,5,2,5,'0'),(64,5,2,0,'0'),(65,5,2,0,'0'),(66,5,2,5,'0'),(67,6,2,0,'2'),(68,6,2,0,'0'),(69,6,2,0,'0'),(70,6,2,0,'0'),(71,6,2,0,'0'),(72,6,2,4,'0');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessons_and_dates`
--

DROP TABLE IF EXISTS `lessons_and_dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lessons_and_dates` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_id` int(11) NOT NULL,
  PRIMARY KEY (`lesson_id`,`date_id`),
  KEY `fk_lesson_dates_idx` (`date_id`),
  CONSTRAINT `fk_lesson_dates` FOREIGN KEY (`date_id`) REFERENCES `dates` (`date_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessons_and_dates`
--

LOCK TABLES `lessons_and_dates` WRITE;
/*!40000 ALTER TABLE `lessons_and_dates` DISABLE KEYS */;
INSERT INTO `lessons_and_dates` VALUES (1,1),(7,1),(13,1),(19,1),(25,1),(31,1),(2,2),(8,2),(14,2),(20,2),(26,2),(32,2),(3,3),(9,3),(15,3),(21,3),(27,3),(33,3),(4,4),(10,4),(16,4),(22,4),(28,4),(34,4),(5,5),(11,5),(17,5),(23,5),(29,5),(35,5),(6,6),(12,6),(18,6),(24,6),(30,6),(36,6),(37,7),(43,7),(49,7),(55,7),(61,7),(38,8),(44,8),(50,8),(56,8),(62,8),(39,9),(45,9),(51,9),(57,9),(63,9),(40,10),(46,10),(52,10),(58,10),(64,10),(41,11),(47,11),(53,11),(59,11),(65,11),(42,12),(48,12),(54,12),(60,12),(66,12),(67,13),(68,14),(69,15),(70,16),(71,17),(72,18);
/*!40000 ALTER TABLE `lessons_and_dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_nr` varchar(45) NOT NULL,
  `student_fio` varchar(45) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`user_id`),
  UNIQUE KEY `book_nr_UNIQUE` (`book_nr`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_group_id_idx` (`group_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_student_user_id_idx` (`user_id`),
  CONSTRAINT `fk_student_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=100523 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'mvt-00001','Ivanov I.I.',1,1),(2,'mvt-00002','Petrov P.P.',1,2),(3,'mvt-00003','Ivanov I.S.',1,3),(4,'mvt-00012','Sidirov S.S.',2,4),(5,'mvt-00021','Kozloff K.Z.',2,5),(6,'mvt-00022','Jonson J.S.',1,6),(100500,'Pink-001','Девід Ґілмор',100,8),(100519,'100500a','Sample Student',100,100577);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(120) NOT NULL,
  `teacher_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `subject_id_UNIQUE` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Хімія',2),(2,'Фізика',2),(3,'Вишка',2),(4,'Фізкультура',4),(5,'Метеорологія',4),(6,'Філософія',4),(8,'Прикладний пофігізм (лек)',2),(9,'Прикладний пофігізм (практ)',2),(10,'Копання траншей',0);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `teacher_fio` varchar(150) NOT NULL,
  PRIMARY KEY (`teacher_id`,`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_t_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (2,2,'Norris'),(4,100573,'Test Teacher'),(7,100578,'Долішня Н.Б.');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
  `user_role_id` int(11) NOT NULL DEFAULT '0',
  `authority` varchar(45) NOT NULL DEFAULT 'NONE',
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `user_role_id_UNIQUE` (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (0,'NONE'),(1,'ROLE_STUDENT'),(2,'ROLE_USER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `USER_ID_UNIQUE` (`USER_ID`),
  KEY `fk_users_idx` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100582 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mvt-00001','098f6bcd4621d373cade4e832627b4f6',1),(2,'Norris','098f6bcd4621d373cade4e832627b4f6',1),(3,'mvt-00003','098f6bcd4621d373cade4e832627b4f6',1),(4,'mvt-00004','098f6bcd4621d373cade4e832627b4f6',1),(5,'mvt-00005','098f6bcd4621d373cade4e832627b4f6',1),(6,'mvt-00006','098f6bcd4621d373cade4e832627b4f6',1),(8,'mvt-00008','098f6bcd4621d373cade4e832627b4f6',1),(100500,'admin','21232f297a57a5a743894a0e4a801fc3',1),(100570,'akceptor','c62c7e9bfc53d8c7067952414507849c',1),(100572,'mvtz-110001','daef9f5e46ffc1283598fc9e56fd509e',1),(100573,'test','098f6bcd4621d373cade4e832627b4f6',1),(100577,'student','098f6bcd4621d373cade4e832627b4f6',1),(100578,'dolishnya','098f6bcd4621d373cade4e832627b4f6',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_and_roles`
--

DROP TABLE IF EXISTS `users_and_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_and_roles` (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ROLE_ID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  KEY `fk_user_id_idx` (`USER_ID`),
  KEY `fk_role_id_idx` (`USER_ROLE_ID`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`USER_ROLE_ID`) REFERENCES `userroles` (`user_role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=100582 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_and_roles`
--

LOCK TABLES `users_and_roles` WRITE;
/*!40000 ALTER TABLE `users_and_roles` DISABLE KEYS */;
INSERT INTO `users_and_roles` VALUES (1,1),(3,1),(4,1),(5,1),(6,1),(8,1),(100572,1),(100577,1),(2,2),(100573,2),(100578,2),(100500,3),(100570,3);
/*!40000 ALTER TABLE `users_and_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-16 15:25:46
