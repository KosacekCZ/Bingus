package io.googlegiggers.Entities;

import io.googlegiggers.Managers.EntityManager;
import io.googlegiggers.Managers.SpriteManager;

public class Enemy extends Entity {
    public Enemy(float x, float y, float speed,  int health, int damage, String texture) {
        super(x, y, 32, 32, 1, speed, health, damage, texture);
    }

    public void update() {
        sm.draw(x, y, width, height, texture);

        float dir = (float) (Math.atan2(em.getPlayer().x - x, -(em.getPlayer().y - y)) - (Math.PI / 2));
        this.x += (float) (Math.cos(dir) * speed / 2);
        this.y += (float) (Math.sin(dir) * speed / 2);
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);


    }

    public void onCollide() {
        System.out.println("Kolize");
    }
}
