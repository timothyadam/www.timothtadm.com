package com.yc.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
//@Table(name = "t_sys_log")
public class SysLogInfo extends IdEntity implements Serializable {

/*	private String userId;

	private String userName;

	private String operTime;

	private String operType;

	private String module;

	private String description;

	private String ip;

	private String resultCode;

	private String userType;

	private Long opId;

	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "oper_time")
	public String getOperTime() {
		return operTime;
	}

	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}

	@Column(name = "oper_type")
	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	@Column(name = "module")
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "result_code")
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "op_id")
	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	@Override
    public String toString() {
		StringBuilder str = new StringBuilder(200);
		str.append("[").append(this.getModule()).append("]:").append(this.getOperTypeName()).append("\t").append(this.getDescription())
		        .append("\t����ʱ�䣺").append(this.getOperTime()).append("\t�����ˣ�").append(this.getUserName()).append("[").append(this.getUserId())
		        .append("]");
		return str.toString();
	}

	// ------------------bus method ----------
	*//**
	 * ҵ��ʹ�����ԣ���������ݿ�洢
	 *//*
	private String startTime;

	private String endTime;

	// ��������
	private static Map<String, String> operTypeMap = new HashMap<String, String>();
	static {
		operTypeMap.put("1", "�鿴");
		operTypeMap.put("2", "���");
		operTypeMap.put("3", "�޸�");
		operTypeMap.put("4", "ɾ��");
		operTypeMap.put("5", "���");
		operTypeMap.put("6", "����");
	}

	@Transient
	public String getStartTime() {
		return startTime;
	}

	@Transient
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Transient
	public String getEndTime() {
		return endTime;
	}

	@Transient
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Transient
	public String getOperTypeName() {
		return operTypeMap.get(this.getOperType());
	}

	@Transient
	public static Map<String, String> getOperTypeMap() {
		return operTypeMap;
	}
*/
}
