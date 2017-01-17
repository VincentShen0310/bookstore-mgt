package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login(User user, Model model){
		boolean loginType=userService.login(user.getName(), user.getPassword());
		if (loginType) {
			model.addAttribute("user", user);
			return "redirect:book/list";
		} else {
			model.addAttribute("message", "用户名密码错误");
			return "index";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/";
	}
}
