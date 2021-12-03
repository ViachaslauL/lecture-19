CREATE TABLE `furniture_db`.`single_table_strategy_furniture`
(
    `furniture_id`   INT          NOT NULL AUTO_INCREMENT,
    `FURNITURE_TYPE` VARCHAR(32)  NOT NULL,
    `model_name`     VARCHAR(255) NOT NULL,
    `price`          DOUBLE       NOT NULL,
    `form`           VARCHAR(255) DEFAULT NULL,
    `material`       VARCHAR(255) DEFAULT NULL,
    `type`           VARCHAR(255) DEFAULT NULL,
    `pillows_count`  INT          DEFAULT NULL,
    PRIMARY KEY (`furniture_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;