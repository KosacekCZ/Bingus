package io.googlegiggers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import io.googlegiggers.Entities.Enemy;
import io.googlegiggers.Entities.Player;
import io.googlegiggers.Managers.EntityManager;
import io.googlegiggers.Managers.SpriteManager;
import io.googlegiggers.Managers.TextureManager;

public class Main extends ApplicationAdapter {
    private SpriteManager sm;
    private EntityManager em;
    private TextureManager tm;

    @Override
    public void create() {
        tm = new TextureManager();
        sm = SpriteManager.getInstance();
        em = EntityManager.getInstance();

        em.addPlayer(new Player(400, 400, 10, 100, 10, "amongas"));
        em.addEntity(new Enemy(200, 200, 5, 100, 10,"mogus"));
        tm.loadTextures();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        sm.begin();
        em.update();

        // System.out.println("X: " + Gdx.input.getX() + "\nY: " + Gdx.input.getY());

        sm.end();
    }

    @Override
    public void dispose() {
        sm.dispose();
    }
}
