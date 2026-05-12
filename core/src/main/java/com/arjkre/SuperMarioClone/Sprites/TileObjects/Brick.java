package com.arjkre.SuperMarioClone.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.arjkre.SuperMarioClone.Main;
import com.arjkre.SuperMarioClone.Scenes.Hud;
import com.arjkre.SuperMarioClone.Screens.PlayScreen;
import com.arjkre.SuperMarioClone.Sprites.Mario;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(Main.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (mario.isBig()) {
            setCategoryFilter(Main.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            Main.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        Main.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}