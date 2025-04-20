package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Book[] bookArr = new Book[20];
        for (int i = 0; i < 20; i++) {
            bookArr[i] = new Book(i + 1, (i + 1) + (i + 1) + "200", "Book" + (i + 1));
        }

        boolean menuOptions = true;

        while (menuOptions) {
            System.out.println("Welcome to the Library!");
            System.out.println("1. See available Books: ");
            System.out.println("2. See checked Out Books: ");
            System.out.println("0. Exit ");

            int mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    boolean availableBooksMenu = true;
                    while (availableBooksMenu) {
                        boolean bookFound = false;
                        System.out.println("\nAvailable Books: ");
                        for (Book book : bookArr) {
                            if (!book.isCheckedOut()) {
                                System.out.println("ID: " + book.getId() + " " + "ISBN: " + book.getIsbn() + " " + "Title: " + book.getTitle());
                                bookFound = true;
                            }
                        }
                        if (!bookFound) {
                            System.out.println("No available books at the moment.");
                        }

                        System.out.println("\nWhat would you like to do?");
                        System.out.println("C = Checkout a book");
                        System.out.println("X = Go back to main menu");

                        String userOptions = scanner.next();
                        switch (userOptions) {
                            case "C":
                                System.out.println("Enter the book ID to check out: ");
                                int bookCheckOut = scanner.nextInt();
                                if (bookCheckOut <= 20 && !bookArr[bookCheckOut - 1].isCheckedOut()) {
                                    Book bookCheckoutID = bookArr[bookCheckOut - 1];
                                    System.out.println("Enter your name: ");
                                    scanner.nextLine();
                                    String userName = scanner.nextLine();

                                    bookCheckoutID.checkOut(userName);
                                    System.out.println("You've checked out: " + bookCheckoutID.getTitle());
                                } else if (bookCheckOut > 20) {
                                    System.out.println("Invalid book ID.");
                                } else {
                                    System.out.println("This book is already checked out.");
                                }
                                break;

                            case "X":
                                availableBooksMenu = false;
                                break;

                            default:
                                System.out.println("Invalid option. Choose either C or X");
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean checkedOutBooksMenu = true;
                    while (checkedOutBooksMenu) {
                        System.out.println("\nChecked Out Books: ");
                        boolean bookFound = false;
                        for (Book book : bookArr) {
                            if (book.isCheckedOut()) {
                                System.out.println(book.getTitle() + " (Checked out to " + book.getCheckedOutTo() + ")");
                                bookFound = true;
                            }
                        }
                        if (!bookFound) {
                            System.out.println("No books are currently checked out.");
                            break;
                        } else {
                            System.out.println("\nWhat would you like to do?");
                            System.out.println("R = Return a book");
                            System.out.println("X = Go back to main menu");

                            String userOption = scanner.next();
                            switch (userOption) {
                                case "R":
                                    System.out.println("Enter the book ID to return: ");
                                    int bookReturnID = scanner.nextInt();
                                    if (bookReturnID <= 20 && bookArr[bookReturnID - 1].isCheckedOut()) {
                                        Book bookToReturn = bookArr[bookReturnID - 1];
                                        bookToReturn.returnBook();
                                        System.out.println("You've returned: " + bookToReturn.getTitle());
                                    } else if (bookReturnID > 20) {
                                        System.out.println("Invalid book ID.");
                                    } else {
                                        System.out.println("This book is not checked out.");
                                    }
                                    break;

                                case "X":
                                    checkedOutBooksMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid option. Choose either R or X");
                                    break;
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("Goodbye");
                    menuOptions = false;
                    break;

                default:
                    System.out.println("Please enter a valid menu option:");
                    break;
            }
        }
    }
}
