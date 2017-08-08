package com.wylie.springboot.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wylie.common.dto.CommonData;
import com.wylie.springboot.service.entity.UserEntity;
import com.wylie.springboot.service.mapper.test1.User1Mapper;
import com.wylie.springboot.service.mapper.test2.User2Mapper;
import com.wylie.springboot.service.models.InChangePassword;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class UserController extends BaseController{
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private User1Mapper user1Mapper;

	@Autowired
	private User2Mapper user2Mapper;
	
	@ApiOperation(value="获取用户列表", notes="")
	@RequestMapping(value ="/getUsers", method = RequestMethod.GET)
	public ResponseEntity<CommonData<Object>> getUsers(@CookieValue(required = false) final String locale) {
		PageHelper.startPage(1, 1);  
		List<UserEntity> users=user1Mapper.getAll();
		PageInfo pageInfo = new PageInfo(users);  
		logger.debug("locale================================="+locale);
		return ResponseEntity.ok(getSuccessOutPojo(users));
	}
	
	@RequestMapping(value ="/getUsers2", method = RequestMethod.GET)
	public List<UserEntity> getUsers2() {
		PageHelper.startPage(1, 1);  
		List<UserEntity> users=user2Mapper.getAll();
		return users;
	}
	
    @RequestMapping(value ="/getUser", method = RequestMethod.POST)
    public ResponseEntity<CommonData<Object>> getUser(@Validated @RequestBody InChangePassword User) {
    	List<UserEntity> users=user1Mapper.getAll();
		return ResponseEntity.ok(getSuccessOutPojo(users));
    }
    
    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping(value="update", method = RequestMethod.PUT)
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
}