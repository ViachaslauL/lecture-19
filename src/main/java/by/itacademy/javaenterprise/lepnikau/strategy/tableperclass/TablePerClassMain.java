package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass;

import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.PerClassDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl.DeskPerClassDAOImpl;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl.SofaPerClassDAOImpl;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.DeskPerClass;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.SofaPerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TablePerClassMain {
    private static final Logger LOG = LoggerFactory.getLogger(TablePerClassMain.class);

    public static void main(String[] args) {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("furniture")
                .createEntityManager();

        PerClassDAO<DeskPerClass> deskDao = new DeskPerClassDAOImpl(entityManager);
        PerClassDAO<SofaPerClass> sofaDAO = new SofaPerClassDAOImpl(entityManager);

        DeskPerClass deskPerClass = new DeskPerClass();
        deskPerClass.setModelName("Table Model");
        deskPerClass.setPrice(115.0);
        deskPerClass.setForm("Rectangle");
        deskPerClass.setMaterial("Pine");

        SofaPerClass sofaPerClass = new SofaPerClass();
        sofaPerClass.setModelName("Sofa Model");
        sofaPerClass.setPrice(333.0);
        sofaPerClass.setType("Sofa Type");
        sofaPerClass.setPillowsCount(3);

        LOG.info(sofaDAO.save(sofaPerClass).toString());
        LOG.info(deskDao.find(2L).toString());
    }
}
