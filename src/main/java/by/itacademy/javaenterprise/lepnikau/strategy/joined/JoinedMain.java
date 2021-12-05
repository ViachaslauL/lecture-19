package by.itacademy.javaenterprise.lepnikau.strategy.joined;

import by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.JoinedDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.impl.JoinedDAOImpl;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.FurnitureJoined;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.SofaJoined;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JoinedMain {
    private static final Logger LOG = LoggerFactory.getLogger(JoinedMain.class);

    public static void main(String[] args) {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("furniture")
                .createEntityManager();

        JoinedDAO joinedDAO = new JoinedDAOImpl(entityManager);

        SofaJoined sofa = new SofaJoined();
        sofa.setModelName("Some Model");
        sofa.setPrice(200.0);
        sofa.setType("Sofa Type");
        sofa.setPillowsCount(1);

        LOG.info(joinedDAO.find(1L).toString());
        LOG.info(joinedDAO.save(sofa).toString());

        FurnitureJoined sofaFind = joinedDAO.find(4L);
        sofaFind.setModelName("New Model Name");

        if (joinedDAO.update(sofa)) {
            LOG.info("Updated");
        }
    }
}
