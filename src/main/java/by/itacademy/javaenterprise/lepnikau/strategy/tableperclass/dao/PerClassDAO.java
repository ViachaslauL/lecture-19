package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao;

public interface PerClassDAO<T> {

    T save(T furniture);

    T find(Long id);

    boolean update(T furniture);

    boolean delete(T furniture);
}
