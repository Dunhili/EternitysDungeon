package com.dunhili.eternitysdungeon.map;

import android.media.Image;

/**
 * Created by Dunhili on 5/24/2015.
 */
public enum Tile {
    NONE("None", 0, true),
    PLAINS("Plains", 1, true),
    FOREST("Forest", 2, true),
    WATER("Water", 3, false),
    SHALLOW_WATER("Shallow Water", 1, true),
    WALL("Wall", 1, false),
    CRACKED_WALL("Cracked Wall", 1, false),
    DOOR("Door", 1, true),
    STAIRS("Stairs", 1, true),
    PILLAR("Pillar", 1, false),
    BRIDGE("Bridge", 1, true),
    DIRT_ROAD("Dirt Road", 1, true),
    STONE_ROAD("Stone Road", 1, true),
    STONE_FLOOR("Stone Floor", 1, true),
    TILE_FLOOR("Tile Floor", 1, true),
    WOOD_FLOOR("Wood Floor", 1, true);

    private static final String TAG = "Tile";

    private Image appearance;
    private String name;
    private int moveCost = 1;
    private boolean passable = true;

    private Tile(String name, int moveCost, boolean passable) {
        this.name = name;
        this.moveCost = moveCost;
        this.passable = passable;

        //appearance = new Image(name.toLowerCase().replaceAll(" ", "-")): TODO
    }

    public Image getAppearance() {
        return appearance;
    }

    public String getName() {
        return name;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public boolean isPassable() {
        return passable;
    }
}
