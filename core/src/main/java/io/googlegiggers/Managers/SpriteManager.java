package io.googlegiggers.Managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.googlegiggers.Managers.TextureManager;

import java.util.HashMap;

public class SpriteManager {
    private static SpriteManager instance;
    private SpriteBatch batch;
    private TextureManager tm;

    HashMap<String, Texture> textures;


    public static SpriteManager getInstance(){
        if(instance == null){
            instance = new SpriteManager();
        }
        return instance;
    }

    private SpriteManager(){
        batch = new SpriteBatch();
        textures = new HashMap<>();
        tm = TextureManager.getInstance();
    }

    public void begin() {
        batch.begin();
    }

    public void end() {
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }

    public void loadSprite(String name, String path) {
        textures.put(name, new Texture(path));
    }
}
