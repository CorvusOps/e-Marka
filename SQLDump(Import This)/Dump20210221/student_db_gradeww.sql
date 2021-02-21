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
-- Table structure for table `gradeww`
--

DROP TABLE IF EXISTS `gradeww`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gradeww` (
  `gradeWW_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_number` int(11) DEFAULT NULL,
  `writtenWorks_id` int(11) DEFAULT NULL,
  `gradeWW` float DEFAULT NULL,
  PRIMARY KEY (`gradeWW_id`),
  KEY `FK_GRADEWW_STUDENT_idx` (`student_number`),
  KEY `FK_GRADEWW_WW_idx` (`writtenWorks_id`),
  CONSTRAINT `FK_GRADEWW_STUDENT` FOREIGN KEY (`student_number`) REFERENCES `student` (`student_number`) ON UPDATE CASCADE,
  CONSTRAINT `FK_GRADEWW_WW` FOREIGN KEY (`writtenWorks_id`) REFERENCES `writtenworks` (`writtenworks_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradeww`
--

LOCK TABLES `gradeww` WRITE;
/*!40000 ALTER TABLE `gradeww` DISABLE KEYS */;
INSERT INTO `gradeww` VALUES (1,4,1,0),(2,5,1,0),(4,1,2,20),(5,2,2,15),(6,3,2,0),(7,6,3,0),(8,7,3,0),(10,1,4,13),(11,2,4,0),(12,3,4,0),(13,8,5,45),(14,9,5,0),(16,8,6,34),(17,9,6,0);
/*!40000 ALTER TABLE `gradeww` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-21 15:38:04
