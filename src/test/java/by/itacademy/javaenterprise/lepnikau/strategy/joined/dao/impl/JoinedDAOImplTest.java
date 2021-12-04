package by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.joined.dao.JoinedDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.FurnitureJoined;
import by.itacademy.javaenterprise.lepnikau.strategy.joined.entity.SofaJoined;
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
class JoinedDAOImplTest {

    @Mock
    private EntityTransaction entityTransaction;
    @Mock
    private EntityManager entityManager;
    private JoinedDAO joinedDAO;

    private SofaJoined sofa;

    @BeforeEach
    void beforeEach() {
        joinedDAO = new JoinedDAOImpl(entityManager);
        sofa = new SofaJoined();
        sofa.setFurnitureId(1L);
        sofa.setModelName("Sofa Model");
        sofa.setPrice(100.0);
        sofa.setType("Sofa Type");
        sofa.setPillowsCount(2);
    }

    @Test
    void saveTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        FurnitureJoined actual = joinedDAO.save(sofa);

        verify(entityManager, times(1)).persist(sofa);

        assertNotNull(actual);

        assertEquals(sofa, actual);
    }

    @Test
    void saveTestWithEntityNull() {

        assertThrows(IllegalArgumentException.class, () -> joinedDAO.save(null));
    }

    @Test
    void findTest() {
        Long id = 1L;

        when(entityManager.find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(id)))
                .thenReturn(sofa);

        assertEquals(sofa, joinedDAO.find(id));

        verify(entityManager).find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(id));
    }

    @Test
    void findTestWithWrongId() {
        Long id = -1L;

        when(entityManager.find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(id)))
                .thenReturn(null);

        assertNull(joinedDAO.find(-1L));

        verify(entityManager).find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(id));
    }

    @Test
    void updateTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        when(entityManager.merge(sofa)).thenReturn(sofa);

        assertTrue(joinedDAO.update(sofa));

        verify(entityManager, times(1)).merge(sofa);
    }

    @Test
    void updateTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> joinedDAO.update(null));
    }

    @Test
    void deleteTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        assertTrue(joinedDAO.delete(sofa));

        verify(entityManager, times(1)).remove(sofa);
    }

    @Test
    void deleteTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> joinedDAO.delete(null));
    }
}