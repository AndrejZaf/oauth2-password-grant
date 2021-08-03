INSERT IGNORE INTO `spring`.`oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`,	`refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES	('fooClientIdPassword1', '{bcrypt}$2a$10$fwYTuhTHLvyIWBuq1NsJ3u7xUgXg3cueUkt9F4soalL4wgtrb9Uqq', 'read', 'password', 'http://localhost:8080/home', 'ROLE_BRONZE', 36000, 36000, null, true);


INSERT IGNORE INTO `spring`.`oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`,	`refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES	('fooClientIdPassword1', '{bcrypt}$2a$10$fwYTuhTHLvyIWBuq1NsJ3u7xUgXg3cueUkt9F4soalL4wgtrb9Uqq', 'read', 'authorization_code', 'http://localhost:8080/home', 'ROLE_BRONZE', 36000, 36000, null, true);

INSERT IGNORE INTO `spring`.`user`
(`id`,`created_at`,`deleted_at`,`email`,`enabled`,`height`,`is_verified`,`login_code`,`measurement_system_enum`,`password`,`role`,`uid`,`username`,`weight`)
VALUES(1,'2021-08-02 13:50:44.549479',null,'test@test.com',0,null,0,'745f563d-cd49-4422-a6f5-81b852564d5c',null,'{bcrypt}$2a$10$Hi.dlvNeArJDJngs06AaqeI1TH0WcWpIe1VDcueacc2VvGvCsKsve','ROLE_BRONZE','c23e8939-ea48-43aa-b0b4-4ea2745289bd','test',null);