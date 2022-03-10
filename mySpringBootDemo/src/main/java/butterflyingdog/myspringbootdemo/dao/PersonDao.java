package butterflyingdog.myspringbootdemo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    Integer createUser(String userName);
}