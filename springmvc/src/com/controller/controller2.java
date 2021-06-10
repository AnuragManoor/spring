package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller2 {
	@ResponseBody
	@RequestMapping("/bat")
	public  String givebat() {
	return "pls take ur bat";
}
}
