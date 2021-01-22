package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {

    private static final String COMMA_DELIMITER = ";";
    public List<Point> points;
    public final boolean someFlag;

    public Line(List<Point> points, boolean someFlag) {
        this.points = points;
        this.someFlag = someFlag;
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean isSomeFlag() {
        return someFlag;
    }

    public static List<List<String>> getLine(File filLineName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filLineName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                ", someFlag=" + someFlag +
                '}';
    }
}