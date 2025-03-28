package org.example;

import java.awt.*;

/*
 *  Client Code
 *  Draws 1000000 Tiles on the screen semi-randomly
 */
public class App 
{
    static int CANVAS_SIZE_X = 1000;
    static int CANVAS_SIZE_Y = 1000;
    static int TILE_SIZE = 4;
    static int TILE_TYPES = 3;

    public static void main(String[] args){
        World world = new World();
        int previousTileType = 1;

        for (int i = 0; i < CANVAS_SIZE_Y; i++) {
            for (int j = 0; j < CANVAS_SIZE_X; j++) {
                int rand = random(1, TILE_TYPES);
                int chanceForGrass = 33, chanceForSand = 15, chanceForWater = 90;
                int tileChance = random(1, 100);
                boolean decided = false;

                while (!decided) {
                    if (previousTileType == rand && rand == 1 || tileChance <= chanceForSand) {
                        world.placeTile(i + (TILE_SIZE * i), j + (TILE_SIZE * j), "Sand", Color.ORANGE, "Data2");
                        decided = true;
                    } else if (previousTileType == rand && rand == 2 || tileChance <= chanceForGrass) {
                        world.placeTile(i + (TILE_SIZE * i), j + (TILE_SIZE * j), "Grass", Color.GREEN, "Data1");
                        decided = true;
                    } else if (previousTileType == rand && rand == 3 || tileChance <= chanceForWater) {
                        world.placeTile(i + (TILE_SIZE * i), j + (TILE_SIZE * j), "Water", Color.BLUE, "Data3");
                        decided = true;
                    }

                    previousTileType = rand;
                }
            }
        }

        world.setSize(CANVAS_SIZE_X * TILE_SIZE, CANVAS_SIZE_Y * TILE_SIZE);
        world.setVisible(true);

        System.out.println("---------------------");
        System.out.println(CANVAS_SIZE_X * CANVAS_SIZE_Y + " tiles drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tile size (8 bytes) * " + CANVAS_SIZE_X * CANVAS_SIZE_Y);
        System.out.println("+ TileTypes size (~30 bytes) * " + TILE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((CANVAS_SIZE_X * CANVAS_SIZE_Y * 8 + TILE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((CANVAS_SIZE_X * CANVAS_SIZE_Y * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
