package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.PerClassDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.SofaPerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class SofaPerClassDAOImpl implements PerClassDAO<SofaPerClass> {

    private static final Logger LOG = LoggerFactory.getLogger(SofaPerClassDAOImpl.class);

    private final EntityManager entityManager;

    public SofaPerClassDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SofaPerClass save(SofaPerClass furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(furniture);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            entityManager.getTransaction().rollback();
        }
        return furniture;
    }

    @Override
    public SofaPerClass find(Long id) {
        if (id == null) throw new IllegalArgumentException();

        SofaPerClass furniture = null;

        try {
            furniture = entityManager.find(SofaPerClass.class, id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return furniture;
    }

    @Override
    public boolean update(SofaPerClass furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(furniture);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(SofaPerClass furniture) {
        if (furniture == null || furniture.getFurnitureId() <= 0)
            throw new IllegalArgumentException();

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(furniture);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            entityManager.getTransaction().rollback();
        }
        return false;
    }
}
