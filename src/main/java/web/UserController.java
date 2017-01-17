package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller("/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login1")
	public String login(User user,HttpServletRequest request){
		boolean loginType=userService.login(user.getName(), user.getPassword());
		if (loginType) {
			request.setAttribute("user", user);
			return "book/list";
		} else {
			return "index";
		}
	}
}
