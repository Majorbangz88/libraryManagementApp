package com.majorbangz88.libraryManagementApp.exceptions;

public class BookExistsInThePoolException extends RuntimeException {
    public BookExistsInThePoolException(String message) {
        super(message);
    }
}
