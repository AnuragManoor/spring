package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller1 {

	@RequestMapping("/sugar")
	public  String giveSugar() {
	return "sugar";
}
}
