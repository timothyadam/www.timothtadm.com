package com.yc.entity;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SessionUser implements Serializable{
	private static final long serialVersionUID = -3911707577350340265L;

	public static final String SESSION_USER_KEY = "session_user_key__";

	private Long id;

	private String nic;
	
	private String account;

	private String phone;

	private String email;

	public static SessionUser getSessionUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		return (SessionUser) session.getAttribute(SESSION_USER_KEY);
	}

	
	public static boolean isLogin() {
		return getSessionUser() != null;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
  
	
	

}
