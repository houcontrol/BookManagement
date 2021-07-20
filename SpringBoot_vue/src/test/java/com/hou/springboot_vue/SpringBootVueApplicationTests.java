package com.hou.springboot_vue;

import com.hou.springboot_vue.Service.BookService;
import com.hou.springboot_vue.model.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootVueApplicationTests {
    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setName("shu ");
        book.setAuthor("zuozhe");
        boolean save = bookService.save(book);
    }
    @Test
    void contextLoad1() {
        System.out.println(bookService.getById(11));
    }

}
