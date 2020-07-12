package com.hktv.productAPI.controller;

import com.hktv.productAPI.model.Product;
import com.hktv.productAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*"})
@RestController
public class ProductController {

    @Autowired
    ProductRepository ProductRepository;

    // Get All prodcuts
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        System.out.println(ProductRepository.listAllProducts());
        return ProductRepository.listAllProducts();
    }

    // Create a new product
    @PostMapping("/product")
    public Product addProdcut(@Valid @RequestBody Product product) {
        return ProductRepository.save(product);
    }

//    // Get a Single Note
//    @GetMapping("/products/{code}")
//    public Product getProductById(@PathVariable(value = "code") String code) throws ProductNotFoundException {
//        return bookRepository.findById(bookId)
//                .orElseThrow(() -> new BookNotFoundException(bookId));
//    }

//    // Update a Note
//    @PutMapping("/books/{id}")
//    public Book updateNote(@PathVariable(value = "id") Long bookId,z
//                           @Valid @RequestBody Book bookDetails) throws BookNotFoundException {
//
//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(() -> new BookNotFoundException(bookId));
//
//        book.setBook_name(bookDetails.getBook_name());
//        book.setAuthor_name(bookDetails.getAuthor_name());
//        book.setIsbn(bookDetails.getIsbn());
//
//        Book updatedBook = bookRepository.save(book);
//
//        return updatedBook;
//    }
//
//    // Delete a Note
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(() -> new BookNotFoundException(bookId));
//
//        bookRepository.delete(book);
//
//        return ResponseEntity.ok().build();
//    }
}

