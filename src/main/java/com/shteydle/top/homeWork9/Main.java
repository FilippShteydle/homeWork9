package com.shteydle.top.homeWork9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Task04.printMatrix(Task04.getMatrix(5));
        //Task04.getDirection(Task04.matrix);
        //Task05.killDragon(1800, 70, 12, 10);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Напишите строку: ");
        String str = scanner.nextLine();
        System.out.println(Task06.controlBracket(str));
    }
}