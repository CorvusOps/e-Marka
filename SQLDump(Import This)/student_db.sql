-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: student_db
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradept` (
  `gradePT_id` int NOT NULL AUTO_INCREMENT,
  `student_number` int DEFAULT NULL,
  `performanceTasks_id` int DEFAULT NULL,
  `gradePT` float DEFAULT NULL,
  PRIMARY KEY (`gradePT_id`),
  KEY `FK_GRADEPT_STUDENT_idx` (`student_number`),
  KEY `FK_GRADEPT_PT_idx` (`performanceTasks_id`),
  CONSTRAINT `FK_GRADEPT_PT` FOREIGN KEY (`performanceTasks_id`) REFERENCES `performancetasks` (`performanceTasks_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_GRADEPT_STUDENT` FOREIGN KEY (`student_number`) REFERENCES `student` (`student_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradept`
--

LOCK TABLES `gradept` WRITE;
/*!40000 ALTER TABLE `gradept` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradeqa`
--

DROP TABLE IF EXISTS `gradeqa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradeqa` (
  `gradeQA_id` int NOT NULL AUTO_INCREMENT,
  `student_number` int DEFAULT NULL,
  `quarterlyAssessment_id` int DEFAULT NULL,
  `gradeQA` float DEFAULT NULL,
  PRIMARY KEY (`gradeQA_id`),
  KEY `FK_GRADEPT_STUDENT_idx` (`student_number`),
  KEY `FK_GRADEQA_QA_idx` (`quarterlyAssessment_id`),
  CONSTRAINT `FK_GRADEQA_QA` FOREIGN KEY (`quarterlyAssessment_id`) REFERENCES `quarterlyassessment` (`quarterlyAssessment_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_GRADEQA_STUDENT` FOREIGN KEY (`student_number`) REFERENCES `student` (`student_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradeqa`
--

LOCK TABLES `gradeqa` WRITE;
/*!40000 ALTER TABLE `gradeqa` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradeqa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradeww`
--

DROP TABLE IF EXISTS `gradeww`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradeww` (
  `gradeWW_id` int NOT NULL AUTO_INCREMENT,
  `student_number` int DEFAULT NULL,
  `writtenWorks_id` int DEFAULT NULL,
  `gradeWW` float DEFAULT NULL,
  PRIMARY KEY (`gradeWW_id`),
  KEY `FK_GRADEWW_STUDENT_idx` (`student_number`),
  KEY `FK_GRADEWW_WW_idx` (`writtenWorks_id`),
  CONSTRAINT `FK_GRADEWW_STUDENT` FOREIGN KEY (`student_number`) REFERENCES `student` (`student_number`) ON UPDATE CASCADE,
  CONSTRAINT `FK_GRADEWW_WW` FOREIGN KEY (`writtenWorks_id`) REFERENCES `writtenworks` (`writtenWorks_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradeww`
--

LOCK TABLES `gradeww` WRITE;
/*!40000 ALTER TABLE `gradeww` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradeww` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performancetasks`
--

DROP TABLE IF EXISTS `performancetasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performancetasks` (
  `performanceTasks_id` int NOT NULL AUTO_INCREMENT,
  `performanceTasks_title` varchar(45) NOT NULL,
  `performanceTasks_total` float NOT NULL,
  `performanceTasks_subjectid` int NOT NULL,
  PRIMARY KEY (`performanceTasks_id`),
  KEY `FK_PT_SUBJECT_idx` (`performanceTasks_subjectid`),
  CONSTRAINT `FK_PT_SUBJECT` FOREIGN KEY (`performanceTasks_subjectid`) REFERENCES `subject` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performancetasks`
--

LOCK TABLES `performancetasks` WRITE;
/*!40000 ALTER TABLE `performancetasks` DISABLE KEYS */;
INSERT INTO `performancetasks` VALUES (1,'Simulation',100,6),(2,'Queue Project',50,5),(3,'K-Mapping',75,8);
/*!40000 ALTER TABLE `performancetasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quarterlyassessment`
--

DROP TABLE IF EXISTS `quarterlyassessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quarterlyassessment` (
  `quarterlyAssessment_id` int NOT NULL AUTO_INCREMENT,
  `quarterlyAssessment_title` varchar(45) NOT NULL,
  `quarterlyAssessment_total` float NOT NULL,
  `quarterlyAssessment_subjectid` int NOT NULL,
  PRIMARY KEY (`quarterlyAssessment_id`),
  KEY `FK_QA_SUBJECT_idx` (`quarterlyAssessment_subjectid`),
  CONSTRAINT `FK_QA_SUBJECT` FOREIGN KEY (`quarterlyAssessment_subjectid`) REFERENCES `subject` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarterlyassessment`
--

LOCK TABLES `quarterlyassessment` WRITE;
/*!40000 ALTER TABLE `quarterlyassessment` DISABLE KEYS */;
INSERT INTO `quarterlyassessment` VALUES (1,'MIDTERMS',60,5),(2,'ModSim Finals',50,6),(3,'ModSim Final Docu',100,6),(4,'asdM',12,6),(5,'asdasd',123,6),(6,'Queue',100,5);
/*!40000 ALTER TABLE `quarterlyassessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_number` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `section` varchar(50) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`student_number`),
  KEY `FK_STUDENT_SUBJECT_idx` (`subject_id`),
  CONSTRAINT `FK_STUDENT_SUBJECT` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Erin Carlo','Tobias','Valenzuela','Caloocan','BSCS 2-3',5),(2,'Joseph Fernan','Sena','Olivar','Quezon City','BSCS 1-1N',7);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (5,'Data Structures and Algorithms','DSA'),(6,'Modeling and Simulation','MODSIM'),(7,'Object-Oriented Programming','OOP'),(8,'Logic Design and Digital Computer Circuits','LDDCC'),(9,'Discrete Structures 2','DS2'),(11,'CS Free Elective 1','CSFE1');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writtenworks`
--

DROP TABLE IF EXISTS `writtenworks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writtenworks` (
  `writtenWorks_id` int NOT NULL AUTO_INCREMENT,
  `writtenWorks_title` varchar(45) NOT NULL,
  `writtenWorks_total` float NOT NULL,
  `writtenWorks_subjectid` int NOT NULL,
  PRIMARY KEY (`writtenWorks_id`),
  KEY `FK_WW_SUBJECT_idx` (`writtenWorks_subjectid`),
  CONSTRAINT `FK_WW_SUBJECT` FOREIGN KEY (`writtenWorks_subjectid`) REFERENCES `subject` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writtenworks`
--

LOCK TABLES `writtenworks` WRITE;
/*!40000 ALTER TABLE `writtenworks` DISABLE KEYS */;
INSERT INTO `writtenworks` VALUES (1,'Quiz#1 - B-Trees',25,5),(2,'Long Quiz#1',100,7),(3,'Quiz on Lessons 1-3',50,6),(4,'Take-Home Quiz',100,7);
/*!40000 ALTER TABLE `writtenworks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 13:28:25
