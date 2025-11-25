package io.googlegiggers.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.googlegiggers.Utils.EntityType;

public class Player extends Entity {

    public Player(float x, float y, float speed, int health, int damage, String texture) {
        super(x, y, 32, 32, 1, speed, health, damage, texture, EntityType.PLAYER);
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.texture = texture;
    }

    public void update() {
        sm.draw(getX(), getY(), getWidth(), getHeight(), getTexture());

        if (Gdx.input.isKeyPressed(Input.Keys.W)) this.y += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) this.y -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) this.x -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) this.x += speed;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            em.addEntity(new Bullet(x, y, 16, 16, 10, "bullet"));
        }
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);
    }

    public void onCollide(Entity e) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            e.knockBackInertia = 3.0f;
        }
    }
}
