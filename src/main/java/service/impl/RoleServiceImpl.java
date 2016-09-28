package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoleDAO;
import entity.Role;
import service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	public Role queryRoleByID(int id) {
		return roleDAO.queryRoleByID(id);
	}

	public List<Role> queryAllRoles(String name, String description, int status) {
		return roleDAO.queryAllRoles(name, description, status);
	}

	public void addRole(String name, String description, int status) {
		roleDAO.addRole(name, description, status);
	}

	public void updateRole(int id, String name, String description, int status) {
		roleDAO.updateRole(id, name, description, status);
	}

	
	
}
