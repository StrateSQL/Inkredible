package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.BlueprintEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestConfig.class)
@Transactional
class BlueprintDaoTest {

    @Autowired
    private BlueprintDao blueprintDao;

    @Test
    void insert() {
        BlueprintEntity entity = new BlueprintEntity();
        // Set properties of the entity as needed
        BlueprintEntity insertedEntity = blueprintDao.insert(entity);
        assertNotNull(insertedEntity.getBlueprintId());
        // Perform assertions to validate the insertion
    }

    @Test
    void findById() {
        // Insert a test entity first
        BlueprintEntity entity = new BlueprintEntity();
        blueprintDao.insert(entity);

        int entityId = entity.getBlueprintId();
        BlueprintEntity foundEntity = blueprintDao.findById(entityId);
        assertNotNull(foundEntity);
        // Perform assertions to validate the retrieval
    }

    @Test
    void findByKey() {
        // Insert a test entity first
        BlueprintEntity entity = new BlueprintEntity();
        entity.setBlueprintKey(123); // Set a test key
        blueprintDao.insert(entity);

        int keyToFind = 123; // The key you want to find
        BlueprintEntity foundEntity = blueprintDao.findByKey(keyToFind);
        assertNotNull(foundEntity);
        // Perform assertions to validate the retrieval
    }

    @Test
    void findAll() {
        // Insert multiple test entities
        BlueprintEntity entity1 = new BlueprintEntity();
        BlueprintEntity entity2 = new BlueprintEntity();
        blueprintDao.insert(entity1);
        blueprintDao.insert(entity2);

        List<BlueprintEntity> entities = blueprintDao.findAll();
        assertNotNull(entities);
        assertEquals(2, entities.size()); // Adjust the expected count as needed
        // Perform assertions to validate the retrieval
    }


    @Test
    void count() {
        long count = blueprintDao.count();
        // Perform assertions to validate the count
    }
}
