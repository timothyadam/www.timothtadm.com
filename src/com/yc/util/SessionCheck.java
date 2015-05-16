package com.yc.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;




public class SessionCheck extends HandlerInterceptorAdapter {



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		  
		 MultiActionController maControl = (MultiActionController) handler;  
		       ParameterMethodNameResolver pmrResolver = (ParameterMethodNameResolver) maControl.getMethodNameResolver();  
		         String methodName = pmrResolver.getHandlerMethodName(request);  
		        String className = handler.getClass().getName();  
		        String path = request.getRequestURI();   
		System.out.println(methodName);
		System.out.println(className);	  
		System.out.println(path);	
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		super.postHandle(request, response, handler, modelAndView);
	}


}
