package com.wylie.springboot.service.mapper.test1;


import java.util.List;

import org.apache.ibatis.annotations.Options;

import com.wylie.springboot.service.entity.UserEntity;


public interface User1Mapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	Integer insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}