package com.wcg.training.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wcg.training.domain.User;
import com.wcg.training.service.UserService;
import com.wcg.training.web.BaseController;

@Controller
@RequestMapping(value={"/admin/user"})
public class UserController extends BaseController{

	@Autowired
	private UserService _userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void index(Model model) {
		model.addAttribute("users", _userService.getAllUsers());
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		
		return "admin/userinfo";
	}
	
	@RequestMapping(value={"/save"}, method=RequestMethod.POST)
	public String saveUser(User user) {
		_userService.saveUser(user);
		
		return "redirect:user";
	}
	
}
