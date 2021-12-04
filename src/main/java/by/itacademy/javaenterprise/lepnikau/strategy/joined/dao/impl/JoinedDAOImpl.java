package by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.JoinedDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.FurnitureJoined;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class JoinedDAOImpl implements JoinedDAO {

    private static final Logger LOG = LoggerFactory.getLogger(JoinedDAOImpl.class);

    private final EntityManager entityManager;

    public JoinedDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FurnitureJoined save(FurnitureJoined furniture) {
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
    public FurnitureJoined find(Long id) {
        if (id == null) throw new IllegalArgumentException();

        FurnitureJoined furniture = null;

        try {
            furniture = entityManager.find(FurnitureJoined.class, id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return furniture;
    }

    @Override
    public boolean update(FurnitureJoined furniture) {
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
    public boolean delete(FurnitureJoined furniture) {
        if (furniture == null) throw new IllegalArgumentException();

        System.out.println(furniture.getFurnitureId());

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
