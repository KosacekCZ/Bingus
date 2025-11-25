package io.googlegiggers.Entities;

import com.badlogic.gdx.Gdx;
import io.googlegiggers.Utils.EntityType;

public class Bullet extends Entity{

    public Bullet(float x, float y, float width, float height, int damage, String texture) {
        super(x, y, width, height, texture, EntityType.BULLET);
        dir = (float) (Math.atan2(Gdx.input.getX() - x, -((Gdx.graphics.getHeight() - Gdx.input.getY()) - y)) - (Math.PI / 2));
        speed = 20;
        this.damage = damage;
    }

    @Override
    public void update() {
        this.x += (float) (Math.cos(dir) * speed);
        this.y += (float) (Math.sin(dir) * speed);
        sm.draw(x, y, getWidth(), getHeight(), texture);
    }

    @Override
    public void onCollide(Entity e) {
       if (e.type != EntityType.PLAYER) {
           e.health -= this.damage;
           this.isDestroyed = true;
       }
    }
}
