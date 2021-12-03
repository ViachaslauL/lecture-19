CREATE TABLE `joined_strategy_tables`
(
    `furniture_id` int NOT NULL,
    `form`         varchar(255) DEFAULT NULL,
    `material`     varchar(255) DEFAULT NULL,
    KEY `furniture_id` (`furniture_id`),
    CONSTRAINT `joined_strategy_tables_ibfk_1`
        FOREIGN KEY (`furniture_id`)
            REFERENCES `joined_strategy_furniture` (`furniture_id`)
            ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
