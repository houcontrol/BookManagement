package com.hou.springboot_vue.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//MybatisConfig类，给容器中配置一个分页拦截器
@Configuration
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        //设置分页拦截器的参数
        paginationInnerInterceptor.setMaxLimit(100L);//单页分页条数限制
        paginationInnerInterceptor.setOverflow(true);//溢出总页数后是否进行处理,true:返回首页，false:继续请求
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}