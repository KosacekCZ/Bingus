package io.googlegiggers.Managers;

import io.googlegiggers.Entities.Entity;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static EntityManager instance;
    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private List<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void update() {
        for (Entity e: entities) e.update();
    }
}
