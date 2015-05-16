package com.yc.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "yc_member")
public class Member implements Serializable{
	
	public static final Long STATUS_VALID = 1L;
	 
	public static final Long STATUS_INVALID = 2L;


	public static final Long STATUS_DELETED = 3L;

	
	public static final int USER_TYPE_MASTER = 0;
	
	  Long  id;
      String account;
      String nic;
      String phone;
      String password;
      String confirmPass;
      String adress;
      String create_time;
      String email;
      String flag;
      @Id  
      @Basic(optional = false)   
      @GeneratedValue(strategy = GenerationType.IDENTITY)   
      @Column(name = "id", nullable = false)   
      public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="account")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name="nic")
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="adress")
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Column(name="create_time")
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	@Transient
	public String getConfirmPass() {
		return confirmPass;
	}

	@Transient
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	private String memberCode;
	

	@Column(name="membercode")
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	@Transient
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
    
	
	
	
}
