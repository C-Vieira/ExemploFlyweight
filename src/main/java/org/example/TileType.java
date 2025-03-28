package org.example;

import java.awt.*;

/*
 *  Intrinsic State for the Tile Class
 *  To be used as a Flyweight together with a Factory
 */
public class TileType {
    private String name;
    private Color color;
    private String otherData;

    public TileType(String name, Color color, String otherData) {
        this.name = name;
        this.color = color;
        this.otherData = otherData;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, 5, 5);
    }
}
