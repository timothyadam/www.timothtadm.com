package com.yc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.cplatform.util2.TimeStamp;
import com.yc.dao.MemberDao;


@Component
public class LogUtils {

	/** ��־���ͣ� 1-�鿴 2-��� 3-�޸� 4-ɾ�� 5-��� 6-���� */
	public final Long VIEW = 1L;

	public final Long ADD = 2L;

	public final Long MODIFY = 3L;

	public final Long DELETE = 4L;

	public final Long AUDIT = 5L;

	public final Long OTHER = 6L;

	@Autowired
	private MemberDao logDao;

	/*	@Autowired
	private SysLoginLogDao loginLogDao;

	*//** ��־���� *//*
	private final Logger logger = Logger.getLogger(LogUtils.class);

	*//**
	 * ��¼������͵�ϵͳ��־
	 * 
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logAdd(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, ADD, module, description, null);
	}

	public void logAdd(String module, String description, Long opId) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, ADD, module, description, opId);
	}

	*//**
	 * ��¼������͵�ϵͳ��־
	 * 
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logAudit(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, AUDIT, module, description, null);
	}

	public void logAudit(String module, String description, Long opId) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, AUDIT, module, description, opId);
	}

	*//**
	 * ��¼ɾ�����͵�ϵͳ��־
	 * 
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logDelete(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, DELETE, module, description, null);
	}

	public void logDelete(String module, String description, Long opId) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, DELETE, module, description, opId);
	}

	*//**
	 * ��¼�û���¼��־
	 * 
	 * @param userId
	 *            ��¼�û����
	 * @param userType
	 *            ��¼�û�����
	 * @param userCode
	 *            ��¼�û��˺�
	 * @param userName
	 *            ��¼�û���
	 * @param ip
	 * @param logSuccess
	 *            true -��¼�ɹ� false -��¼ʧ��
	 *//*
	public void loginLog(Long userId, Integer userType, String userCode, String userName, String ip, boolean logSuccess) {
		SysLoginInfo tSysLoginLog = new SysLoginInfo();
		tSysLoginLog.setUserId(userId);
		tSysLoginLog.setUserType(userType);
		tSysLoginLog.setUserName(userName);
		tSysLoginLog.setIp(ip);
		tSysLoginLog.setLoginTime(TimeStamp.getTime(14));
		tSysLoginLog.setSuccessFlag(logSuccess ? 1 : 0);
		loginLogDao.save(tSysLoginLog);
	}

	*//**
	 * ��¼�޸����͵�ϵͳ��־
	 * 
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logModify(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, MODIFY, module, description, null);
	}

	public void logModify(String module, String description, Long opid) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, MODIFY, module, description, opid);
	}

	*//**
	 * ��¼�������͵�ϵͳ��־
	 * 
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logOther(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, OTHER, module, description, null);
	}

	public void logOther(String module, String description, Long opid) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, OTHER, module, description, null);
	}

	*//**
	 * ��¼�鿴���͵�ϵͳ��־
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	public void logView(String module, String description) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, VIEW, module, description, null);
	}

	public void logView(String module, String description, Long opid) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		sysLog(request, VIEW, module, description, opid);
	}

	*//**
	 * ��¼ϵͳ��־
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param operType
	 *            ��������
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 *//*
	private void sysLog(HttpServletRequest req, Long operType, String module, String description, Long opid) {
		HttpSession session = req.getSession();
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		sysLog(sessionUser.getId(), sessionUser.getUserType(), sessionUser.getName(), operType, module, description, req.getRemoteAddr(), opid);
	}

	*//**
	 * ��¼ϵͳ��־
	 * 
	 * @param userId
	 *            �û����
	 * @param userType
	 *            �û�����
	 * @param userCode
	 *            �û��˺�
	 * @param userName
	 *            �û���
	 * @param operType
	 *            ��������
	 * @param module
	 *            ����ģ����
	 * @param description
	 *            ������������
	 * @param ip
	 *            �����߻���IP
	 *//*
	public void sysLog(Long userId, int userType, String userName, Long operType, String module, String description, String ip, Long opid) {
		try {
			SysLogInfo tSysLog = new SysLogInfo();
			tSysLog.setUserId(String.valueOf(userId));
			tSysLog.setUserType(String.valueOf(userType));
			tSysLog.setUserName(userName);
			tSysLog.setOperType(String.valueOf(operType));
			tSysLog.setDescription(description);
			tSysLog.setModule(module);
			tSysLog.setIp(ip);
			tSysLog.setOperTime(TimeStamp.getTime(14));
			logger.info(tSysLog.toString());
			logDao.save(tSysLog);
		}
		catch (Exception e) {
			logger.error("��¼��־�쳣-" + module + "\t" + operType + "\t" + description, e);
		}
	}*/
}
