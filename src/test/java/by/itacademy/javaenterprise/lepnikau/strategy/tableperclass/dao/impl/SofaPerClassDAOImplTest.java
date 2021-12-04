package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.PerClassDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.SofaPerClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SofaPerClassDAOImplTest {

    @Mock
    private EntityTransaction entityTransaction;
    @Mock
    private EntityManager entityManager;
    private PerClassDAO<SofaPerClass> perClassDAO;
    private SofaPerClass sofa;

    @BeforeEach
    void beforeEach() {
        perClassDAO = new SofaPerClassDAOImpl(entityManager);
        sofa = new SofaPerClass();
        sofa.setFurnitureId(1L);
        sofa.setModelName("Desk Model");
        sofa.setPrice(100.0);
        sofa.setType("Sofa Type");
        sofa.setPillowsCount(2);
    }

    @Test
    void saveTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        SofaPerClass actual = perClassDAO.save(sofa);

        verify(entityManager, times(1)).persist(sofa);

        assertNotNull(actual);

        assertEquals(sofa, actual);
    }

    @Test
    void saveTestWithEntityNull() {

        assertThrows(IllegalArgumentException.class,
                () -> perClassDAO.save(null));
    }

    @Test
    void findTest() {
        Long id = 1L;

        when(entityManager.find(Mockito.<Class<SofaPerClass>>any(), Mockito.eq(id)))
                .thenReturn(sofa);

        assertEquals(sofa, perClassDAO.find(id));

        verify(entityManager).find(Mockito.<Class<SofaPerClass>>any(), Mockito.eq(id));
    }

    @Test
    void findTestWithWrongId() {
        Long id = -1L;

        when(entityManager.find(Mockito.<Class<SofaPerClass>>any(), Mockito.eq(id)))
                .thenReturn(null);

        assertNull(perClassDAO.find(-1L));

        verify(entityManager).find(Mockito.<Class<SofaPerClass>>any(), Mockito.eq(id));
    }

    @Test
    void update() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        when(entityManager.merge(sofa)).thenReturn(sofa);

        assertTrue(perClassDAO.update(sofa));

        verify(entityManager, times(1)).merge(sofa);
    }

    @Test
    void updateTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> perClassDAO.update(null));
    }

    @Test
    void deleteTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        assertTrue(perClassDAO.delete(sofa));

        verify(entityManager, times(1)).remove(sofa);
    }

    @Test
    void deleteTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> perClassDAO.delete(null));
    }

    @Test
    void deleteTestWithDeskIdLessThenZero() {

        sofa.setFurnitureId(-1L);

        assertThrows(IllegalArgumentException.class, () -> perClassDAO.delete(sofa));

    }
}