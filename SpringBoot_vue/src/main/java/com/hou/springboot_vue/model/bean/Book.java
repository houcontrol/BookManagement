package com.hou.springboot_vue.model.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hou
 * @create 2021-07-10 9:42 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    //数据库中id字段是自增的，所以在实体类这也需要添加自增选项，否则无法添加Book
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private Integer sales;
}
