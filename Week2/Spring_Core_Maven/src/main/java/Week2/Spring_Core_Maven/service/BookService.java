/*
 * File: src/main/java/Week2/Spring_Core_Maven/service/BookService.java
 * Exercise 1: Configuring a Basic Spring Application
 * Exercise 2: Implementing Dependency Injection
 * Scenario: Manage dependencies between BookService and BookRepository classes using Spring's IoC and DI.
 * Steps: Update the BookService Class: Ensure that BookService class has a setter method for BookRepository.
 */
package Week2.Spring_Core_Maven.service;

import Week2.Spring_Core_Maven.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void processBook() {
        System.out.println("Processing book details in service layer...");
        if (bookRepository != null) {
            bookRepository.saveBook();
        }
    }
}