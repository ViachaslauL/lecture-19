CREATE TABLE `joined_strategy_sofas`
(
    `furniture_id`  int NOT NULL,
    `type`          varchar(255) DEFAULT NULL,
    `pillows_count` int          DEFAULT NULL,
    KEY `furniture_id` (`furniture_id`),
    CONSTRAINT `joined_strategy_sofas_ibfk_1`
        FOREIGN KEY (`furniture_id`)
            REFERENCES `joined_strategy_furniture` (`furniture_id`)
            ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
