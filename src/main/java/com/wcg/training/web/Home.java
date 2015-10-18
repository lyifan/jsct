package com.wcg.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcg.training.service.MessageService;
import com.wcg.trainning.security.MyAuthentication;

@Controller
@RequestMapping(value={"/", "", "/home"})
public class Home extends BaseController {

	@Autowired
	private MessageService service;
	
	@Override
	@RequestMapping(method=RequestMethod.GET, value="")
	public void index(Model model) {
		model.addAttribute("messages", service.getMessages());
		MyAuthentication authentication = (MyAuthentication)SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("USER", authentication.getUser());
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String postMessage(Model model, 
							@RequestParam(value="message")String message, 
							@RequestParam(value="userId") int userId) {
				
		service.addMessage(message, userId);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/delete/{messageId}", method=RequestMethod.GET)
	public String deleteMessage(@PathVariable int messageId) {
		
		service.deleteMessage(messageId);
		
		return "redirect:/home";
	}
	
}
