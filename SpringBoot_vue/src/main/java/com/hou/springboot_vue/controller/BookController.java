package com.hou.springboot_vue.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou.springboot_vue.Service.ServiceImp.BookServiceImp;
import com.hou.springboot_vue.model.bean.Book;
import com.hou.springboot_vue.model.vo.LineVO;
import com.hou.springboot_vue.model.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hou
 * @create 2021-07-10 9:34 下午
 */
@RestController
public class BookController {
    @Autowired
    BookServiceImp bookService;

    //获取Book列表
    @GetMapping("/book")
    public Page<Book> getBook(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                              @RequestParam("pageSize") Integer pageSize){
        //分页查询
        Page<Book> page = new Page<>(currentPage,pageSize);
        Page<Book> bookPage = bookService.page(page);
        return bookPage;
    }

    //根据id查book
    @GetMapping("/getBookById")
    public Book getBookById(@RequestParam("id") Integer id){
        return bookService.getById(id);
    }

    //添加book
    //注意：必须加@RequestBody，要不没法从请求体中拿数据
    @PostMapping("/book")
    public Boolean addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    //更新book
    @PutMapping("/book")
    public Boolean updateBook(Book book){
        return bookService.updateById(book);
    }

    //删除book
    @DeleteMapping("/book/{id}")
    public Boolean deleteBook(@PathVariable("id") Integer id){
        return bookService.removeById(id);
    }

    //获取Pie数据
    @GetMapping("/pie")
    public List<PieVO> getPieVOList(){
        return bookService.getPieVOList();
    }

    //获取Line数据
    @GetMapping("/line")
    public LineVO getLineVOList(){
        return bookService.getLineVOList();
    }
}
