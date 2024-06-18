/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80200 (8.2.0)
 Source Host           : localhost:3306
 Source Schema         : StudentSystem

 Target Server Type    : MySQL
 Target Server Version : 80200 (8.2.0)
 File Encoding         : 65001

 Date: 17/06/2024 09:48:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `score` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of grades
-- ----------------------------
BEGIN;
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (1, 'S00001', 'Math', 85.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (2, 'S00001', 'Java', 90.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (3, 'S00001', 'PE', 75.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (4, 'S00002', 'Math', 70.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (5, 'S00002', 'Java', 80.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (6, 'S00002', 'PE', 60.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (7, 'S00003', 'Math', 88.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (8, 'S00003', 'Java', 95.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (9, 'S00003', 'PE', 82.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (10, 'S00004', 'Math', 66.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (11, 'S00004', 'Java', 76.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (12, 'S00004', 'PE', 85.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (13, 'S00005', 'Math', 90.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (14, 'S00005', 'Java', 85.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (15, 'S00005', 'PE', 80.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (16, 'S00006', 'Math', 76.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (17, 'S00006', 'Java', 88.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (18, 'S00006', 'PE', 70.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (19, 'S00007', 'Math', 95.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (20, 'S00007', 'Java', 92.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (21, 'S00007', 'PE', 89.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (22, 'S00008', 'Math', 78.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (23, 'S00008', 'Java', 82.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (24, 'S00008', 'PE', 74.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (25, 'S00009', 'Math', 80.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (26, 'S00009', 'Java', 85.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (27, 'S00009', 'PE', 78.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (28, 'S00010', 'Math', 85.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (29, 'S00010', 'Java', 88.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (30, 'S00010', 'PE', 82.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (31, 'S00011', 'Java', 100.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (33, 'S10020', 'Java', 10.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (34, 'S10020', 'Math', 100.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (35, 'S10020', 'Math', 100.00);
INSERT INTO `grades` (`id`, `student_id`, `subject`, `score`) VALUES (37, 'S00012', 'Math', 70.00);
COMMIT;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` char(1) NOT NULL,
  `birth_date` date NOT NULL,
  `class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of students
-- ----------------------------
BEGIN;
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (1, 'S00001', 'Alice', 'M', '2000-01-01', '1');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (2, 'S00002', 'Bob', 'M', '2001-02-01', '1');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (3, 'S00003', 'Charlie', 'M', '2000-03-01', '2');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (4, 'S00004', 'David', 'M', '2001-04-01', '2');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (5, 'S00005', 'Eve', 'F', '2000-05-01', '2');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (6, 'S00006', 'Frank', 'M', '2001-06-01', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (7, 'S00007', 'Grace', 'F', '2000-07-01', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (8, 'S00008', 'Heidi', 'F', '2001-08-01', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (9, 'S00009', 'Ivan', 'M', '2000-09-01', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (10, 'S00010', 'Judy', 'F', '2001-10-01', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (11, 'S00011', 'xielongjie', 'M', '2004-02-09', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (12, 'S00012', 'daqianqian', 'F', '2003-08-26', '3');
INSERT INTO `students` (`id`, `student_id`, `name`, `gender`, `birth_date`, `class`) VALUES (13, 'S10020', '谢隆杰', '男', '2004-02-09', '2');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`id`, `username`, `password`) VALUES (1, 'admin', 'admin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
