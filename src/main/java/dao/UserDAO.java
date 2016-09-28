package dao;

import java.util.List;

import entity.User;

import org.apache.ibatis.annotations.Param;

public interface UserDAO {
	
	User queryUserByID(@Param("id") int id);
	
	List<User> queryAllUsers();
	
	List<User> queryUsersByCondition(@Param("name") String name, @Param("status") int status,@Param("roleName") int roleName);
	
	void addOneUser(@Param("name") String name, @Param("password") String password, @Param("status") int status, @Param("roleId") int roleId);
	
	void updateOneUser(@Param("id") int id, @Param("name") String name, @Param("password") String password, @Param("status") int status, @Param("roleId") int roleId);
}
