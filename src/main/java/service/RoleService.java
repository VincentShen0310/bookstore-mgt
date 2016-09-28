package service;

import java.util.List;

import entity.Role;

public interface RoleService {
	
	Role queryRoleByID(int id);
	
	List<Role> queryAllRoles(String name,String description,int status);
	
	void addRole(String name, String description, int status);
	
	void updateRole(int id, String name, String description, int status);

}
