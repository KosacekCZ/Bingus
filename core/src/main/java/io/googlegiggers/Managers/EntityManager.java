package io.googlegiggers.Managers;

import io.googlegiggers.Entities.Entity;
import io.googlegiggers.Entities.Player;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static EntityManager instance;
    public static EntityManager getInstance() {
        if (instance == null) instance = new EntityManager();
        return instance;
    }

    private Player player;
    private List<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void addPlayer(Player p) {
        this.player = p;
        addEntity(p);
    }

    public Player getPlayer() {
        return player;
    }

    public void update() {
        for (Entity e: entities) {
            e.update();

            for (Entity e2: entities) {
                if (!e.equals(e2)) {
                    if (e.getSprite().getBoundingRectangle().overlaps(e2.getSprite().getBoundingRectangle())) {
                        e.onCollide();
                        e2.onCollide();
                    }
                }
            }
        }
    }

}
