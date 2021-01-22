package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        File fileLineName = new File("D:\\projekty\\yanosik\\lines.csv");
        File filePointName = new File("D:\\projekty\\yanosik\\points.csv");

        List<List<String>> line = Line.getLine(fileLineName);
        //   line.forEach(element -> System.out.println(element));

        System.out.println("-----------------------");

        List<List<String>> points = Point.getPoint(filePointName);
        //   points.forEach(element -> System.out.println(element));

        System.out.println("Wartość 3 indeksu każdego wiersza pliku point.csv?");
//
//        ArrayList arrayIdPoints = new ArrayList();
//        for (int i = 0; i < points.size(); i++) {
//            for (int j = 2; j <= 2; j++) {
//                System.out.println(points.get(i).get(j));
//                arrayIdPoints.add(points.get(i).get(j));
//
//            }
//        }
//        System.out.println(arrayIdPoints);

//        System.out.println("--------------- pętla dla lines.csv");
//        for (int i = 0; i < line.size(); i++) {
//            for (int j = 1; j <= 1; j++) {
//                System.out.println(line.get(i).get(j));
//            }
//        }
        System.out.println("-----------------------porównanie z line.csv");

        for(int i=0; i<line.size(); i++){
            List<List<Point>> newList = new ArrayList<>();
            for(int j=0; j < points.size(); j++) {
                var x = Long.parseLong(points.get(j).get(0));
                var y = Long.parseLong(points.get(j).get(1));
                var tmpIndex = Long.parseLong(points.get(j).get(2));
                if (i == tmpIndex) {
                    Point newPoint = new Point(x, y);
                    System.out.print(x +" ");
                    System.out.print(y + " ");
                    System.out.println();
                    System.out.println(tmpIndex);
                    newList.add(Arrays.asList(newPoint));
                } else {

                };
           };

         Line newLine = new Line(newList, Boolean.parseBoolean(line.get(i).get(1)));

         System.out.println(newLine.toString());
        }

    }
}











