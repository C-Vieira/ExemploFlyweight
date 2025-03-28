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
    static Map<String, TileType> treeTypes = new HashMap<>();

    public static TileType getTreeType(String name, Color color, String otherData) {
        TileType result = treeTypes.get(name);
        if(result == null) {
            System.out.println("Registered new tile type with name: " + name + ", and color: " + color.toString());
            result = new TileType(name, color, otherData);
            treeTypes.put(name, result);
        }
        return result;
    }
}
