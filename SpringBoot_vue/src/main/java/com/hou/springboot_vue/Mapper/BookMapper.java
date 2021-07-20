package com.hou.springboot_vue.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hou.springboot_vue.model.bean.Book;
import com.hou.springboot_vue.model.vo.PieVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hou
 * @create 2021-07-10 9:35 下午
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
