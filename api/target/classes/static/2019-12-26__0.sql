CREATE TABLE `blog`.`post` (
  `uuid` VARCHAR(40) NOT NULL,
  `title` VARCHAR(40) NOT NULL,
  `contents` TEXT NULL,
  `create_datetime` DATETIME NOT NULL,
  `update_datetime` DATETIME NULL,
  PRIMARY KEY (`uuid`));
