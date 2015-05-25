package com.dunhili.eternitysdungeon.map;

/**
 * Created by Dunhili on 5/24/2015.
 */
public class Position {
    private static final String TAG = "Position";

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position moveUp() {
        return new Position(x, y + 1);
    }

    public Position moveDown() {
        return new Position(x, y - 1);
    }

    public Position moveLeft() {
        return new Position(x - 1, y);
    }

    public Position moveRight() { return new Position(x + 1, y); }
}
