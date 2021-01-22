package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {


    private static final Object COMMA_DELIMITER = "\\n";

    public static void main(String[] args) throws IOException {
        File fileLineName = new File("D:\\projekty\\yanosik\\lines.csv");
        File filePointName = new File("D:\\projekty\\yanosik\\points.csv");

        //read csv files
        List<List<String>> line = Line.getLine(fileLineName);
        List<List<String>> points = Point.getPoints(filePointName);

        //creat a list od Lines with compare to line.csv
        List<Line> listLines = new ArrayList<>();
        for (int i = 0; i < line.size(); i++) {
            List<Point> newList = new ArrayList<>();

            for (int j = 0; j < points.size(); j++) {
                var x = Long.parseLong(points.get(j).get(0));
                var y = Long.parseLong(points.get(j).get(1));
                var tmpIndex = Long.parseLong(points.get(j).get(2));
                if (i == tmpIndex) {
                    Point newPoint = new Point(x, y);
                    newList.add(newPoint);
                }
            }
            listLines.add(new Line(newList, Boolean.parseBoolean(line.get(i).get(1))));
        }

        //Save to list of lines with someFlag = true to file
        File filePath = new File("D:\\projekty\\yanosik\\out.txt");
        DataOutputStream outputStream = null;
        for (int i = 0; i < listLines.size(); i++) {
            if (listLines.get(i).someFlag == true) {
                String tmpListLine = String.valueOf(listLines.get(i));
                String newline = System.getProperty("line.separator");
                try {
                    outputStream = new DataOutputStream(new FileOutputStream(filePath, true));
                    outputStream.writeUTF(tmpListLine);
                    outputStream.writeUTF(newline);
                    System.out.println("Dla: " + i + " dodano " + tmpListLine);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            }
        }

        //read data from file saved in 44-62 lines
        List<List<String>> lineNew = Line.getLine(filePath);
        System.out.println("Z pliku odczytano: " + lineNew);
    }
}












