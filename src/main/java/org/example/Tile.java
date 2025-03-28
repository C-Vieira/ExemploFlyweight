package org.example;

import java.awt.*;

/*
 *  Topmost representation for a Tile object
 *  Contains mutable x,y position data for a Tile
 *  And an immutable "shared" state TileType (Flyweight)
 */
public class Tile {
    // Extrinsic State
    private int x;
    private int y;

    // Intrinsic State --> Flyweight
    private TileType type;

    public Tile(int x, int y, TileType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g){
        type.draw(g, x, y);
    }
}
