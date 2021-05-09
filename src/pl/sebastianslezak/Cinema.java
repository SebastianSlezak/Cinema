package pl.sebastianslezak;

import java.util.Scanner;

public class Cinema {

    private int tickets = 0;
    private int currentIncome = 0;
    private int totalIncome = 0;
    private int row = 0;
    private int seatInRow = 0;
    private final char[][] rowsAndCols;

    public void printCinema() {

        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < rowsAndCols.length; i++) {
            System.out.print(i + 1 + " ");
        }

        System.out.println();

        for (int i = 0; i < rowsAndCols.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < rowsAndCols[i].length; j++) {
                System.out.print(rowsAndCols[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void statistics() {
        double percentage = (double) tickets / (rowsAndCols.length * rowsAndCols[0].length) * 100;
        System.out.printf("Number of purchased tickets: %d\n", getTickets());
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", getCurrentIncome());
        System.out.printf("Total income: $%d\n\n", totalIncome());
    }

    public int totalIncome() {
        int seats = rowsAndCols.length * rowsAndCols[0].length;
        int total;
        int rowSplit;

        if (rowsAndCols[0].length > 0) {
            if (seats <= 60) {
                total = 10;
                this.totalIncome = seats * total;
            } else {
                if (rowsAndCols.length % 2 == 0) {
                    this.totalIncome = seats / 2 * 10;
                    this.totalIncome += (seats / 2 * 8);
                } else {
                    rowSplit = rowsAndCols.length / 2;
                    this.totalIncome = rowSplit * rowsAndCols[0].length * 10;
                    this.totalIncome += ((seats - (rowSplit * rowsAndCols[0].length)) * 8);
                }
            }
        }
        return totalIncome;
    }

    public void buyTicket() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a row number:");
                setRow(scanner.nextInt());
                System.out.println("Enter a seat number in that row:");
                setSeatInRow(scanner.nextInt());


                System.out.println();

                if (rowsAndCols[row - 1][seatInRow - 1] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    rowsAndCols[row - 1][seatInRow - 1] = 'B';

                    int seats = rowsAndCols.length * rowsAndCols[0].length;
                    int total;
                    int rowSplit;

                    if (rowsAndCols[0].length > 0) {
                        if (seats <= 60) {
                            total = 10;
                        } else {
                            if (rowsAndCols.length % 2 == 0) {
                                if (row > rowsAndCols.length / 2) {
                                    total = 8;
                                } else {
                                    total = 10;
                                }
                            } else {
                                rowSplit = rowsAndCols.length / 2;
                                if (row > rowSplit) {
                                    total = 8;
                                } else {
                                    total = 10;
                                }
                            }
                        }
                        this.currentIncome += total;
                        System.out.printf("Ticket price: $%d\n\n", total);
                        break;
                    }
                }
                System.out.println();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
                System.out.println();
            }
        }
        this.tickets += 1;
    }

    public int getTickets() {
        return tickets;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatInRow(int seatInRow) {
        this.seatInRow = seatInRow;
    }

    public Cinema(char[][] rowsAndCols) {
        this.rowsAndCols = rowsAndCols;
    }
}
