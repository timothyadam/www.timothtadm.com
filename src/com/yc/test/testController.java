package com.yc.test;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.service.MemberService;

@Controller
@RequestMapping("/test")
public class testController {
	@Autowired
	MemberService uservice;
	

	@RequestMapping(value="/pass", method = RequestMethod.GET)
	public String 	List(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestParam(required = false, value = "page", defaultValue = "1") int page, Model model)
	        throws SQLException {
	
	  
		System.out.println("进入了pass");
		return "/test/test_list";
	}

}
