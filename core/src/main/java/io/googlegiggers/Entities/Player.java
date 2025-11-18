package io.googlegiggers.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.googlegiggers.Managers.SpriteManager;

public class Player extends Entity {
    private SpriteManager sm;

    public Player() {
        super(100, 100, 32, 32, 1.0f, 10, 100, 10, "mogus");
        sm = SpriteManager.getInstance();
    }

    public void update() {
        sm.draw(getX(), getY(), getWidth(), getHeight(), getTexture());

        if (Gdx.input.isKeyPressed(Input.Keys.W)) this.y += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) this.y -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) this.x -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) this.x += speed;
    }

    public void onCollide() {

    }
}
