-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: student_db
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `quarterlyassessment`
--

DROP TABLE IF EXISTS `quarterlyassessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quarterlyassessment` (
  `quarterlyAssessment_id` int(11) NOT NULL AUTO_INCREMENT,
  `quarterlyAssessment_title` varchar(45) NOT NULL,
  `quarterlyAssessment_total` float NOT NULL,
  `quarterlyAssessment_subjectid` int(11) NOT NULL,
  PRIMARY KEY (`quarterlyAssessment_id`),
  KEY `FK_QA_SUBJECT_idx` (`quarterlyAssessment_subjectid`),
  CONSTRAINT `FK_QA_SUBJECT` FOREIGN KEY (`quarterlyAssessment_subjectid`) REFERENCES `subject` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarterlyassessment`
--

LOCK TABLES `quarterlyassessment` WRITE;
/*!40000 ALTER TABLE `quarterlyassessment` DISABLE KEYS */;
INSERT INTO `quarterlyassessment` VALUES (1,'1st Periodical Exams',100,1),(2,'Math Quarterly Exams',50,2),(3,'1st Periodical Exams',50,4),(4,'2nd Periodical Exams',50,4);
/*!40000 ALTER TABLE `quarterlyassessment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-21 15:38:05
