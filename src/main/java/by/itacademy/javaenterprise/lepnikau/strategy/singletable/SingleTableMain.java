package by.itacademy.javaenterprise.lepnikau.strategy.singletable;

import by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.SingleTableDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.impl.SingleTableDAOImpl;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.DeskSingleTable;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.SofaSingleTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleTableMain {
    private static final Logger LOG = LoggerFactory.getLogger(SingleTableMain.class);

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("furniture");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SingleTableDAO SingleTableDAO =
                new SingleTableDAOImpl(entityManager);

        DeskSingleTable tableOne = new DeskSingleTable();
        tableOne.setModelName("Some Model");
        tableOne.setPrice(110.0);
        tableOne.setForm("Square");
        tableOne.setMaterial("Pine");

        LOG.info(SingleTableDAO.find(2L).toString());
        LOG.info(SingleTableDAO.save(tableOne).toString());

        tableOne.setMaterial("Oak");

        if (SingleTableDAO.update(tableOne)) {
            LOG.info("Updated");
        }

        if (SingleTableDAO.delete(tableOne)) {
            LOG.info("Deleted");
        }

        SofaSingleTable sofaOne = new SofaSingleTable();
        sofaOne.setModelName("Some Model");
        sofaOne.setPrice(110.0);
        sofaOne.setType("Sofa Type");
        sofaOne.setPillowsCount(2);

        LOG.info(SingleTableDAO.find(2L).toString());
        LOG.info(SingleTableDAO.save(sofaOne).toString());

        sofaOne.setType("New Type");

        if (SingleTableDAO.update(sofaOne)) {
            LOG.info("Updated");
        }

        if (SingleTableDAO.delete(sofaOne)) {
            LOG.info("Deleted");
        }
    }
}
