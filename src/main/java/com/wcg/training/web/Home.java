package com.wcg.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcg.training.service.MessageService;

@Controller
@RequestMapping({"/", "", "/home"})
public class Home extends BaseController {

	@Autowired
	private MessageService service;
	
	@Override
	@RequestMapping(method=RequestMethod.GET)
	public void index(Model model) {
		model.addAttribute("messages", service.getMessages());
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String postMessage(Model model, 
							@RequestParam(value="message")String message, 
							@RequestParam(value="userId") int userId) {
		
		service.addMessage(message, userId);
		
		return "redirect:/home";
	}
	
}
