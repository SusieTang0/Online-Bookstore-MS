USE `bookstore`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$naaUoJUanvIcnRmRhGbcM.hN6K82gOflvbARJC1Php/a.D5z.ezSS',1),
('mary','{bcrypt}$2a$10$naaUoJUanvIcnRmRhGbcM.hN6K82gOflvbARJC1Php/a.D5z.ezSS',1),
('susan','{bcrypt}$2a$10$naaUoJUanvIcnRmRhGbcM.hN6K82gOflvbARJC1Php/a.D5z.ezSS',1),
('anna','{bcrypt}$2a$10$naaUoJUanvIcnRmRhGbcM.hN6K82gOflvbARJC1Php/a.D5z.ezSS',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('susan','ROLE_CUSTOMER'),
('anna','ROLE_CUSTOMER');


select * from authorities;
select * from users;