package com.dunhili.eternitysdungeon.map;

import android.view.MotionEvent;

import com.dunhili.eternitysdungeon.utils.Logging;

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

    public void setTileAt(Tile tile, Position position) {
        map.setTileAt(tile, position);
    }

    public void setTileAt(Tile tile, int x, int y) {
        map.setTileAt(tile, x, y);
    }

    public Tile getTileAt(Position position) {
        return map.getTileAt(position);
    }

    public Tile getTileAt(int x, int y) {
        return map.getTileAt(x, y);
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
