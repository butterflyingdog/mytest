package myspringbootdemo.personmng.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public  Integer createUser(String userName);
}