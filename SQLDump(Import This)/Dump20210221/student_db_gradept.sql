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
-- Table structure for table `gradept`
--

DROP TABLE IF EXISTS `gradept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gradept` (
  `gradePT_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_number` int(11) DEFAULT NULL,
  `performanceTasks_id` int(11) DEFAULT NULL,
  `gradePT` float DEFAULT NULL,
  PRIMARY KEY (`gradePT_id`),
  KEY `FK_GRADEPT_STUDENT_idx` (`student_number`),
  KEY `FK_GRADEPT_PT_idx` (`performanceTasks_id`),
  CONSTRAINT `FK_GRADEPT_PT` FOREIGN KEY (`performanceTasks_id`) REFERENCES `performancetasks` (`performancetasks_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_GRADEPT_STUDENT` FOREIGN KEY (`student_number`) REFERENCES `student` (`student_number`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradept`
--

LOCK TABLES `gradept` WRITE;
/*!40000 ALTER TABLE `gradept` DISABLE KEYS */;
INSERT INTO `gradept` VALUES (1,1,1,50),(2,2,1,0),(3,3,1,0),(4,4,2,0),(5,5,2,0),(7,6,3,0),(8,7,3,0),(10,8,4,80),(11,9,4,0),(13,8,5,90),(14,9,5,0);
/*!40000 ALTER TABLE `gradept` ENABLE KEYS */;
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
