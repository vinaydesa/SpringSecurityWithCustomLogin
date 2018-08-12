# SpringSecurityWithCustomLogin


Spring security by default will provide the login Screen. We can customize the login screen by providing a login endpoint in spring configuration.

In this project beside providing the user name and password in the login screen, the user can choose the app he/she wants to login.
In CustomSuccessHandler logic is provided in this project whether the user has to be redirected to the login screen stating no provilege or 
be directed to the respective application


DDL Scripts that would be required for this project to run

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) 

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(33) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `roles_previleges` (
  `role_key` bigint(20) NOT NULL,
  `previlage_key` bigint(20) NOT NULL,
  PRIMARY KEY (`role_key`,`previlage_key`),
  KEY `previlage_key` (`previlage_key`),
  CONSTRAINT `roles_previleges_ibfk_1` FOREIGN KEY (`role_key`) REFERENCES `role` (`id`),
  CONSTRAINT `roles_previleges_ibfk_2` FOREIGN KEY (`previlage_key`) REFERENCES `previlage` (`id`)
)

CREATE TABLE `users_roles` (
  `user_key` bigint(20) NOT NULL,
  `role_key` bigint(20) NOT NULL,
  PRIMARY KEY (`user_key`,`role_key`),
  KEY `role_key` (`role_key`),
  CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_key`) REFERENCES `user` (`id`),
  CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_key`) REFERENCES `role` (`id`)
)

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(22) NOT NULL,
  `first_name` varchar(22) DEFAULT NULL,
  `last_name` varchar(22) DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) 

CREATE TABLE `previlage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
