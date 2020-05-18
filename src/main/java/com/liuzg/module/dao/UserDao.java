package com.liuzg.module.dao;
import com.liuzg.module.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}