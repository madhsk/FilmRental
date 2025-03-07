package com.springboot.filmrentalstore.Repo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.springboot.filmrentalstore.model.Store;
import com.springboot.filmrentalstore.repo.StaffRepo;
import com.springboot.filmrentalstore.repo.StoreRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class StoreRepoTest {

    @Mock
    private StoreRepo storeRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStore() {
        // Arrange
        Store store = new Store();
        store.setStoreId(1L);
       // store.setStoreName("Main Store");

        when(storeRepo.save(store)).thenReturn(store);

        // Act
        Store savedStore = storeRepo.save(store);

        // Assert
        assertNotNull(savedStore);
        assertEquals(1L, savedStore.getStoreId());
//        assertEquals("Main Store", savedStore.getStoreName());
        verify(storeRepo, times(1)).save(store);
    }

    @Test
    void testFindById() {
        // Arrange
        Long storeId = 1L;
        Store store = new Store();
        store.setStoreId(storeId);
        //store.setStoreId("Main Store");

        when(storeRepo.findById(storeId)).thenReturn(Optional.of(store));

        // Act
        Optional<Store> foundStore = storeRepo.findById(storeId);

        // Assert
        assertTrue(foundStore.isPresent());
        assertEquals(storeId, foundStore.get().getStoreId());
        //assertEquals("Main Store", foundStore.get().getStoreName());
        verify(storeRepo, times(1)).findById(storeId);
    }

    @Test
    void testFindById_NotFound() {
        // Arrange
        Long storeId = 1L;

        when(storeRepo.findById(storeId)).thenReturn(Optional.empty());

        // Act
        Optional<Store> foundStore = storeRepo.findById(storeId);

        // Assert
        assertFalse(foundStore.isPresent());
        verify(storeRepo, times(1)).findById(storeId);
    }

    @Test
    void testDeleteStore() {
        // Arrange
        Store store = new Store();
        store.setStoreId(1L);
        //store.setStoreId("Main Store");

        // Act
        storeRepo.delete(store);

        // Assert
        verify(storeRepo, times(1)).delete(store);
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long storeId = 1L;

        // Act
        storeRepo.deleteById(storeId);

        // Assert
        verify(storeRepo, times(1)).deleteById(storeId);
    }
}
