package com.dunhili.eternitysdungeon.map;

import com.dunhili.eternitysdungeon.utils.Logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dunhili on 5/24/2015.
 */
public class Map {
    private static final String TAG = "Map";

    private Tile[][] tiles;
    private int width;
    private int height;
    private List<Character> enemies = new ArrayList<>();
    private List<Character> friendlyUnits = new ArrayList<>();
    private List<Character> neutralUnits = new ArrayList<>();

    /**
     * Creates a new Map of size width x width.
     * @param width length dimension of the map
     */
    public Map(int width) {
        this(width, width);
    }

    /**
     * Creates a new Map of size width x height.
     * @param width left-right dimension of the map
     * @param height top-bottom dimension of the map
     */
    public Map(int width, int height) {
        this(width, height, Tile.NONE);
    }

    /**
     * Creates a new Map of size width x height with the given tile as the default.
     * @param width left-right dimension of the map
     * @param height top-bottom dimension of the map
     * @param defaultTile initial starting tile for the map
     */
    public Map(int width, int height, Tile defaultTile) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        Logging.debug(TAG, "Created map with size : [" + width + " x " + height + "]");

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                setTileAt(defaultTile, i, j);
            }
        }
    }

    public Map(String[] mapTiles) {

    }

    public int getWidth() {
        Logging.debug(TAG, "getWidth()");
        return width;
    }

    public int getHeight() {
        Logging.debug(TAG, "getHeight()");
        return height;
    }

    public void setTileAt(Tile tile, Position position) {
        Logging.debug(TAG, "setTileAt()");
        setTileAt(tile, position.getX(), position.getY());
    }

    public void setTileAt(Tile tile, int x, int y) {
        Logging.debug(TAG, "setTileAt(" + tile + ", " + "[" + x + "," + y + "])");
        if (inBounds(x, y)) {
            tiles[x][y] = tile;
        } else {
            Logging.debug(TAG, "Out of bounds at : " + "(" + x + "," + y + ")");
        }
    }

    public Tile getTileAt(Position position) {
        return getTileAt(position.getX(), position.getY());
    }

    public Tile getTileAt(int x, int y) {
        Logging.debug(TAG, "getTileAt([" + x + "," + y + "]");
        return (inBounds(x, y)) ? tiles[x][y] : Tile.NONE;
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y <= tiles[0].length;
    }
}
