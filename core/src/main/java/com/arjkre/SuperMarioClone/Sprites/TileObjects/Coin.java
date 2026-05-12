package com.arjkre.SuperMarioClone.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import com.arjkre.SuperMarioClone.Main;
import com.arjkre.SuperMarioClone.Scenes.Hud;
import com.arjkre.SuperMarioClone.Screens.PlayScreen;
import com.arjkre.SuperMarioClone.Sprites.Items.ItemDef;
import com.arjkre.SuperMarioClone.Sprites.Items.Mushroom;
import com.arjkre.SuperMarioClone.Sprites.Mario;

public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, MapObject object) {
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(Main.COIN_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (getCell().getTile().getId() == BLANK_COIN)
            Main.manager.get("audio/sounds/bump.wav", Sound.class).play();
        else {
            if (object.getProperties().containsKey("mushroom")) {
                screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / Main.PPM),
                        Mushroom.class));
                Main.manager.get("audio/sounds/powerup_spawn.wav", Sound.class).play();
            } else
                Main.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            Hud.addScore(100);
        }
    }
}