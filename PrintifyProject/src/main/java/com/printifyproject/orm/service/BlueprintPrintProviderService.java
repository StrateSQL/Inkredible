package com.printifyproject.orm.service;

import com.printifyproject.orm.dao.BlueprintPrintProviderDao;
import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.BlueprintPrintProviderEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing BlueprintPrintProviderEntity instances.
 */
@Service
@Transactional
public class BlueprintPrintProviderService {

    @Autowired
    private BlueprintPrintProviderDao dao;

    /**
     * Add a list of BlueprintPrintProviderEntity instances.
     *
     * @param entities The list of BlueprintPrintProviderEntity instances to add.
     */
    public void add(List<BlueprintPrintProviderEntity> entities) {
        for (BlueprintPrintProviderEntity entity : entities) {
            add(entity);
        }
    }

    /**
     * Add or update a BlueprintPrintProviderEntity instance.
     *
     * @param entity The BlueprintPrintProviderEntity instance to add or update.
     * @return The added or updated BlueprintPrintProviderEntity instance.
     */
    public BlueprintPrintProviderEntity add(BlueprintPrintProviderEntity entity) {
        // Your logic for adding or updating the entity here
        // You can check if the entity already exists and update it, or insert a new one
        // For example:
        BlueprintPrintProviderEntity existingEntity = dao.findById(entity.getBlueprintPrintProviderId());

        if (existingEntity != null) {
            copyState(entity, existingEntity);
            return existingEntity;
        } else {
            dao.insert(entity);
            return entity;
        }
    }

    private void copyState(BlueprintPrintProviderEntity source, BlueprintPrintProviderEntity target) {
        // Copy the state from the source entity to the target entity as needed
        // For example:
        target.setBlueprint(source.getBlueprint());
        target.setPrintProvider(source.getPrintProvider());
    }

    /**
     * Find a BlueprintPrintProviderEntity by its ID.
     *
     * @param id The ID of the BlueprintPrintProviderEntity to find.
     * @return The found BlueprintPrintProviderEntity or null if not found.
     */
    public BlueprintPrintProviderEntity findById(int id) {
        return dao.findById(id);
    }

    public List<BlueprintPrintProviderEntity> findByKeys(
            BlueprintEntity blueprint, PrintProviderEntity printProvider) {
        return dao.findByKeys(blueprint, printProvider);
    }

    /**
     * Find all BlueprintPrintProviderEntity instances.
     *
     * @return A list of all BlueprintPrintProviderEntity instances.
     */
    public List<BlueprintPrintProviderEntity> findAll() {
        return dao.findAll();
    }

    /**
     * Update a BlueprintPrintProviderEntity instance.
     *
     * @param entity The BlueprintPrintProviderEntity instance to update.
     * @return The updated BlueprintPrintProviderEntity instance.
     */
    public BlueprintPrintProviderEntity update(BlueprintPrintProviderEntity entity) {
        return add(entity);
    }

    /**
     * Delete a BlueprintPrintProviderEntity by its ID.
     *
     * @param id The ID of the BlueprintPrintProviderEntity to delete.
     */
    public void delete(int id) {
        dao.deleteById(id);
    }

    /**
     * Delete a BlueprintPrintProviderEntity.
     *
     * @param entity The BlueprintPrintProviderEntity instance to delete.
     */
    public void delete(BlueprintPrintProviderEntity entity) {
        dao.delete(entity);
    }

    /**
     * Check if a BlueprintPrintProviderEntity with the given ID exists.
     *
     * @param id The ID of the BlueprintPrintProviderEntity to check.
     * @return True if the entity exists, false otherwise.
     */
    public boolean exists(int id) {
        return dao.existsById(id);
    }

    /**
     * Check if a BlueprintPrintProviderEntity exists.
     *
     * @param entity The BlueprintPrintProviderEntity instance to check.
     * @return True if the entity exists, false otherwise.
     */
    public boolean exists(BlueprintPrintProviderEntity entity) {
        return dao.exists(entity);
    }

    /**
     * Get the count of BlueprintPrintProviderEntity instances.
     *
     * @return The count of BlueprintPrintProviderEntity instances.
     */
    public long count() {
        return dao.count();
    }
}
