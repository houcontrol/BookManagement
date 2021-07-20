package com.hou.springboot_vue.Service.ServiceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou.springboot_vue.Mapper.BookMapper;
import com.hou.springboot_vue.Service.BookService;
import com.hou.springboot_vue.model.bean.Book;
import com.hou.springboot_vue.model.vo.DataVO;
import com.hou.springboot_vue.model.vo.LineVO;
import com.hou.springboot_vue.model.vo.PieVO;
import com.hou.springboot_vue.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hou
 * @create 2021-07-10 9:36 下午
 */
@Service
public class BookServiceImp extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<PieVO> getPieVOList() {
        //查出bookList
        List<Book> bookList = bookMapper.selectList(null);
        //转换为pieVOList
        ArrayList<PieVO> pieVOList = new ArrayList<>();
        for (Book book :bookList) {
            PieVO pieVO = new PieVO();
            pieVO.setValue(book.getSales());
            pieVO.setName(book.getName());
            pieVOList.add(pieVO);
        }
        return pieVOList;
    }

    @Override
    public LineVO getLineVOList() {
        //1.查出bookList
        List<Book> bookList = bookMapper.selectList(null);
        //2.转换为lineVO
        LineVO lineVO = new LineVO();

        //2.1.保存names
        ArrayList<String> names = new ArrayList<>();
        //2.2.保存dataVOList
        ArrayList<DataVO> dataVOList = new ArrayList<>();
        for (Book book :bookList) {
            names.add(book.getName());

            DataVO dataVO = new DataVO();
            dataVO.setValue(book.getSales());
            Map<String, String> map = DataUtil.createItemStyle(book.getSales());
            dataVO.setItemStyle(map);
            dataVOList.add(dataVO);

            //2.3. 将names和dataVOList保存至lineVO
            lineVO.setNames(names);
            lineVO.setDataVOList(dataVOList);
        }
        return lineVO;
    }
}
