package com.sip.amsatef.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@RequestMapping("welcome")
	public String info() {
		
		return "article/info";
	}

}
