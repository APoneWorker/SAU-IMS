CREATE TABLE `anniversary_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `club_id` int(11) NOT NULL,
  `file_name` varchar(50) NOT NULL,
  `audit_state` int(11) NOT NULL DEFAULT '2',
  `audit_result` varchar(100) NOT NULL,
  `submit_time` datetime NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authority` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(40) NOT NULL,
  `authority_available` int(11) NOT NULL DEFAULT '1',
  `description` varchar(100) NOT NULL DEFAULT '无',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authority_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `club_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `club_id` int(11) NOT NULL,
  `send_time` datetime NOT NULL,
  `audit_time` datetime DEFAULT NULL,
  `audit_result` int(11) NOT NULL DEFAULT '2',
  `file` varchar(50) NOT NULL,
  `audit_description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `club_info` (
  `club_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `club_name` varchar(40) NOT NULL,
  `found_time` datetime NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `admin_name` varchar(20) NOT NULL,
  `club_type` varchar(20) DEFAULT NULL,
  `club_logo` varchar(50) NOT NULL DEFAULT 'default.png',
  `club_view` varchar(50) NOT NULL DEFAULT 'default.png',
  `like_number` int(11) NOT NULL DEFAULT '0',
  `members` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `club_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `club_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `club_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `member_duty` int(11) NOT NULL DEFAULT '0',
  `user_state` int(11) NOT NULL DEFAULT '1',
  `join_time` datetime NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `club_department` varchar(200) DEFAULT NULL,
  `available` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `deparment` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) NOT NULL,
  `department_available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(50) NOT NULL,
  `department_id` int(11) NOT NULL,
  `major_available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_title` varchar(100) NOT NULL,
  `message_content` varchar(300) NOT NULL,
  `release_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `message_type` int(11) NOT NULL,
  `message_annex` varchar(50) DEFAULT NULL,
  `message_state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `message_release` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '1',
  `read_flag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person_info` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) NOT NULL,
  `gender` int(11) NOT NULL DEFAULT '0',
  `birthday` datetime DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `student_id` varchar(50) DEFAULT NULL,
  `person_logo` varchar(50) NOT NULL DEFAULT 'default.png',
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(200) NOT NULL,
  `description` varchar(100) NOT NULL,
  `resource_available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(40) NOT NULL,
  `role_info` varchar(40) NOT NULL,
  `role_available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sau_info` (
  `sau_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `sau_name` varchar(40) NOT NULL DEFAULT '校社联',
  `found_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(400) DEFAULT NULL,
  `admin_name` varchar(40) NOT NULL DEFAULT '无',
  `sau_logo` varchar(50) NOT NULL DEFAULT 'default.png',
  `members` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`sau_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(40) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `email` varchar(50) NOT NULL,
  `key` varchar(40) NOT NULL,
  `login_ip` varchar(40) NOT NULL,
  `login_time` datetime NOT NULL,
  `register_ip` varchar(40) NOT NULL,
  `register_time` datetime NOT NULL,
  `authority` int(11) NOT NULL,
  `user_state` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;