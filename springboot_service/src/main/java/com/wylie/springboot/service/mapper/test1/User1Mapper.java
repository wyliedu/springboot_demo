package com.wylie.springboot.service.mapper.test1;


import java.util.List;

import com.wylie.springboot.service.entity.UserEntity;


public interface User1Mapper {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}