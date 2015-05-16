package com.yc.util;



import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yc.dao.MemberDao;
import com.yc.entity.Member;
import com.yc.entity.SessionUser;



public class QueryBackInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	MemberDao memberDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		String method = request.getMethod();
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		HttpSession session = request.getSession();
		final Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null && session.getAttribute(SessionUser.SESSION_USER_KEY) == null) {

			String userCode = assertion.getPrincipal().getName();

			genLocalSession(session, userCode);
		}
	}
	
	private void genLocalSession(HttpSession session, String userCode) throws SQLException {
		Member user = memberDao.findByMemberCode(userCode);
		SessionUser sessionUser = new SessionUser();
		//sessionUser.setPrivilege(menuService.loadUserPrivilege(user.getId()));
		sessionUser.setId(user.getId());
		sessionUser.setEmail(user.getEmail());
		sessionUser.setPhone(user.getPhone());
		sessionUser.setAccount(user.getAccount());
		//sessionUser.setUserType(user.getFlag().intValue());
		sessionUser.setNic(user.getNic());
		session.setAttribute(SessionUser.SESSION_USER_KEY, sessionUser);
	}


}
