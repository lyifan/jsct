package com.wcg.training.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/", "", "/home"})
public class Home extends BaseController {

	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String postMessage(Model model, @RequestParam(value="message")String message) {
		
		model.addAttribute("message", message);
		
		return "/home";
	}
	
}
