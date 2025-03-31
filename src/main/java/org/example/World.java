package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 *  Container Class that maintains a list of Tiles for drawing
 *  Provides an interface for adding and creating Tiles
 */
public class World extends JFrame {
    private List<Tile> tiles = new ArrayList<>();

    public void placeTile(int x, int y, String name, Color color, String otherData) {
        TileType type = TileFactory.getTileType(name, color, otherData);
        Tile tile = new Tile(x, y, type);
        tiles.add(tile);
    }

    @Override
    public void paint(Graphics graphics){
        for(Tile tile : tiles){
            tile.draw(graphics);
        }
    }
}
