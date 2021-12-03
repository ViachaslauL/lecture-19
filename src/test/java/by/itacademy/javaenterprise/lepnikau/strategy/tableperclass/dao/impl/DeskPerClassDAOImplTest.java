package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.dao.PerClassDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity.DeskPerClass;
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
class DeskPerClassDAOImplTest {

    @Mock
    private EntityTransaction entityTransaction;
    @Mock
    private EntityManager entityManager;
    private PerClassDAO<DeskPerClass> perClassDAO;
    private DeskPerClass desk;

    @BeforeEach
    void beforeEach() {
        perClassDAO = new DeskPerClassDAOImpl(entityManager);
        desk = new DeskPerClass();
        desk.setFurnitureId(1L);
        desk.setModelName("Desk Model");
        desk.setPrice(100.0);
        desk.setForm("Circle");
        desk.setMaterial("Pine");
    }

    @Test
    void saveTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        DeskPerClass actual = perClassDAO.save(desk);

        verify(entityManager, times(1)).persist(desk);

        assertNotNull(actual);

        assertEquals(desk, actual);
    }

    @Test
    void saveTestWithEntityNull() {

        assertThrows(IllegalArgumentException.class,
                () -> perClassDAO.save(null));
    }

    @Test
    void findTest() {
        Long id = 1L;

        when(entityManager.find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(id)))
                .thenReturn(desk);

        assertEquals(desk, perClassDAO.find(id));

        verify(entityManager).find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(id));
    }

    @Test
    void findTestWithWrongId() {
        Long id = -1L;

        when(entityManager.find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(id)))
                .thenReturn(null);

        assertNull(perClassDAO.find(-1L));

        verify(entityManager).find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(id));
    }

    @Test
    void update() {
    }

    @Test
    void updateTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> perClassDAO.update(null));
    }

    @Test
    void deleteTest() {
        Long furnitureId = desk.getFurnitureId();

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        when(entityManager.find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(furnitureId)))
                .thenReturn(desk);

        assertTrue(perClassDAO.delete(desk));

        verify(entityManager, times(1))
                .find(Mockito.<Class<DeskPerClass>>any(), Mockito.eq(furnitureId));

        verify(entityManager, times(1)).remove(desk);
    }

    @Test
    void deleteTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> perClassDAO.delete(null));
    }

    @Test
    void deleteTestNonExistentSofa() {
        /*Long id = -1L;
        sofa.setFurnitureId(id);

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        *//*when(entityManager.find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(-1L)))
                .thenReturn(null);*//*

        assertFalse(joinedDAO.delete(sofa));

        verify(entityManager, times(1))
                .find(Mockito.<Class<FurnitureJoined>>any(), Mockito.eq(id));

        verify(entityManager, never()).remove(sofa);*/
    }
}