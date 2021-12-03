CREATE TABLE `per_class_strategy_furniture`
(
    `furniture_id` int          NOT NULL AUTO_INCREMENT,
    `model_name`   varchar(255) NOT NULL,
    `price`        double       NOT NULL,
    PRIMARY KEY (`furniture_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;