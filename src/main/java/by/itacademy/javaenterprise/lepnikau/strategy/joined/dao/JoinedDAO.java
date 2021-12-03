package by.itacademy.javaenterprise.lepnikau.strategy.joined.dao;

import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.FurnitureJoined;

public interface JoinedDAO {

    FurnitureJoined save(FurnitureJoined furniture);

    FurnitureJoined find(Long id);

    boolean update(FurnitureJoined furniture);

    boolean delete(FurnitureJoined furniture);
}
