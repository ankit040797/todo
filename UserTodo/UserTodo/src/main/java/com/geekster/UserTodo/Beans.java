package com.geekster.UserTodo;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
public class Beans {

    @Bean
    public List<TodoManage> getDataSource(){
        return new ArrayList<>();
    }
}
