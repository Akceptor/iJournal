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
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'MVT-01'),(2,'MVT-02'),(3,'MVT-03'),(4,'MVT-04'),(100,'Pink Floyd');
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
  `teacher_id` int(11) NOT NULL DEFAULT '0',
  `subject_id` int(11) NOT NULL,
  `lesson_date` date DEFAULT NULL,
  `mark` int(11) NOT NULL DEFAULT '0',
  `absense` varchar(1) NOT NULL DEFAULT '0',
  `lesson_number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lesson_id`),
  UNIQUE KEY `lesson_id_UNIQUE` (`lesson_id`),
  KEY `fk_student_id_idx` (`subject_id`),
  KEY `fk_subject_id_idx` (`subject_id`),
  KEY `fk_teacher_id_idx` (`teacher_id`),
  KEY `fk_student_id` (`student_id`),
  KEY `fk_subject_id_idx1` (`subject_id`),
  KEY `fk_teacher_id_idx1` (`teacher_id`),
  CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,1,1,1,'2013-02-01',1,'1',0),(2,1,1,1,'2013-02-08',2,'0',0),(3,1,1,1,'2013-02-15',0,'1',0),(4,1,1,1,'2013-02-22',2,'2',0),(5,1,1,1,'2013-03-01',2,'0',0),(6,1,1,1,'2013-03-08',0,'0',0),(7,2,1,1,'2013-02-01',0,'0',0),(8,2,1,1,'2013-02-08',0,'0',0),(9,2,1,1,'2013-02-15',0,'0',0),(10,2,1,1,'2013-02-22',0,'0',0),(11,2,1,1,'2013-03-01',0,'0',0),(12,2,1,1,'2013-03-08',0,'0',0),(13,3,1,1,'2013-02-01',4,'0',0),(14,3,1,1,'2013-02-08',0,'0',0),(15,3,1,1,'2013-02-15',0,'0',0),(16,3,1,1,'2013-02-22',0,'0',0),(17,3,1,1,'2013-03-01',0,'0',0),(18,3,1,1,'2013-03-08',0,'0',0),(19,4,1,1,'2013-02-01',1,'0',0),(20,4,1,1,'2013-02-08',0,'0',0),(21,4,1,1,'2013-02-15',0,'0',0),(22,4,1,1,'2013-02-22',0,'0',0),(23,4,1,1,'2013-03-01',0,'0',0),(24,4,1,1,'2013-03-08',5,'0',0),(25,5,1,1,'2013-02-01',1,'0',0),(26,5,1,1,'2013-02-08',0,'0',0),(27,5,1,1,'2013-02-15',5,'0',0),(28,5,1,1,'2013-02-22',0,'0',0),(29,5,1,1,'2013-03-01',0,'0',0),(30,5,1,1,'2013-03-08',5,'0',0),(31,6,1,1,'2013-02-01',0,'2',0),(32,6,1,1,'2013-02-08',0,'0',0),(33,6,1,1,'2013-02-15',0,'0',0),(34,6,1,1,'2013-02-22',0,'0',0),(35,6,1,1,'2013-03-01',0,'0',0),(36,6,1,1,'2013-03-08',0,'0',0),(37,1,1,2,'2013-02-02',0,'0',0),(38,1,1,2,'2013-02-09',0,'0',0),(39,1,1,2,'2013-02-16',0,'0',0),(40,1,1,2,'2013-02-23',0,'0',0),(41,1,1,2,'2013-03-02',0,'0',0),(42,1,1,2,'2013-03-09',0,'0',0),(43,2,1,2,'2013-02-02',0,'0',0),(44,2,1,2,'2013-02-09',0,'0',0),(45,2,1,2,'2013-02-16',0,'0',0),(46,2,1,2,'2013-02-23',0,'0',0),(47,2,1,2,'2013-03-02',0,'0',0),(48,2,1,2,'2013-03-09',0,'0',0),(49,3,1,2,'2013-02-02',0,'0',0),(50,3,1,2,'2013-02-09',0,'0',0),(51,3,1,2,'2013-02-16',0,'0',0),(52,3,1,2,'2013-02-23',0,'0',0),(53,3,1,2,'2013-03-02',0,'0',0),(54,3,1,2,'2013-03-09',0,'0',0),(55,4,1,2,'2013-02-02',0,'0',0),(56,4,1,2,'2013-02-09',0,'0',0),(57,4,1,2,'2013-02-16',0,'0',0),(58,4,1,2,'2013-02-23',0,'0',0),(59,4,1,2,'2013-03-02',0,'0',0),(60,4,1,2,'2013-03-09',0,'0',0);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
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
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `book_nr_UNIQUE` (`book_nr`),
  KEY `fk_group_id_idx` (`group_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_s_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100503 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'mvt-00001','Ivanov I.I.',1,1),(2,'mvt-00002','Petrov P.P.',1,2),(3,'mvt-00003','Ivanov I.S.',1,3),(4,'mvt-00012','Sidirov S.S.',2,4),(5,'mvt-00021','Kozloff K.Z.',2,5),(6,'mvt-00022','Jonson J.S.',1,6),(7,'Chuch=k','Norris Carlos Ray',3,7),(100500,'Pink-001','Девід Ґілмор',100,NULL),(100501,'Pink-002','Нік Мейсон',100,NULL),(100502,'Pink-003','Річард Райт',100,NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(120) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `activity_type` int(11) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `subject_id_UNIQUE` (`subject_id`),
  KEY `fk_activity_type_idx` (`activity_type`),
  KEY `fk_activity_type_idx1` (`activity_type`),
  CONSTRAINT `fk_activity_type` FOREIGN KEY (`activity_type`) REFERENCES `activities` (`activity_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Хімія',1,0),(2,'Фізика',1,0),(3,'Вишка',1,0),(4,'Фізкультура',2,0),(5,'Метеорологія',2,0),(6,'Філософія',2,0);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacher_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `teacher_fio` varchar(150) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_t_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,100,'Ostapiv'),(2,2,'Norris');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(11) NOT NULL,
  `USER_ID` int(10) NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,'ROLE_STUDENT'),(2,2,'ROLE_STUDENT'),(3,3,'ROLE_STUDENT'),(4,4,'ROLE_STUDENT'),(5,5,'ROLE_STUDENT'),(6,6,'ROLE_STUDENT'),(7,7,'ROLE_STUDENT'),(8,8,'ROLE_STUDENT'),(9,9,'ROLE_STUDENT'),(100,100,'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mvt-00001','098f6bcd4621d373cade4e832627b4f6',1),(2,'Norris','098f6bcd4621d373cade4e832627b4f6',1),(3,'mvt-00003','098f6bcd4621d373cade4e832627b4f6',1),(4,'mvt-00004','098f6bcd4621d373cade4e832627b4f6',1),(5,'mvt-00005','098f6bcd4621d373cade4e832627b4f6',1),(6,'mvt-00006','098f6bcd4621d373cade4e832627b4f6',1),(7,'student','098f6bcd4621d373cade4e832627b4f6',1),(8,'mvt-00008','098f6bcd4621d373cade4e832627b4f6',1),(9,'mvt-00009','098f6bcd4621d373cade4e832627b4f6',1),(100,'test','098f6bcd4621d373cade4e832627b4f6',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-06 11:24:37
