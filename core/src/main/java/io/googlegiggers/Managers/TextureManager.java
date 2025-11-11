package io.googlegiggers.Managers;

import java.io.File;

public class TextureManager {
    private static TextureManager instance;

    public static TextureManager getInstance() {
        if (instance == null) {
            instance = new TextureManager();
        }
        return instance;
    }

    public TextureManager () {
        loadTextures();
    }

    SpriteManager sm = SpriteManager.getInstance();

    private void loadTextures() {
        File folder = new File("assets/");
        File[] subfolders = folder.listFiles();
        for (File sub : subfolders) {
            File[] files = sub.listFiles();
            for (File img : files) {
                sm.loadSprite(img.getName().replace(".png", "").replace(".gif", ""), img.getPath());
            }
        }
    }
}
