package com.majorbangz88.libraryManagementApp.data.repositories;

import com.majorbangz88.libraryManagementApp.data.models.BorrowedBooks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowedBookRepository extends MongoRepository<BorrowedBooks, String> {
}
