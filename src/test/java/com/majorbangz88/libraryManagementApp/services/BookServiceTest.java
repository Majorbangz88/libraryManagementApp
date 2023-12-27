package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.Genre;
import com.majorbangz88.libraryManagementApp.data.models.Status;
import com.majorbangz88.libraryManagementApp.data.repositories.BookRepository;
import com.majorbangz88.libraryManagementApp.dtos.requests.BookSavingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void startWithThis() {
        bookRepository.deleteAll();
    }

    @Test
    public void testThatBooksCanBeAdded() {
        BookSavingRequest bookSavingRequest = new BookSavingRequest();
        bookSavingRequest.setIsbn("G6573");
        bookSavingRequest.setTitle("Title");
        bookSavingRequest.setAuthor("Author");
        bookSavingRequest.setGenre(Genre.POLITICS);
        bookSavingRequest.setStatus(Status.AVAILABLE);
        bookSavingRequest.setQuantityAvailable(1);
        bookSavingRequest.setBorrowPrice(BigDecimal.valueOf(500));
        bookSavingRequest.setDateTimeAdded(LocalDateTime.of(2023,
                Month.NOVEMBER, 10, 1, 31, 50));
        bookService.addBook(bookSavingRequest);
        assertThat(bookRepository.count(), is(1L));
    }
}