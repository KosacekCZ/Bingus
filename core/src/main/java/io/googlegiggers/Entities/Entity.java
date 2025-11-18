package io.googlegiggers.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import io.googlegiggers.Managers.EntityManager;
import io.googlegiggers.Managers.SpriteManager;

public abstract class Entity {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float scale;
    protected float speed;
    protected int health;
    protected int damage;
    protected String texture;
    protected boolean isDestroy;
    protected Sprite sprite;

    protected final SpriteManager sm;
    protected final EntityManager em;

    public Entity(float x, float y, float width, float height, float scale, float speed , int health, int damage, String texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.texture = texture;
        isDestroy = false;
        this.sprite = new Sprite();
        sprite.setPosition(x, y);
        sprite.setSize(width, height);

        sm = SpriteManager.getInstance();
        em = EntityManager.getInstance();
    }

    public Entity(float x, float y, float width, float height, String texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        isDestroy = false;
        this.sprite = new Sprite();
        sprite.setPosition(x, y);
        sprite.setSize(width, height);
        // TODO: sprite.setOrigin();

        sm = SpriteManager.getInstance();
        em = EntityManager.getInstance();
    }

    public abstract void update();

    public abstract void onCollide();

    public void Destroy() {
        this.isDestroy = true;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
