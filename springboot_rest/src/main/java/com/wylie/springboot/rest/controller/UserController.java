package com.wylie.springboot.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import com.wylie.springboot.service.services.UserService;
import com.wylie.springboot.message.rabbit.hello.HelloSender;
import com.wylie.springboot.message.rabbit.many.NeoSender;
import com.wylie.springboot.message.rabbit.many.NeoSender2;
import com.wylie.springboot.service.entity.UserEntity;
import com.wylie.springboot.service.exception.NotFoundException;
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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private NeoSender neoSender;
	
	@Autowired
	private NeoSender2 neoSender2;
	
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
	@Cacheable(value="user-key",key="'allUser'")
	public List<UserEntity> getUsers2() {
		PageHelper.startPage(1, 1);  
		List<UserEntity> users=user2Mapper.getAll();
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
		return users;
	}
	
    @RequestMapping(value ="/getUser", method = RequestMethod.POST)
    public ResponseEntity<CommonData<Object>> getUser(@Validated @RequestBody InChangePassword User) {
    	List<UserEntity> users=user1Mapper.getAll();
		return ResponseEntity.ok(getSuccessOutPojo(users));
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
        int i = user1Mapper.insert(user);
        throw new NotFoundException("9000", "eee");
    }
    
    @RequestMapping(value ="/add2", method = RequestMethod.POST)
    public void save2(@RequestBody UserEntity user) {
        user2Mapper.insert(user);
        throw new NotFoundException("9000", "eee");
    }
    
    @RequestMapping(value="update", method = RequestMethod.PUT)
    public void update(@RequestBody UserEntity user) {
        user2Mapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
    @RequestMapping(value ="/addUserTo2Db", method = RequestMethod.POST)
    public void addUserTo2Db(@RequestBody UserEntity user) {
    	this.userService.addUserTo2Db(user);
    }
    
	@RequestMapping(value ="/testMQ", method = RequestMethod.GET)
	public void testMQ() {
		for (int i=0;i<10;i++){
			this.helloSender.send();
		}
/*		for (int i=0;i<100;i++){
			neoSender.send(i);
		}
		for (int i=0;i<100;i++){
			neoSender.send(i);
			neoSender2.send(i);
		}*/
	}
}