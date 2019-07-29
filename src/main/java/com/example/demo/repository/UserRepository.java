package com.example.demo.repository;

import com.example.demo.model.MongoUser;
import com.example.demo.model.User;

public interface UserRepository {
    public void saveUser(MongoUser MongoUser);

    public MongoUser findUserByUserName(String userName);

    public long updateUser(MongoUser MongoUser);

    public void deleteUserById(Long id);
}
