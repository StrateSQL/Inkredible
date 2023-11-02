package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.SizeEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SizeDao {

    private final Map<Integer, SizeEntity> sizeStore = new ConcurrentHashMap<>();
    private static int idCounter = 0;

    public SizeEntity insert(SizeEntity entity) {
        int id = idCounter++;
        entity.setSizeId(id);
        sizeStore.put(id, entity);
        return entity;
    }

    public SizeEntity findById(int id) {
        return sizeStore.get(id);
    }

    public SizeEntity findByKey(String key) {
        return sizeStore.values().stream()
                .filter(sizeEntity -> key.equals(sizeEntity.getSize()))
                .findFirst()
                .orElse(null);
    }

    public List<SizeEntity> findAll() {
        return new ArrayList<>(sizeStore.values());
    }

    public SizeEntity update(SizeEntity entity) {
        int id = entity.getSizeId();
        if (sizeStore.containsKey(id)) {
            sizeStore.put(id, entity);
            return entity;
        }
        return null;
    }

    public void deleteById(int id) {
        sizeStore.remove(id);
    }

    public void delete(SizeEntity entity) {
        sizeStore.values().removeIf(e -> e.getSizeId() == entity.getSizeId());
    }

    public boolean existsById(int id) {
        return sizeStore.containsKey(id);
    }

    public boolean exists(SizeEntity entity) {
        return sizeStore.containsValue(entity);
    }

    public long count() {
        return sizeStore.size();
    }
}
