package com.finalc.chatting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//=== #175. (웹채팅관련7) === 

@Controller
public class ChattingController {
	
	@RequestMapping(value="/chatting/multichat.action", method={RequestMethod.GET})
	public String requireLogin_multichat(HttpServletRequest req, HttpServletResponse res){
		
		return "multichat.notiles";
	}
	
}
