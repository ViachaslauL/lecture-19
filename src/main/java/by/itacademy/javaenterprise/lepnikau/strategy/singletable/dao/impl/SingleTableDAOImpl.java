package by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.SingleTableDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.FurnitureSingleTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class SingleTableDAOImpl implements SingleTableDAO {

    private static final Logger LOG = LoggerFactory.getLogger(SingleTableDAOImpl.class);

    private final EntityManager entityManager;

    public SingleTableDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FurnitureSingleTable save(FurnitureSingleTable furniture) {
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
    public FurnitureSingleTable find(Long id) {
        if (id == null) throw new IllegalArgumentException();

        FurnitureSingleTable furniture = null;

        try {
            furniture = entityManager.find(FurnitureSingleTable.class, id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return furniture;
    }

    @Override
    public boolean update(FurnitureSingleTable furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        FurnitureSingleTable foundedAddress = null;

        try {
            foundedAddress = entityManager.find(FurnitureSingleTable.class, furniture.getFurnitureId());
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
    public boolean delete(FurnitureSingleTable furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        try {
            furniture = entityManager.find(FurnitureSingleTable.class, furniture.getFurnitureId());
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
