package com.yc.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {


	public static final String COOKIE_TOKEN = "mplusid";

	public static final String SESS_LOGIN_USER = "_dest_login_";

	public static final String INFO_LOCKED = "locked";

	public static final String INFO_NEED_VALIDATE = "need-validate";

	public static final String INFO_ALREADY_VALIDATE = "already-validate";

	public static final String INFO_VALIDATE_FAIL = "validate-fail";

	public static final String INFO_WRONG_EMAIL = "wrong-email";

	public static final String INFO_VALIDATE_SUCCESS = "validate-success";

	/** 创建账号成功，验证邮件已发送 */
	public static final String INFO_VALIDATE_SEND = "validate-send";

	@Value("${res.root:}")
	private String resRoot;

	/*@Value("${res.web.root:}")
	private String resWebRoot;

	@Value("${test.facklogin:false}")
	private boolean fackLogin;

	@Value("${xheditor.upload.ext:}")
	private String[] xheditorExts;

	@Value("${xheditor.upload.ext:}")
	private String xheditorExt;

	@Value("${xheditor.upload.img.ext:}")
	private String[] xheditorImageExts;

	@Value("${xheditor.upload.img.ext:}")
	private String xheditorImageExt;

	@Value("${xheditor.upload.maxsize:}")
	private long xheditorMaxSize;

	@Value("${xheditor.upload.dir:}")
	private String xheditorUploadDir;

	@Value("${xheditor.upload.path:}")
	private String xheditorUploadPath;

	@Value("${xheditor.domain:}")
	private String xheditorDomain;
	
	@Value("${shuiyin_img_path:}")
	private String shuiyinimgpath;

	public String getXheditorDomain() {
		return xheditorDomain;
	}

	public void setXheditorDomain(String xheditorDomain) {
		this.xheditorDomain = xheditorDomain;
	}

	public String[] getXheditorExts() {
		return xheditorExts;
	}

	public void setXheditorExts(String[] xheditorExts) {
		this.xheditorExts = xheditorExts;
	}

	public String getXheditorExt() {
		return xheditorExt;
	}

	public void setXheditorExt(String xheditorExt) {
		this.xheditorExt = xheditorExt;
	}

	public String[] getXheditorImageExts() {
		return xheditorImageExts;
	}

	public void setXheditorImageExts(String[] xheditorImageExts) {
		this.xheditorImageExts = xheditorImageExts;
	}

	public String getXheditorImageExt() {
		return xheditorImageExt;
	}

	public void setXheditorImageExt(String xheditorImageExt) {
		this.xheditorImageExt = xheditorImageExt;
	}

	public long getXheditorMaxSize() {
		return xheditorMaxSize;
	}

	public void setXheditorMaxSize(long xheditorMaxSize) {
		this.xheditorMaxSize = xheditorMaxSize;
	}

	public String getXheditorUploadDir() {
		return xheditorUploadDir;
	}

	public void setXheditorUploadDir(String xheditorUploadDir) {
		this.xheditorUploadDir = xheditorUploadDir;
	}

	public String getXheditorUploadPath() {
		return xheditorUploadPath;
	}

	public void setXheditorUploadPath(String xheditorUploadPath) {
		this.xheditorUploadPath = xheditorUploadPath;
	}

	@Value("${upload.tmp.dir:}")
	private String uploadTmpDir;

	@Value("${upload.tmp.path:}")
	private String uploadTmpPath;

	@Value("${upload.img.dir:}")
	private String uploadImgDir;

	@Value("${upload.img.path:}")
	private String uploadImgPath;

	@Value("${upload.maxsize:}")
	private long uploadMaxsize;

	@Value("${upload.file.dir:}")
	private String uploadFileDir;

	@Value("${upload.file.path:}")
	private String uploadFilePath;

	public String getUploadFilePath() {
		return uploadFilePath;
	}

	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	*//** 找回密码 *//*
	@Value("${RETAKE_PWD_CODE_EFFECTIVE_TIME:}")
	private String retakePwdCodeEffectiveTime;

	public String getUploadFileDir() {
		return uploadFileDir;
	}

	public String getRetakePwdCodeEffectiveTime() {
		return retakePwdCodeEffectiveTime;
	}

	public void setRetakePwdCodeEffectiveTime(String retakePwdCodeEffectiveTime) {
		this.retakePwdCodeEffectiveTime = retakePwdCodeEffectiveTime;
	}

	public long getUploadMaxsize() {
		return uploadMaxsize;
	}

	public String getUploadImgDir() {
		return uploadImgDir;
	}

	public String getUploadImgPath() {
		return uploadImgPath;
	}

	public String getUploadTmpDir() {
		return uploadTmpDir;
	}

	public String getUploadTmpPath() {
		return uploadTmpPath;
	}

	public boolean isFackLogin() {
		return fackLogin;
	}

	public void setFackLogin(boolean fackLogin) {
		this.fackLogin = fackLogin;
	}

	public static String getCookieToken() {
		return COOKIE_TOKEN;
	}

	public static String getSessLoginUser() {
		return SESS_LOGIN_USER;
	}

	public static String getInfoLocked() {
		return INFO_LOCKED;
	}

	public static String getInfoNeedValidate() {
		return INFO_NEED_VALIDATE;
	}

	public static String getInfoAlreadyValidate() {
		return INFO_ALREADY_VALIDATE;
	}

	public static String getInfoValidateFail() {
		return INFO_VALIDATE_FAIL;
	}

	public static String getInfoWrongEmail() {
		return INFO_WRONG_EMAIL;
	}

	public static String getInfoValidateSuccess() {
		return INFO_VALIDATE_SUCCESS;
	}

	public static String getInfoValidateSend() {
		return INFO_VALIDATE_SEND;
	}

	@Value("${upload.mmsschedule.dir:}")
	private String uploadMmsScheduleDir;

	public String getUploadMmsScheduleDir() {
		return uploadMmsScheduleDir;
	}

	public void setUploadMmsScheduleDir(String uploadMmsScheduleDir) {
		this.uploadMmsScheduleDir = uploadMmsScheduleDir;
	}

	public String getResRoot() {
		return resRoot;
	}

	public void setResRoot(String resRoot) {
		this.resRoot = resRoot;
	}

	public String getResWebRoot() {
		return resWebRoot;
	}

	public void setResWebRoot(String resWebRoot) {
		this.resWebRoot = resWebRoot;
	}

	public  String getShuiyinimgpath() {
		return shuiyinimgpath;
	}

	public void setShuiyinimgpath(String shuiyinimgpath) {
		this.shuiyinimgpath = shuiyinimgpath;
	}*/
	
	

}
