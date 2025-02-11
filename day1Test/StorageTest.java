package com.capgeminiTrainingPrograms.week4.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class StorageTest {
    @Test
    void testAddAndRetriveElectronics(){
        Storage<Electronices> electronicesStorage=new Storage<>();
        Electronices laptop = new Electronices( "Laptop", "Dell");
        electronicesStorage.addItems(laptop);

        Electronices retrieved = electronicesStorage.getItem(0);
        assertNotNull(retrieved);
        assertEquals("Laptop",retrieved.getName());

    }
    @Test
    void testGetAllItems() {
        Storage<Furniture> furnitureStorage = new Storage<>();
        Furniture chair = new Furniture("Chair", "Wood");
        Furniture table = new Furniture("Table", "Metal");

        furnitureStorage.addItems(chair);
        furnitureStorage.addItems(table);

        List<Furniture> items = furnitureStorage.getallItems();
        assertEquals(2, items.size());
        assertEquals("Chair", items.get(0).getName());
        assertEquals("Table", items.get(1).getName());
    }

    @Test
    void testDisplayAllItems() {
        Storage<Electronices> electronicsStorage = new Storage<>();
        electronicsStorage.addItems(new Electronices("Laptop", "HP"));
        electronicsStorage.addItems(new Electronices("Smartphone", "Apple"));

        assertDoesNotThrow(() -> Warehouseutils.displayAllItems(electronicsStorage.getallItems()));
    }

}