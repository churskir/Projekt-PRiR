package com.company.Map;

import com.company.Position;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class MapReader {

    private static BufferedReader bufferedReader = null;
    private static int width;
    private static int height;
    private static Map map;

    private final static char roadChar = 'R';
    private final static char crossingChar = 'C';

    public static Map readMap(String path) {
        try {
            readFile(path);
            readSize();
            map = new Map(width, height);
            readRows();
            return map;
        } catch (Exception e) {
            System.out.println("[APP] Exception while trying to read file " + path);
            e.printStackTrace();
            return null;
        }
    }

    private static void readFile(String path) throws FileNotFoundException{
        File file = new File(path);
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    private static void readSize() throws IOException {
        String line = bufferedReader.readLine();
        List<String> items = Arrays.asList(line.split("\\s* \\s*"));
        assert items.size() == 2;
        height = Integer.parseInt(items.get(0));
        width = Integer.parseInt(items.get(1));
    }

    private static void readRows() throws IOException{
        for (int i = 0; i < height; i++) {
            readRow(i);
        }
    }

    private static void readRow(int rowNumber) throws IOException{
        String line = bufferedReader.readLine();
        MapItem mapItem;
        for (int i = 0; i < width; i++) {
            switch (line.charAt(i)) {
                case roadChar: {
                    mapItem = new Road(new Position(i, rowNumber));
                    break;
                }
                case crossingChar: {
                    mapItem = new Crossing(new Position(i, rowNumber));
                    break;
                }
                default: {
                    mapItem = null;
                    break;
                }
            }
            map.setItem(i, rowNumber, mapItem);
        }
    }
}
