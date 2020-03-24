/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Minal
 * Created: Mar 23, 2020
 */
drop database itmd4515; 
create database itmd4515; 
use itmd4515;
-- ----------------------------
-- Table structure for `announcements`
-- ----------------------------
CREATE TABLE itmd4515.`announcements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `createdBy` varchar(20) DEFAULT NULL,
  `createdOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedBy` varchar(20) DEFAULT NULL,
  `updatedOn` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of announcements
-- ----------------------------
INSERT INTO itmd4515.`announcements` VALUES ('1', 'Test Announcement', 'This is test Announcement', 'ADMIN', '2020-03-17 05:33:41', 'ADMIN', '2020-03-17 05:33:41', 'A');
INSERT INTO itmd4515.`announcements` VALUES ('2', 'Test Announcement 2', 'This Test Announcement 2 description', 'ADMIN', '2020-03-17 05:55:21', 'ADMIN', '2020-03-17 05:55:21', 'A');


-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`course`;
CREATE TABLE itmd4515.`course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseDuration` varchar(255) DEFAULT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO itmd4515.`course` VALUES ('1', '10', 'Computer Science', null, null, 'A', null, null);
INSERT INTO itmd4515.`course` VALUES ('2', '50', 'Java Training', null, null, 'A', null, null);
INSERT INTO itmd4515.`course` VALUES ('3', '60', 'Python Asasdasda', null, null, 'A', null, null);
INSERT INTO itmd4515.`course` VALUES ('5', '23', 'Dot Net', 'ADMIN', '2020-03-17 15:22:41', 'A', 'ADMIN', '2020-03-17 15:22:41');


-- ----------------------------
-- Table structure for `coursewisematerial`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`coursewisematerial`;
CREATE TABLE itmd4515.`coursewisematerial` (
  `courseWiseMaterialId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `deadLine` int(11) DEFAULT NULL,
  `materialFile` longblob,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `materialName` varchar(250) DEFAULT NULL,
  `fileName` varchar(10) DEFAULT NULL,
  `fromDate` datetime DEFAULT NULL,
  `toDate` datetime DEFAULT NULL,
  PRIMARY KEY (`courseWiseMaterialId`),
  KEY `FK_coursewisematerial_courseId` (`courseId`),
  CONSTRAINT `FK_coursewisematerial_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `authuser`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`authuser`;
CREATE TABLE itmd4515.`authuser` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNo` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of authuser
-- ----------------------------
INSERT INTO itmd4515.`authuser` VALUES ('2', 'ADMIN_USER', '2020-03-17 07:48:33', 'admin', 'Admin', '', '-44,46,-32,107,-66,-37,65,119,93,16,52,4,:-:e725e17756536cc62cce0f31c7f0cf4a', null, 'A', 'REGISTER_USER', '2020-03-17 07:48:33', null, 'ADMIN'); 


