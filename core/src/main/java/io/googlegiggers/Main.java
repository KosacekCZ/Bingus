package io.googlegiggers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import io.googlegiggers.Managers.EntityManager;
import io.googlegiggers.Managers.SpriteManager;

public class Main extends ApplicationAdapter {
    private SpriteManager sm;
    private EntityManager em;

    @Override
    public void create() {
        sm = SpriteManager.getInstance();
        em = EntityManager.getInstance();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        em.update();
        sm.begin();

        sm.end();
    }

    @Override
    public void dispose() {
        sm.dispose();
    }
}
