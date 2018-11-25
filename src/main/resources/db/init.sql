-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: GJA
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `Faculty`
--

DROP TABLE IF EXISTS `Faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty` (
  `id_faculty` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id_faculty`),
  UNIQUE KEY `Faculty_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty`
--

/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT INTO `Faculty` VALUES (7,'FEKT');
INSERT INTO `Faculty` VALUES (8,'FIT');
INSERT INTO `Faculty` VALUES (10,'FSI');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;

--
-- Table structure for table `Faculty_Subject`
--

DROP TABLE IF EXISTS `Faculty_Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty_Subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_subject` int(11) NOT NULL,
  `fk_faculty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Faculty_Subject_Faculty_id_fk` (`fk_faculty`),
  KEY `Faculty_Subject_Subject_id_fk` (`fk_subject`),
  CONSTRAINT `Faculty_Subject_Faculty_id_fk` FOREIGN KEY (`fk_faculty`) REFERENCES `Faculty` (`id_faculty`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Faculty_Subject_Subject_id_fk` FOREIGN KEY (`fk_subject`) REFERENCES `Subject` (`id_subject`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty_Subject`
--

/*!40000 ALTER TABLE `Faculty_Subject` DISABLE KEYS */;
INSERT INTO `Faculty_Subject` VALUES (34,20,7);
INSERT INTO `Faculty_Subject` VALUES (40,21,8);
INSERT INTO `Faculty_Subject` VALUES (41,22,8);
INSERT INTO `Faculty_Subject` VALUES (48,23,10);
INSERT INTO `Faculty_Subject` VALUES (49,24,10);
INSERT INTO `Faculty_Subject` VALUES (50,25,10);
INSERT INTO `Faculty_Subject` VALUES (51,26,10);
/*!40000 ALTER TABLE `Faculty_Subject` ENABLE KEYS */;

--
-- Table structure for table `ISIC`
--

DROP TABLE IF EXISTS `ISIC`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ISIC` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isic_number` varchar(16) DEFAULT NULL,
  `creation` date DEFAULT NULL,
  `faculty` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISIC_isic_number_uindex` (`isic_number`),
  CONSTRAINT `ISIC_Student_id_fk` FOREIGN KEY (`id`) REFERENCES `Student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ISIC`
--

/*!40000 ALTER TABLE `ISIC` DISABLE KEYS */;
INSERT INTO `ISIC` VALUES (1,'isicnumber','2018-11-19','FIT');
INSERT INTO `ISIC` VALUES (7,'superisic','2018-11-20','FSI');
INSERT INTO `ISIC` VALUES (9,'superisic1','2018-11-20','FP');
INSERT INTO `ISIC` VALUES (10,'superisicstring','2018-11-20','FP');
INSERT INTO `ISIC` VALUES (19,'isicdalsi','2018-11-20','FIT');
INSERT INTO `ISIC` VALUES (20,'isicdalsi1','2018-11-20','FIT');
INSERT INTO `ISIC` VALUES (21,'isicvlkto','2018-11-20','FIT');
/*!40000 ALTER TABLE `ISIC` ENABLE KEYS */;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `login` varchar(8) NOT NULL,
  `signed` date NOT NULL,
  `isic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Student_login_uindex` (`login`),
  KEY `Student_ISIC_id_fk` (`isic_id`),
  CONSTRAINT `Student_ISIC_id_fk` FOREIGN KEY (`isic_id`) REFERENCES `ISIC` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'andrej17','xkloco00','2018-11-17',1);
INSERT INTO `Student` VALUES (2,'tomas','vlkto00','2018-11-17',21);
INSERT INTO `Student` VALUES (7,'romanko','xroma00','2018-11-17',NULL);
INSERT INTO `Student` VALUES (9,'neni9','xdalsi','2018-11-18',19);
INSERT INTO `Student` VALUES (10,'adam09','xadam01','2018-11-18',7);
INSERT INTO `Student` VALUES (12,'MenoStudenta4269','xmeno','2018-11-18',9);
INSERT INTO `Student` VALUES (15,'MenoStudenta','xmeno02','2018-11-18',NULL);
INSERT INTO `Student` VALUES (19,'MenoStudenta','rand','2018-11-18',10);
INSERT INTO `Student` VALUES (20,'MenoStudenta','randd','2018-11-18',20);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject` (
  `id_subject` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `created` date NOT NULL,
  PRIMARY KEY (`id_subject`),
  UNIQUE KEY `Subject_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES (20,'MAT','2018-11-20');
INSERT INTO `Subject` VALUES (21,'TIN','2018-11-21');
INSERT INTO `Subject` VALUES (22,'GJA','2018-11-21');
INSERT INTO `Subject` VALUES (23,'FS1','2018-11-23');
INSERT INTO `Subject` VALUES (24,'FS2','2018-11-23');
INSERT INTO `Subject` VALUES (25,'FS3','2018-11-23');
INSERT INTO `Subject` VALUES (26,'FS4','2018-11-23');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-24 17:31:22
