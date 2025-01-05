package com.springboot.filmrentalstore.Repo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.springboot.filmrentalstore.model.Inventory;
import com.springboot.filmrentalstore.repo.InventoryRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class InventoryRepoTest {

    @Mock
    private InventoryRepo inventoryRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByFilm_FilmId() {
        // Arrange
        long filmId = 1L;
        Inventory inventory1 = new Inventory();
        inventory1.setInventoryId(1L);
        //inventory1.setFilm(filmId);

        Inventory inventory2 = new Inventory();
        inventory2.setInventoryId(2L);
       // inventory2.setFilm(filmId);

        List<Inventory> inventories = Arrays.asList(inventory1, inventory2);
        when(inventoryRepo.findByFilm_FilmId(filmId)).thenReturn(inventories);

        // Act
        List<Inventory> result = inventoryRepo.findByFilm_FilmId(filmId);

        // Assert
        assertEquals(2, result.size());
        //assertEquals(filmId, result.get(0).getFilm());
        verify(inventoryRepo, times(1)).findByFilm_FilmId(filmId);
    }

    @Test
    void testFindByStore_StoreId() {
        // Arrange
        Long storeId = 1L;
        Inventory inventory1 = new Inventory();
        inventory1.setInventoryId(1L);
        //inventory1.setStore(storeId);

        Inventory inventory2 = new Inventory();
        inventory2.setInventoryId(2L);
        //inventory2.setStore(storeId);

        List<Inventory> inventories = Arrays.asList(inventory1, inventory2);
        when(inventoryRepo.findByStore_StoreId(storeId)).thenReturn(inventories);

        // Act
        List<Inventory> result = inventoryRepo.findByStore_StoreId(storeId);

        // Assert
        assertEquals(2, result.size());
        //assertEquals(storeId, result.get(0).getStore());
        verify(inventoryRepo, times(1)).findByStore_StoreId(storeId);
    }

    @Test
    void testFindByFilm_FilmIdAndStore_StoreId() {
        // Arrange
        Long filmId = 1L;
        Long storeId = 1L;
        Inventory inventory1 = new Inventory();
        inventory1.setInventoryId(1L);
        //inventory1.setFilm(filmId);
        //inventory1.setStore(storeId);

        List<Inventory> inventories = Arrays.asList(inventory1);
        when(inventoryRepo.findByFilm_FilmIdAndStore_StoreId(filmId, storeId)).thenReturn(inventories);

        // Act
        List<Inventory> result = inventoryRepo.findByFilm_FilmIdAndStore_StoreId(filmId, storeId);

        // Assert
        assertEquals(1, result.size());
        //assertEquals(filmId, result.get(0).getFilm());
//        assertEquals(storeId, result.get(0).getStore());
        verify(inventoryRepo, times(1)).findByFilm_FilmIdAndStore_StoreId(filmId, storeId);
    }
}
