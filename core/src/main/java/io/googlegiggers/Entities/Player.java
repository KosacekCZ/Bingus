package io.googlegiggers.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {

    public Player(float x, float y, float speed, int health, int damage, String texture) {
        super(x, y, 32, 32, 1, speed, health, damage, texture);
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
        this.sprite.setX(this.x);
        this.sprite.setY(this.y);
    }

    public void onCollide() {
        System.out.println("Kolizze");
    }
}
