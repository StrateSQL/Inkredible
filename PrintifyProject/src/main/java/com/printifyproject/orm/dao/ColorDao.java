package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.ColorEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ColorDao {

    private final Map<Integer, ColorEntity> colorStore = new ConcurrentHashMap<>();
    private static int idCounter = 0;

    public ColorEntity insert(ColorEntity entity) {
        int id = idCounter++;
        entity.setColorId(id);
        colorStore.put(id, entity);
        return entity;
    }

    public ColorEntity findById(int id) {
        return colorStore.get(id);
    }

    public ColorEntity findByKey(String key) {
        return colorStore.values().stream()
                .filter(colorEntity -> key.equals(colorEntity.getColor()))
                .findFirst()
                .orElse(null);
    }

    public List<ColorEntity> findAll() {
        return new ArrayList<>(colorStore.values());
    }

    public ColorEntity update(ColorEntity entity) {
        int id = entity.getColorId();
        if (colorStore.containsKey(id)) {
            colorStore.put(id, entity);
            return entity;
        }
        return null;
    }

    public void deleteById(int id) {
        colorStore.remove(id);
    }

    public void delete(ColorEntity entity) {
        colorStore.values().removeIf(e -> e.getColorId() == entity.getColorId());
    }

    public boolean existsById(int id) {
        return colorStore.containsKey(id);
    }

    public boolean exists(ColorEntity entity) {
        return colorStore.containsValue(entity);
    }

    public long count() {
        return colorStore.size();
    }
}
