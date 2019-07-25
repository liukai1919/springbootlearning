package com.example.demo.mapper.test1;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface User1Mapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
