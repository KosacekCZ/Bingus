package io.googlegiggers.Entities;

import io.googlegiggers.Utils.EntityType;

public class Enemy extends Entity {
    public Enemy(float x, float y, float speed,  int health, int damage, String texture) {
        super(x, y, 32, 32, 1, speed, health, damage, texture, EntityType.ENEMY);
    }

    public void update() {
        sm.draw(x, y, width, height, texture);
        Player p = em.getPlayer();
        float dx = p.getX() - x;
        float dy = p.getY() - y;

        dir = (float) (Math.atan2(p.x - x, -(p.y - y)) - (Math.PI / 2));
        if (Math.abs(dx) >= 16f)  this.x += (float) (Math.cos(dir) * speed / 2);
        if (Math.abs(dy) >= 16f) this.y += (float) (Math.sin(dir) * speed / 2);
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);

        knockback();
        if (health <= 0) destroy();
    }

    public void onCollide(Entity e) {

    }
}
