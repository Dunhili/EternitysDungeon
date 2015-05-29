package com.dunhili.eternitysdungeon.map;

import android.view.MotionEvent;

/**
 * Created by Dunhili on 5/27/2015.
 */
public class MapGenerator {
    private Map map;
    private Tile defaultTile = Tile.PLAINS;
    private Tile currentTile = Tile.PLAINS;

    public MapGenerator() {

    }

    public void createMap(int width, int height) {
        map = new Map(width, height, defaultTile);
    }

    public void clearMap() {

    }

    public void saveMap() {

    }
}
