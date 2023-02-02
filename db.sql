CREATE DATABASE `flow-pre_assignment`

CREATE TABLE `block_file_extension` (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  created_at DATETIME,
  extension_keyword VARCHAR(255),
  `type` VARCHAR(255)
)