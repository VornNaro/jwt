package com.kshrd.jwt_testing.repository;

import com.kshrd.jwt_testing.entity.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT r.role_name FROM user_role ur
            INNER JOIN roles r ON r.id = ur.role_id
            WHERE ur.user_id = #{userId}
           """)
    List<String> getRoleByUserId(@Param("userId") Integer userId);



    @Select("SELECT * FROM user_tb WHERE  username = #{name.userName}")
    @Results(
            id = "mappUser",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "username"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "roles", column = "id", many = @Many(select = "getRoleByUserId"))
            }
    )
    UserInfo findUserByName(@Param("name") String userName);



}
