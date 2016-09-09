package main.java.dao;

import java.util.List;

import main.java.entity.Role;

import org.apache.ibatis.annotations.Param;

public interface RoleDAO {

	Role queryRoleByID(@Param("id") int id);
	
	List<Role> queryAllRoles(@Param("name") String name, @Param("description") String description, @Param("status") int status);
	
	void addRole(@Param("name") String name, @Param("description") String description, @Param("status") int status);
	
	void updateRole(@Param("id") int id, @Param("name") String name, @Param("description") String description, @Param("status") int status);
}
