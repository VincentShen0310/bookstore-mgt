package web;

import java.util.List;

import entity.Role;
import service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/list")
	public String list(Model model, Role role){
		List<Role> list=roleService.queryAllRoles(role.getName(), role.getDescription(), role.getStatus());
		model.addAttribute("list", list);
		model.addAttribute("rolesearch", role);
		return "role/list";
	}
	
	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model) {
		if (id==0) {
			return "redirect:/role/list";
		}
		Role role=roleService.queryRoleByID(id);
		if (role==null) {
			return "redirect:/role/list";
		}
		model.addAttribute("roledetail", role);
		return "role/detail";
	}
	
	@RequestMapping(value="/addinit")
	public String addinit(){
		return "role/add";
	}
	
}
