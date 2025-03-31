package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
 *  TileFactory Class to handle creation of Tile and TileTypes
 *  Maintains a map of <Name, TileType> (Flyweight for Tile Class)
 *  Only creates new instances of TileType when the state given is unique
 */
public class TileFactory {
    static Map<String, TileType> tileTypes = new HashMap<>();

    public static TileType getTileType(String name, Color color, String otherData) {
        TileType result = tileTypes.get(name);
        if(result == null) {
            System.out.println("Registered new tile type with name:\n" + name + ", and color: " + color.toString());
            result = new TileType(name, color, otherData);
            tileTypes.put(name, result);
        }
        return result;
    }
}
