package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point {
    public final float x;
    public final float y;

    private static String COMMA_DELIMITER = ";";


    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static List<List<String>> getPoint(File filLineName) {
        List<List<String>> recordsPoints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filLineName))) {
            String points;
            while ((points = br.readLine()) != null) {
                String[] values = points.split(COMMA_DELIMITER);
                recordsPoints.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (int i=0; i< records.size(); i++) {
//            System.out.println(records.get(i));
//        }
        return recordsPoints;
    }





}