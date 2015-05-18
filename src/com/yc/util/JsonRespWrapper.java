package com.yc.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.google.common.collect.Maps;

public class JsonRespWrapper {

	public static Object uploadSuccess(String url) {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("err", "");
		map.put("msg", url);
		return map;
	}

	public static Object uploadError(String message) {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("err", message);
		map.put("msg", "");
		return map;
	}

	public static Object denied() {
		return error("未定义");
	}

	/**
	 * 成功的 提醒
	 * @return
	 */
	public static Object success() {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("success", true);
		return map;
	}

	/**
	 *成功提示框
	 * 
	 * @return
	 */
	public static Object successAlert(String message) {
		return success(message, null);
	}

	/**
	 *
	 * 
	 * @param redirectUrl
	 *            
	 * @return
	 */
	public static Object successJump(String redirectUrl) {
		return success(null, redirectUrl);
	}

	/**
	 *操作成功 
	 * @param message
	 *          
	 * @param redirectUrl
	 *          跳转
	 * @return
	 */
	public static Object success(String message, String redirectUrl) {
		Map<String, Object> obj = (Map<String, Object>) success();
		obj.put("message", message);
		obj.put("url", redirectUrl);
		return obj;
	}

	/**
	 * 加载成功
	 * 
	 * @param message
	 * @return
	 */
	public static Object successReload(String message) {
		return success(message, "javascript:window.location.reload()");
	}

	/**
	 *
	 * 
	 * @param message
	 * @return
	 */
	public static Object successBack(String message) {
		return success(message, "javascript:window.history.go(-1)");
	}

	/**
	 * 
	 * 
	 * @param message
	 * @return
	 */
	public static Object successRefreshBack(String message) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String url = (String) request.getSession().getAttribute(Constants.QUERY_BACK_URL);
		if (StringUtils.isEmpty(url)) {
			return successBack(message);
		}
		url = url.replace(request.getContextPath(), "");
		return success(message, url);
	}

	/**
	 *
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Object success(List<String> key, List<String> value) {
		return json(key, value, true);
	}

	public static Object error(String errorMessage) {
		return json("errorMessage", errorMessage, false);
	}

	public static Object error(Map<String, String> errors) {
		return json("errors", errors, false);
	}

	public static Object error(List<FieldError> errors) {
		Map<String, String> er = Maps.newLinkedHashMap();
		for (FieldError fe : errors) {
			er.put(fe.getField(), fe.getDefaultMessage());
		}
		return json("errors", er, false);
	}

	private static Object json(String key, Object value, boolean success) {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("success", success);
		if (key != null) {
			map.put(key, value);
		}
		return map;
	}

	private static Object json(List<String> key, List<String> value, boolean success) {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("success", success);
		if (key != null) {
			for (int i = 0; i < key.size(); i++) {
				map.put(key.get(i), value.get(i));
			}
		}
		return map;
	}

}
