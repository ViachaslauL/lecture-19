package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.PerClassDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.DeskPerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class DeskPerClassDAOImpl implements PerClassDAO<DeskPerClass> {

    private static final Logger LOG = LoggerFactory.getLogger(DeskPerClassDAOImpl.class);

    private final EntityManager entityManager;

    public DeskPerClassDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public DeskPerClass save(DeskPerClass furniture) {
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
    public DeskPerClass find(Long id) {
        if (id == null) throw new IllegalArgumentException();

        DeskPerClass furniture = null;

        try {
            furniture = entityManager.find(DeskPerClass.class, id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return furniture;
    }

    @Override
    public boolean update(DeskPerClass furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        DeskPerClass foundedAddress = null;

        try {
            foundedAddress = entityManager.find(DeskPerClass.class, furniture.getFurnitureId());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        if (foundedAddress != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(furniture);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                entityManager.getTransaction().rollback();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(DeskPerClass furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        try {
            furniture = entityManager.find(DeskPerClass.class, furniture.getFurnitureId());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        if (furniture != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(furniture);
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                entityManager.getTransaction().rollback();
            }
        }
        return false;
    }
}