-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`students`;
CREATE TABLE itmd4515.`students` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `facialTokanImage` longblob,
  `firstName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  KEY `FK_students_userId` (`userId`),
  CONSTRAINT `FK_students_userId` FOREIGN KEY (`userId`) REFERENCES `authuser` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO itmd4515.`students` VALUES ('1', 'ADMIN', '2020-03-06 12:01:32', 'Minal.v@gmail.com', null, 'Minal', 'F', 'K', 'A', 'ADMIN', '2020-03-06 12:01:54', '3');
INSERT INTO itmd4515.`students` VALUES ('2', 'ADMIN', '2020-03-06 12:02:43', 'Sonakshi.R@gmail.com', null, 'Sonakshi', 'F', 'R', 'A', 'ADMIN', '2020-03-06 12:02:37', '4');
INSERT INTO itmd4515.`students` VALUES ('3', 'ADMIN', '2020-03-06 12:03:37', 'v.minal@gmail.com', null, 'Minal 1', 'F', 'K', 'A', 'ADMIN', '2020-03-06 12:03:33', '5');
INSERT INTO itmd4515.`students` VALUES ('4', 'ADMIN', '2020-03-07 13:03:38', 'abc@GMAIL.COM', null, 'Aishu', null, 'R', 'A', 'ADMIN', '2020-03-07 13:03:48', '6');


-- ----------------------------
-- Table structure for `authusergroups`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`authusergroups`;
CREATE TABLE itmd4515.`authusergroups` (
  `authUserGroupId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`authUserGroupId`),
  KEY `FK_authusergroups_userId` (`userId`),
  CONSTRAINT `FK_authusergroups_userId` FOREIGN KEY (`userId`) REFERENCES `authuser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `assignment`
-- ----------------------------
CREATE TABLE itmd4515.`assignment` (
  `assignmentId` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `grading` varchar(255) DEFAULT NULL,
  `instructorId` int(11) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `uploadedDoc` longblob,
  `courseId` int(11) DEFAULT NULL,
  `courseWiseMaterialId` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`assignmentId`),
  KEY `FK_assignment_courseWiseMaterialId` (`courseWiseMaterialId`),
  KEY `FK_assignment_courseId` (`courseId`),
  KEY `FK_assignment_studentId` (`studentId`),
  CONSTRAINT `FK_assignment_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_assignment_courseWiseMaterialId` FOREIGN KEY (`courseWiseMaterialId`) REFERENCES `coursewisematerial` (`courseWiseMaterialId`),
  CONSTRAINT `FK_assignment_studentId` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `instructor`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`instructor`;
CREATE TABLE itmd4515.`instructor` (
  `instructorId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`instructorId`),
  KEY `FK_instructor_userId` (`userId`),
  CONSTRAINT `FK_instructor_userId` FOREIGN KEY (`userId`) REFERENCES `authuser` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of instructor
-- ----------------------------
INSERT INTO itmd4515.`instructor` VALUES ('1', null, null, 'Smith', 'Maria', 'A', null, null, null);
INSERT INTO itmd4515.`instructor` VALUES ('2', null, null, 'Thompson', 'Michelle', 'A', null, null, null);
INSERT INTO itmd4515.`instructor` VALUES ('3', null, null, 'Johnson', 'Linda', 'A', null, null, null);


