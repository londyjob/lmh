package com.ultrapower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Config config;
	
	@RequestMapping(value="/hello/{name}",method=RequestMethod.POST)
	public String say(@PathVariable("name") String name) {
		return name+"girl's cupSize="+config.getCupSize()+" age="+config.getAge();
	}
}
