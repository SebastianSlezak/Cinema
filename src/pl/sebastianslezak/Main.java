package pl.sebastianslezak;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;

        do {
            System.out.println("Enter the number of rows:");
            rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            columns = scanner.nextInt();
            System.out.println();
        } while (rows <= 0 || columns <= 0);


        char[][] rowsAndCols = new char[rows][columns];
        for (char[] fill : rowsAndCols) {
            Arrays.fill(fill, 'S');
        }

        Cinema cinema = new Cinema(rowsAndCols);

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int choose = scanner.nextInt();

            System.out.println();

            switch (choose) {
                case 1:
                    cinema.printCinema();
                    break;
                case 2:
                    cinema.buyTicket();
                    break;
                case 3:
                    cinema.statistics();
                    break;
                case 0:
                    return;
            }
        }
    }
}
