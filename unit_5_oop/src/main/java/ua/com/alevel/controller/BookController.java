package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookController {

    private BookService bookService = new BookService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option.");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println("If you want to create book, please enter 1");
        System.out.println("If you want to update book, please enter 2");
        System.out.println("If you want to delete book, please enter 3");
        System.out.println("If you want to find book by id, please enter 4");
        System.out.println("If you want to find all books, please enter 5");
        System.out.println("If you want to exit, please enter 0");
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("UserController.create");
        try {
            System.out.println("Please enter a name of the book");
            String name = reader.readLine();
            System.out.println("Please enter author of the book");
            String author = reader.readLine();
            System.out.println("Please enter the number of pages");
            String pagesNumberString = reader.readLine();
            int pagesNumber = Integer.parseInt(pagesNumberString);
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setPagesNumber(pagesNumber);
            bookService.create(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("UserController.update");
        try {
            System.out.println("Please enter Id");
            String id = reader.readLine();
            System.out.println("Please enter a name of the book");
            String name = reader.readLine();
            System.out.println("Please enter author of the book");
            String author = reader.readLine();
            System.out.println("Please enter the number of pages");
            String pagesNumberString = reader.readLine();
            int pagesNumber = Integer.parseInt(pagesNumberString);
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            book.setPagesNumber(pagesNumber);
            bookService.update(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("UserController.delete");
        try {
            System.out.println("Please enter Id");
            String id = reader.readLine();
            bookService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("UserController.findById");
        try {
            System.out.println("Please enter Id");
            String id = reader.readLine();
            Book book = bookService.findById(id);
            System.out.println("Book = " + book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("UserController.findAll");
        Book[] books = bookService.findAll();
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }
}
