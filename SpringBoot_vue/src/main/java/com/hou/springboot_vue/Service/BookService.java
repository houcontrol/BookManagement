package com.hou.springboot_vue.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou.springboot_vue.Mapper.BookMapper;
import com.hou.springboot_vue.model.bean.Book;
import com.hou.springboot_vue.model.vo.LineVO;
import com.hou.springboot_vue.model.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hou
 * @create 2021-07-10 9:35 下午
 */
public interface BookService extends IService<Book> {
    public List<PieVO> getPieVOList();
    public LineVO getLineVOList();

}
