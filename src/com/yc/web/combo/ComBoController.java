package com.yc.web.combo;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yc.dao.order.OrderDao;
import com.yc.service.order.OrderService;
import com.yc.util.AppConfig;

@Controller
@RequestMapping(value="/combo")
public class ComBoController {
	private static Logger log = Logger.getLogger(ComBoController.class);
	
	@Autowired
	private OrderService service;
	@Autowired
	private OrderDao dao;
	@Autowired
	private AppConfig appconfig;
	
	@RequestMapping(value="combos" ,method = RequestMethod.GET)
	public String combos(Model model, HttpSession session) {
		System.out.println("进来了1");
        return "/combo/combo-list";

	}
	
	

}
