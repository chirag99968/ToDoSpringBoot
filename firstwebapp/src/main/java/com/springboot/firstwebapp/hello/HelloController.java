package com.springboot.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello! What are you doing";	
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String sayHelloHtml()
	{
		return "<!DOCTYPEhtml><htmllang=\"en\"><head><metacharset=\"UTF-8\"><metaname=\"viewport\"content=\"width=device-width,initial-scale=1.0\"><title>First Html</title></head><body><h1>Hello,World!</h1><p>First Html Document</p></body></html>\r\n"
				+ "";	
	}

	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp()
	{
		return "sayHello";	
	}
}
