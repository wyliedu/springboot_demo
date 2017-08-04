package com.wylie.springboot.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wylie.springboot.service.entity.UserEntity;
import com.wylie.springboot.service.mapper.test1.User1Mapper;
import com.wylie.springboot.service.mapper.test2.User2Mapper;


@RestController
public class UserController {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private User1Mapper user1Mapper;

	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping(value ="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> getUsers() {
		List<UserEntity> users=user1Mapper.getAll();
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping("/getUsers2")
	public List<UserEntity> getUsers2() {
		List<UserEntity> users=user2Mapper.getAll();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=user2Mapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
}