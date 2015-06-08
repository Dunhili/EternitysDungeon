package com.dunhili.eternitysdungeon.map;

import android.view.MotionEvent;

/**
 * Created by Dunhili on 5/27/2015.
 */
public class MapGenerator {
    private static final String TAG = "MapGenerator";

    private Map map;
    private Tile defaultTile = Tile.PLAINS;
    private Tile currentTile = Tile.PLAINS;

    public MapGenerator() {
        this(10, 10);
    }

    public MapGenerator(int width, int height) {
        createMap(width, height);
    }

    public Map getMap() {
        return map;
    }

    public void createMap(int width, int height) {
        map = new Map(width, height, defaultTile);
    }

    public void clearMap() {
        createMap(map.getWidth(), map.getHeight());
    }

    public void saveMap() {

    }

    public Tile getDefaultTile() {
        return defaultTile;
    }

    public void setDefaultTile(Tile defaultTile) {
        this.defaultTile = defaultTile;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }
}
