package com.hou.springboot_vue.model.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author hou
 * @create 2021-07-20 11:17 上午
 */
@Data
public class LineVO {
    private List<String> names;
    private List<DataVO> dataVOList;
}
