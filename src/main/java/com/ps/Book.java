package com.ps;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkoutOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkoutOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckoutOutTo() {
        return checkoutOutTo;
    }

    public void setCheckoutOutTo(String checkoutOutTo) {
        this.checkoutOutTo = checkoutOutTo;
    }

    public void checkOut(String name){
        isCheckedOut = true;
        checkoutOutTo = name;
    }

    public void checkIn(){
        isCheckedOut = false;
        checkoutOutTo = "";
    }

}