-- ----------------------------
-- Table structure for `courseinstructormapping`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`courseinstructormapping`;
CREATE TABLE itmd4515.`courseinstructormapping` (
  `courseInstructorId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `instructorId` int(11) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`courseInstructorId`),
  KEY `FK_coursemap_courseId` (`courseId`),
  KEY `FK_coursemap_instructorId` (`instructorId`),
  CONSTRAINT `FK_coursemap_instructorId` FOREIGN KEY (`instructorId`) REFERENCES `instructor` (`instructorId`),
  CONSTRAINT `FK_coursemap_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of courseinstructormapping
-- ----------------------------
INSERT INTO itmd4515.`courseinstructormapping` VALUES ('1', '1', '2', null, null, 'A', null, null);
INSERT INTO itmd4515.`courseinstructormapping` VALUES ('2', '1', '2', null, null, 'A', null, null);
INSERT INTO itmd4515.`courseinstructormapping` VALUES ('3', '2', '3', 'ADMIN', null, 'A', null, null);


-- ----------------------------
-- Table structure for `guest`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`guest`;
CREATE TABLE itmd4515.`guest` (
  `guestId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`guestId`),
  KEY `FK_guest_userId` (`userId`),
  CONSTRAINT `FK_guest_userId` FOREIGN KEY (`userId`) REFERENCES `authuser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `mstauthusertype`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`mstauthusertype`;
CREATE TABLE itmd4515.`mstauthusertype` (
  `mstAuthUserTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `userType` varchar(20) NOT NULL,
  `userTypeDesc` varchar(250) NOT NULL,
  `createdBy` varchar(20) NOT NULL,
  `createdOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedBy` varchar(20) NOT NULL,
  `updatedOn` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`mstAuthUserTypeID`),
  UNIQUE KEY `UQ__mstauthu__EEC131F3272FB2E8` (`mstAuthUserTypeID`),
  UNIQUE KEY `PK__mstauthu__EEC131F21E9A6CE7` (`mstAuthUserTypeID`),
  UNIQUE KEY `UQ__mstauthu__87E786912453463D` (`userType`),
  UNIQUE KEY `UQ__mstauthu__87E786912176D992` (`userType`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


-- ----------------------------
-- Table structure for `notifications`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`notifications`;
CREATE TABLE ITMD4515.`notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `createdBy` varchar(20) DEFAULT NULL,
  `createdOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedBy` varchar(20) DEFAULT NULL,
  `updatedOn` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notifications
-- ----------------------------
INSERT INTO itmd4515.`notifications` VALUES ('1', 'Test Notification 1', 'Test Notification 1 Description', 'ADMIN', '2020-03-17 05:56:16', 'ADMIN', '2020-03-17 05:56:16', 'A');
INSERT INTO itmd4515.`notifications` VALUES ('2', 'Test Notification 2', 'Test Notification 2 description', 'ADMIN', '2020-03-17 05:57:03', 'ADMIN', '2020-03-17 05:57:03', 'A');


-- ----------------------------
-- Table structure for `studentrequestcourse`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`studentrequestcourse`;
CREATE TABLE itmd4515.`studentrequestcourse` (
  `studentReqCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentReqCourseId`),
  KEY `FK_studentrequestcourse_courseId` (`courseId`),
  KEY `FK_studentrequestcourse_studentId` (`studentId`),
  CONSTRAINT `FK_studentrequestcourse_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_studentrequestcourse_studentId` FOREIGN KEY (`studentId`) REFERENCES `students` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of studentrequestcourse
-- ----------------------------
INSERT INTO itmd4515.`studentrequestcourse` VALUES ('1', 'ADMIN', '2018-12-06 12:04:35', 'A', 'ADMIN', '2018-12-06 12:04:39', '1', '1');
INSERT INTO itmd4515.`studentrequestcourse` VALUES ('2', 'ADMIN', '2018-12-06 12:05:07', 'A', 'ADMIN', '2018-12-06 12:05:04', '2', '2');
INSERT INTO itmd4515.`studentrequestcourse` VALUES ('3', 'ADMIN', '2018-12-06 12:05:24', 'A', 'ADMIN', '2018-12-06 12:05:17', '2', '3');


-- ----------------------------
-- Table structure for `teachingassistant`
-- ----------------------------
DROP TABLE IF EXISTS itmd4515.`teachingassistant`;
CREATE TABLE itmd4515.`teachingassistant` (
  `teachingAssistantId` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `facialTokanImage` longblob,
  `firstName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`teachingAssistantId`),
  KEY `FK_teachingassistant_userId` (`userId`),
  KEY `FK_teachingassistant_courseId` (`courseId`),
  CONSTRAINT `FK_teachingassistant_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FK_teachingassistant_userId` FOREIGN KEY (`userId`) REFERENCES `authuser` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teachingassistant
-- ----------------------------
INSERT INTO itmd4515.`teachingassistant` VALUES ('1', 'ADMIN', '2020-03-17 20:49:16', 'pulla@gmail.com', null, 'Smith', 'M', 'Mary', 'A', 'ADMIN', '2020-03-17 20:49:13', '2', null);
INSERT INTO itmd4515.`teachingassistant` VALUES ('2', 'ADMIN', '2020-03-17 20:50:13', 'nag@gmail.com', null, 'Johnson', 'M', 'Linda', 'A', 'ADMIN', '2020-03-17 20:49:42', '2', null);
INSERT INTO itmd4515.`teachingassistant` VALUES ('3', 'ADMIN', '2020-03-17 20:50:22', 'abc@gmail.com', null, 'Williams', 'M', 'Jennifer', 'A', 'ADMIN', '2020-03-17 20:52:36', '2', null);
INSERT INTO itmd4515.`teachingassistant` VALUES ('4', 'ADMIN', '2020-03-17 20:54:46', null, null, 'Jones', null, 'Maria', 'A', 'ADMIN', '2020-03-17 20:54:33', '1', null);
INSERT INTO itmd4515.`teachingassistant` VALUES ('5', 'ADMIN', '2020-03-17 20:54:49', null, null, 'Thompson', null, 'Michelle', 'A', 'ADMIN', '2020-03-17 20:54:39', '1', null);


