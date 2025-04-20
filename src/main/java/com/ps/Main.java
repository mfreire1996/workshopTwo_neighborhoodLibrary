package com.ps;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Book[] bookArr = new Book[20];
        for(int i = 0; i < 20; i++){
            bookArr[i] = new Book(i+1,  i + "200", i + "title");
        }
//        System.out.println(bookArr[0].getTitle());

        //If a book is checkout out the checkedOutTo
        //should provide the names to the books set.
        boolean menuOptions = true;

        while (menuOptions){
            System.out.println("Welcome to the Library!");
            System.out.println("1. See available Books: ");
            System.out.println("2. See checked Out Books: ");
            System.out.println("3. Check in a book");
            System.out.println("4. Checked out a book ");
            System.out.println("5. Exit ");

            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                System.out.println("\nA");
                for (Book book: bookArr){
                    if(!book.isCheckedOut()){
                        System.out.println(book);
                    }
                }
            } else if (userChoice == 2){
                System.out.println("\nCheckout out books: ");
                for (Book book: bookArr){
                    if (book.isCheckedOut()){
                        System.out.println(book);
                    }
                }
            } else if (userChoice == 3){
                System.out.println("Enter the book ID to check out: ");
                int bookID = scanner.nextInt();
                if(bookID <= 20){
                    Book bookReturned = bookArr[bookID - 1];
                    if(!bookReturned.isCheckedOut()){
                        System.out.println("You have checked out: " + bookReturned.getTitle());
                    } else {
                        System.out.println("This book is already checked out.");
                    }
                } else {
                    System.out.println("Invalid book ID.");
                }
            } else if (userChoice == 4) {
                System.out.println("Enter the book ID to return");
                int bookID = scanner.nextInt();
                if(bookID <= 20){
                    Book bookReturned = bookArr[bookID - 1];
                    if (bookReturned.isCheckedOut()) {
                        bookReturned.checkIn();
                        System.out.println("You have returned: " + bookReturned.getTitle());
                    } else {
                        System.out.println("This book wasn't checked out.");
                    }
                } else {
                    System.out.println("Invalid book ID");
                }
            } else if(userChoice == 5) {
                System.out.println("Goodbye");
                menuOptions = false;
            } else {
                System.out.println("Please enter one of the menu options.");
            }

        }


    }
}