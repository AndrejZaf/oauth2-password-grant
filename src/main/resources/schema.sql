CREATE TABLE IF NOT EXISTS  `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `created_at` datetime(6) DEFAULT NULL,
    `deleted_at` datetime(6) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `enabled` bit(1) NOT NULL,
    `height` double DEFAULT NULL,
    `is_verified` tinyint(1) DEFAULT '0',
    `login_code` varchar(255) DEFAULT NULL,
    `measurement_system_enum` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role` varchar(255) DEFAULT NULL,
    `uid` varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    `weight` double DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `oauth_client_details` (
    `client_id` varchar(255) NOT NULL,
    `access_token_validity` int(11) DEFAULT NULL,
    `additional_information` varchar(255) DEFAULT NULL,
    `authorities` varchar(255) DEFAULT NULL,
    `authorized_grant_types` varchar(255) DEFAULT NULL,
    `autoapprove` bit(1) DEFAULT NULL,
    `client_secret` varchar(255) DEFAULT NULL,
    `refresh_token_validity` int(11) DEFAULT NULL,
    `resource_ids` varchar(255) DEFAULT NULL,
    `scope` varchar(255) DEFAULT NULL,
    `web_server_redirect_uri` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
