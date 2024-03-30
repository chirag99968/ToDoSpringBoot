package com.springboot.firstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthenticationService authenicationService;
	
	/*@RequestMapping("/login")
	public String login(@RequestParam String name, ModelMap model)
	{
		logger.info("Name from request parameter is " + name);
		model.put("name", name);
		return "login";	
	}*/

	@GetMapping("/login")
	public String login()
	{
		return "login";	
	}

	@PostMapping("/login")
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model)
	{
		logger.info("Name from request parameter is " + name);
		model.put("name", name);
		
		boolean result = authenicationService.authenticate(name, password);
		
		if(result == true)
		{
			return "welcome";	
		}
		
		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}
}
