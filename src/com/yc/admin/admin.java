package com.yc.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yc.entity.SessionUser;

@Controller
@RequestMapping(value="/admin")
public class admin {
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
        // 模拟登录
       // if (appConfig.isFackLogin()) {
            // 判断本地是否登录
        SessionUser  sessionUser  = new SessionUser();
        sessionUser.getAccount();
		System.out.println("进来了1");
        return "/admin/login";

	}
}
