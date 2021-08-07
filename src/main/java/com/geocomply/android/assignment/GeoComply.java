package com.geocomply.android.assignment;

import com.geocomply.android.assignment.utils.InputParser;

import java.util.Scanner;

public class GeoComply {
    public static void main(String[] arg) {

        final InputParser parser = new InputParser();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input:\t");
        while (scanner.hasNextLine()){
            System.out.println("Return :\n" + parser.getData(scanner.nextLine()).toString());
            System.out.println("---------------------------------");
            System.out.print("\nInput:\t");
        }
    }
}
