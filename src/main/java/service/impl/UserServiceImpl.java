package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import entity.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public boolean login(String username,String password){
		
		System.out.println("GET username is "+username+",and password is "+password);
		
		User user=userDAO.queryUserByName(username);
		if (user!=null) {
			System.out.println("SEARCH username is "+user.getName()+",password is "+user.getPassword()+" and status is "+user.getStatus());
			if (user.getName().equals(username)&&user.getPassword().equals(password)&&user.getStatus()==1) {
				return true;
			}
		}
		return false;
	}
	
}



