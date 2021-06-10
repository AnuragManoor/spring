package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class stockcontroller {
@Autowired
private stockDao stockDao;
@RequestMapping("/userShow")
public String showStock(Model model) {
	List<stock> stockList=stockDao.loadStock();
	for(stock temp:stockList) {
		System.out.println(temp);
	}
	model.addAttribute("stocks",stockList);
	return "list";
}
}
