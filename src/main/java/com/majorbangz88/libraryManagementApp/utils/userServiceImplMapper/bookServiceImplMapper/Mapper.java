package com.majorbangz88.libraryManagementApp.utils.userServiceImplMapper.bookServiceImplMapper;

import com.majorbangz88.libraryManagementApp.data.models.Book;
import com.majorbangz88.libraryManagementApp.dtos.requests.BookSavingRequest;

public class Mapper {

    public static Book map(BookSavingRequest bookSavingRequest) {
        Book book = new Book();
        book.setIsbn((bookSavingRequest.getIsbn()));
        book.setTitle(bookSavingRequest.getTitle());
        book.setAuthor(bookSavingRequest.getAuthor());
        book.setGenre(bookSavingRequest.getGenre());
        book.setStatus(bookSavingRequest.getStatus());
        book.setBorrowPrice(bookSavingRequest.getBorrowPrice());
        book.setDateTimeAdded(bookSavingRequest.getDateTimeAdded());
        return book;
    }
}
