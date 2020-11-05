/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : ssmbookappoint

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 05/11/2020 21:14:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`, `token`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'a8023eb311f7c554a58ba4db991b41ad');

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '预约时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_appoint_time`(`appoint_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约图书表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, 1000, 7976399, '2020-11-03 16:22:00');
INSERT INTO `appointment` VALUES (2, 1000, 3211200801, '2020-11-02 15:47:26');
INSERT INTO `appointment` VALUES (3, 1001, 3211200801, '2020-11-02 16:10:43');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `introd` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1000, 'Java程序设计', 'Java程序设计是一门balbal', 7);
INSERT INTO `book` VALUES (1001, '数据结构', '数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。', 9);
INSERT INTO `book` VALUES (1002, '设计模式', '设计模式（Design Pattern）是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结。', 10);
INSERT INTO `book` VALUES (1003, '编译原理', '编译原理是计算机专业的一门重要专业课，旨在介绍编译程序构造的一般原理和基本方法。', 10);
INSERT INTO `book` VALUES (1004, '大学语文', '基于长期的教学实践和学科思考，我们编写了这本《大学语文》教材balbal', 10);
INSERT INTO `book` VALUES (1005, '计算方法', '计算方法又称“数值分析”。是为各种数学问题的数值解答研究提供最有效的算法。', 10);
INSERT INTO `book` VALUES (1006, '高等数学', '广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、几何以及简单的集合论初步balbal', 10);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` bigint(20) NOT NULL COMMENT '学生ID',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (7976399, 'qs12345');
INSERT INTO `student` VALUES (3211200801, '346543');
INSERT INTO `student` VALUES (3211200802, '754323');
INSERT INTO `student` VALUES (3211200803, '674554');
INSERT INTO `student` VALUES (3211200804, '542344');
INSERT INTO `student` VALUES (3211200805, '298383');
INSERT INTO `student` VALUES (3211200806, '873973');
INSERT INTO `student` VALUES (3211200807, '193737');
INSERT INTO `student` VALUES (3211200808, '873092');

SET FOREIGN_KEY_CHECKS = 1;
