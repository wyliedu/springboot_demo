package com.wylie.springboot.service.mapper.test1;

import com.wylie.springboot.service.entity.User2;
import com.wylie.springboot.service.entity.User2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User2Mapper {
    long countByExample(User2Example example);

    int deleteByExample(User2Example example);

    int deleteByPrimaryKey(Long id);

    int insert(User2 record);

    int insertSelective(User2 record);

    List<User2> selectByExample(User2Example example);

    User2 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByExample(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);
}