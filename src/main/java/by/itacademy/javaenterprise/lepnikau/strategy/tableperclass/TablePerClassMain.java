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

        SofaPerClass sofa = new SofaPerClass();
        sofa.setModelName("Sofa Model");
        sofa.setPrice(333.0);
        sofa.setType("Sofa Type");
        sofa.setPillowsCount(3);

        LOG.info(sofaDAO.save(sofa).toString());
        LOG.info(deskDao.find(2L).toString());

        SofaPerClass newSofa = sofaDAO.find(2L);

        newSofa.setPillowsCount(2);

        if (sofaDAO.update(newSofa)) {
            LOG.info("Updated");
        }
    }
}
