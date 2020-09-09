package io;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    public static String getString() {
        return scanner.nextLine();
    }

    public static int getNumPages() {
        int pages = -1;
        if(scanner.hasNextInt()) {
            pages = scanner.nextInt();
            if(pages <= 0) pages = -1;
        }
        return pages;
    }
}
