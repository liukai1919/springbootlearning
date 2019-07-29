package com.example.demo.repository.impl;

import com.example.demo.model.MongoUser;
import com.example.demo.repository.UserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveUser(MongoUser mongoUser) {
        mongoTemplate.save(mongoUser);
    }

    @Override
    public MongoUser findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("userName").is(userName));
        MongoUser user =  mongoTemplate.findOne(query , MongoUser.class);
        return user;
    }

    @Override
    public long updateUser(MongoUser mongoUser) {
        Query query=new Query(Criteria.where("id").is(mongoUser.getId()));
        Update update= new Update().set("userName", mongoUser.getUserName()).set("passWord", mongoUser.getPassWord());
        //更新查询返回结果集的第一条
        UpdateResult result =mongoTemplate.updateFirst(query,update,MongoUser.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if(result!=null)
            return result.getMatchedCount();
        else
            return 0;
    }

    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoUser.class);
    }
}
