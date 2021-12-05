INSERT INTO `single_table_strategy_furniture` (`furniture_id`, `FURNITURE_TYPE`, `model_name`, `price`, `form`, `material`, `type`, `pillows_count`) VALUES
(1, 'TABLE', 'Table Model', 100, 'Square', 'Oak', NULL, NULL),
(2, 'SOFA', 'Sofa Model', 300, NULL, NULL, 'Sofa Type', 2);

INSERT INTO `joined_strategy_furniture` (`furniture_id`, `model_name`, `price`) VALUES
(1, 'Table Model', 90),
(2, 'Sofa Model', 310);

INSERT INTO `joined_strategy_sofas` (`furniture_id`, `type`, `pillows_count`) VALUES
(2, 'Sofa Type', 1);

INSERT INTO `joined_strategy_tables` (`furniture_id`, `form`, `material`) VALUES
(1, 'Rectangle', 'Pine');

INSERT INTO `per_class_strategy_furniture` (`furniture_id`, `model_name`, `price`) VALUES
(1, 'Table Model', 110),
(2, 'Sofa Model', 310);

INSERT INTO `per_class_strategy_sofas` (`furniture_id`, `model_name`, `price`, `type`, `pillows_count`) VALUES
(1, 'Sofa Model', 310, 'Sofa Type', 3);

INSERT INTO `per_class_strategy_tables` (`furniture_id`, `model_name`, `price`, `form`, `material`) VALUES
(1, 'Table Model', 110, 'Circle', 'Birch');
