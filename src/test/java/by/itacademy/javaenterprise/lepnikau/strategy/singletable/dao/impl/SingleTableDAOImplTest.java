package by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.impl;

import by.itacademy.javaenterprise.lepnikau.strategy.singletable.dao.SingleTableDAO;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.DeskSingleTable;
import by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity.FurnitureSingleTable;
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
class SingleTableDAOImplTest {
    @Mock
    private EntityTransaction entityTransaction;
    @Mock
    private EntityManager entityManager;
    private SingleTableDAO singleTableDAO;
    private DeskSingleTable desk;

    @BeforeEach
    void beforeEach() {
        singleTableDAO = new SingleTableDAOImpl(entityManager);
        desk = new DeskSingleTable();
        desk.setFurnitureId(1L);
        desk.setModelName("Desk Model");
        desk.setPrice(100.0);
        desk.setForm("Circle");
        desk.setMaterial("Pine");
    }

    @Test
    void saveTest() {

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        FurnitureSingleTable actual = singleTableDAO.save(desk);

        verify(entityManager, times(1)).persist(desk);

        assertNotNull(actual);

        assertEquals(desk, actual);
    }

    @Test
    void saveTestWithEntityNull() {

        assertThrows(IllegalArgumentException.class,
                () -> singleTableDAO.save(null));
    }

    @Test
    void findTest() {
        Long id = 1L;

        when(entityManager.find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(id)))
                .thenReturn(desk);

        assertEquals(desk, singleTableDAO.find(id));

        verify(entityManager).find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(id));
    }

    @Test
    void findTestWithWrongId() {
        Long id = -1L;

        when(entityManager.find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(id)))
                .thenReturn(null);

        assertNull(singleTableDAO.find(-1L));

        verify(entityManager).find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(id));
    }

    @Test
    void updateTest() {

    }

    @Test
    void updateTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> singleTableDAO.update(null));
    }

    @Test
    void deleteTest() {
        Long furnitureId = desk.getFurnitureId();

        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        when(entityManager.find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(furnitureId)))
                .thenReturn(desk);

        assertTrue(singleTableDAO.delete(desk));

        verify(entityManager, times(1))
                .find(Mockito.<Class<FurnitureSingleTable>>any(), Mockito.eq(furnitureId));

        verify(entityManager, times(1)).remove(desk);
    }

    @Test
    void deleteTestWithArgumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> singleTableDAO.delete(null));
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