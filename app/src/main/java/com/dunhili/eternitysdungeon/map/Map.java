package com.dunhili.eternitysdungeon.map;

/**
 * Created by Dunhili on 5/24/2015.
 */
public class Map {
    private static final String TAG = "Map";

    private Tile[][] tiles;

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
        tiles = new Tile[width][height];
    }
}
