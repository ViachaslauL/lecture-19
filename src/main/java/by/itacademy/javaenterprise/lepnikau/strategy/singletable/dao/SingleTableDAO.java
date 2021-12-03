package by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao;

import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.FurnitureSingleTable;

public interface SingleTableDAO {

    FurnitureSingleTable save(FurnitureSingleTable furniture);

    FurnitureSingleTable find(Long id);

    boolean update(FurnitureSingleTable furniture);

    boolean delete(FurnitureSingleTable furniture);
}
