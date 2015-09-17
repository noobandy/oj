/*
SQLyog Ultimate v9.20 
MySQL - 5.0.45-community-nt : Database - online_judge
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `evaluation_result` */

DROP TABLE IF EXISTS `evaluation_result`;

CREATE TABLE `evaluation_result` (
  `id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `status` varchar(255) collate utf8_unicode_ci default NULL,
  `solution_id` varchar(255) collate utf8_unicode_ci default NULL,
  `test_case_id` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKE126280A028FF70` (`solution_id`),
  KEY `FKE12628050096915` (`test_case_id`),
  CONSTRAINT `FKE12628050096915` FOREIGN KEY (`test_case_id`) REFERENCES `test_case` (`id`),
  CONSTRAINT `FKE126280A028FF70` FOREIGN KEY (`solution_id`) REFERENCES `solution` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `evaluation_result` */

insert  into `evaluation_result`(`id`,`status`,`solution_id`,`test_case_id`) values ('402894484fdb2053014fdb205a5e0001','AC','402894484fdb2053014fdb2057860000','402894484fdb1c0c014fdb1c0f700001'),('402894484fdb2053014fdb205ac60002','AC','402894484fdb2053014fdb2057860000','402894484fdb1c0c014fdb1c0f7c0002');

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) collate utf8_unicode_ci NOT NULL,
  `series` varchar(64) collate utf8_unicode_ci NOT NULL,
  `token` varchar(64) collate utf8_unicode_ci NOT NULL,
  `last_used` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `persistent_logins` */

insert  into `persistent_logins`(`username`,`series`,`token`,`last_used`) values ('anandm@mkcl.org','cY8hGHdABM0eXM/iXi94hg==','wp2naSysgeD25YaRQHmTGA==','2015-09-11 16:58:49');

/*Table structure for table `problem` */

DROP TABLE IF EXISTS `problem`;

CREATE TABLE `problem` (
  `id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `max_solution_size_limit` bigint(20) default NULL,
  `problem_statement` text collate utf8_unicode_ci,
  `max_memory_limit` bigint(20) default NULL,
  `max_time_limit` bigint(20) default NULL,
  `user_id` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKED8CC29F89C12130` (`user_id`),
  CONSTRAINT `FKED8CC29F89C12130` FOREIGN KEY (`user_id`) REFERENCES `user` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `problem` */

insert  into `problem`(`id`,`max_solution_size_limit`,`problem_statement`,`max_memory_limit`,`max_time_limit`,`user_id`) values ('402894484fdb1c0c014fdb1c0f1e0000',5000,'Write a program to calculate square of a given number N.Input : first line of input contains no of test cases T.then each line contains number N.Ouput : each line contains sqare of input N.Examle :Input : 235Output :925Exlaination: first line 2 (2 test cases)then each input 3 and 5 on seperate line.their output 3^2 = 95^2 = 25',1500000000,1000,NULL);

/*Table structure for table `solution` */

DROP TABLE IF EXISTS `solution`;

CREATE TABLE `solution` (
  `id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `evaluated_at` datetime default NULL,
  `solution_file_path` varchar(255) collate utf8_unicode_ci default NULL,
  `submitted_at` datetime default NULL,
  `problem_id` varchar(255) collate utf8_unicode_ci default NULL,
  `compilation_errors` varchar(255) collate utf8_unicode_ci default NULL,
  `language` varchar(255) collate utf8_unicode_ci default NULL,
  `status` varchar(255) collate utf8_unicode_ci default NULL,
  `user_id` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK58ED4D7914B8EA44` (`problem_id`),
  KEY `FK58ED4D7989C12130` (`user_id`),
  CONSTRAINT `FK58ED4D7989C12130` FOREIGN KEY (`user_id`) REFERENCES `user` (`email_id`),
  CONSTRAINT `FK58ED4D7914B8EA44` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `solution` */

insert  into `solution`(`id`,`evaluated_at`,`solution_file_path`,`submitted_at`,`problem_id`,`compilation_errors`,`language`,`status`,`user_id`) values ('402894484fdb2053014fdb2057860000','2015-09-17 17:16:14','0c/39/d2/1d/1442490373717/solution','2015-09-17 17:16:14','402894484fdb1c0c014fdb1c0f1e0000','','JAVA','AC','anandm@mkcl.org');

/*Table structure for table `test_case` */

DROP TABLE IF EXISTS `test_case`;

CREATE TABLE `test_case` (
  `id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `input_file_path` varchar(255) collate utf8_unicode_ci default NULL,
  `output_file_path` varchar(255) collate utf8_unicode_ci default NULL,
  `problem_id` varchar(255) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB9A0FABD14B8EA44` (`problem_id`),
  CONSTRAINT `FKB9A0FABD14B8EA44` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `test_case` */

insert  into `test_case`(`id`,`input_file_path`,`output_file_path`,`problem_id`) values ('402894484fdb1c0c014fdb1c0f700001','1a/13/73/96/1442490093264/test0.in.txt','1a/13/73/96/1442490093264/test0.out.txt','402894484fdb1c0c014fdb1c0f1e0000'),('402894484fdb1c0c014fdb1c0f7c0002','1a/13/73/96/1442490093264/test1.in.txt','1a/13/73/96/1442490093264/test1.out.txt','402894484fdb1c0c014fdb1c0f1e0000');

/*Table structure for table `test_case_extra_data` */

DROP TABLE IF EXISTS `test_case_extra_data`;

CREATE TABLE `test_case_extra_data` (
  `test_case_id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `data_value` varchar(255) collate utf8_unicode_ci default NULL,
  `data_key` varchar(255) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`test_case_id`,`data_key`),
  KEY `FK9970513B50096915` (`test_case_id`),
  CONSTRAINT `FK9970513B50096915` FOREIGN KEY (`test_case_id`) REFERENCES `test_case` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `test_case_extra_data` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `email_id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `created_at` datetime default NULL,
  `locked_at` datetime default NULL,
  `password` varchar(255) collate utf8_unicode_ci default NULL,
  `password_reset_key` varchar(255) collate utf8_unicode_ci default NULL,
  `verification_key` varchar(255) collate utf8_unicode_ci default NULL,
  `verified_at` datetime default NULL,
  PRIMARY KEY  (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`email_id`,`created_at`,`locked_at`,`password`,`password_reset_key`,`verification_key`,`verified_at`) values ('anandm@mkcl.org','2015-09-11 16:58:22',NULL,'$2a$10$PjveZnsrLkSTOpL3wYJkQulcgOzjtWJgRHnOoaC/7mQwd5mcWxSk.',NULL,'8eeaa728-9d3b-4161-b420-8eb7417f3e3d','2015-09-11 16:58:22');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` varchar(255) collate utf8_unicode_ci NOT NULL,
  `role` varchar(255) collate utf8_unicode_ci default NULL,
  KEY `FK143BF46A89C12130` (`user_id`),
  CONSTRAINT `FK143BF46A89C12130` FOREIGN KEY (`user_id`) REFERENCES `user` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role`) values ('anandm@mkcl.org','USER_ROLE');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
