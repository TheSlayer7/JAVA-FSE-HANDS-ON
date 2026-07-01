/*
 * File: src/main/java/Week2/Spring_Core_Maven/LibraryManagementApplication.java
 * Exercise 1 & 2: Test the Configuration
 * Scenario: Run the LibraryManagementApplication main class to load the context and verify the dependency injection.
 */
package Week2.Spring_Core_Maven;

import Week2.Spring_Core_Maven.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        
        bookService.processBook();
    }
}