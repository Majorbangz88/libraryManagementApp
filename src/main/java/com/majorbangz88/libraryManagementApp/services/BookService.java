package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.Book;
import com.majorbangz88.libraryManagementApp.dtos.requests.BookSavingRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    long count();

    void addBook(BookSavingRequest bookSavingRequest);

    Book finBookByAuthorName(String bookAuthor);
}
