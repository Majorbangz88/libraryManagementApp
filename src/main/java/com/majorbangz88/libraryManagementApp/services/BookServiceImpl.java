package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.Book;
import com.majorbangz88.libraryManagementApp.data.models.Status;
import com.majorbangz88.libraryManagementApp.data.repositories.BookRepository;
import com.majorbangz88.libraryManagementApp.dtos.requests.BookSavingRequest;
import com.majorbangz88.libraryManagementApp.exceptions.BookExistsInThePoolException;
import com.majorbangz88.libraryManagementApp.exceptions.BookNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.majorbangz88.libraryManagementApp.utils.userServiceImplMapper.bookServiceImplMapper.Mapper.map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(BookSavingRequest bookSavingRequest) {
        findBookBy(bookSavingRequest.getIsbn());
        Book book = map(bookSavingRequest);
        bookRepository.save(book);
    }

    @Override
    public Book finBookByAuthorName(String bookAuthor) {
        Optional<Book> book = bookRepository.finBookByAuthorName(bookAuthor);
        if (book.isEmpty()) throw new BookNotAvailableException("Sorry, we currently do not have this book!");
        Book newBook = new Book();
        if (newBook.getStatus().equals(Status.AVAILABLE))
            return newBook;
        return null;
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    private void findBookBy(String isbn) {
        Optional<Book> book = bookRepository.findBookByIsbn(isbn);
        if (book.isPresent()) throw new BookExistsInThePoolException("Book exists already!");
    }
}
