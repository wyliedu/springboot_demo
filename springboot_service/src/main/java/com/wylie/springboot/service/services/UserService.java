package com.wylie.springboot.service.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wylie.springboot.service.entity.UserEntity;
import com.wylie.springboot.service.exception.NotFoundException;
import com.wylie.springboot.service.mapper.test1.User1Mapper;
import com.wylie.springboot.service.mapper.test2.User2Mapper;

@Service
public class UserService {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private User1Mapper user1Mapper;

	@Autowired
	private User2Mapper user2Mapper;
	
	@Transactional
    public void addUserTo2Db(UserEntity user) {
    	user1Mapper.insert(user);
        user2Mapper.insert(user);
    	if (true) {
			throw new NotFoundException("9000", "eee");
		}
    }
}
