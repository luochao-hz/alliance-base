package org.september.simpleweb.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.september.simpleweb.model.WebConst;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionHelper {

	@SuppressWarnings("unchecked")
	public static <T> T getSessionUser(Class<T> clazz) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object user = request.getSession().getAttribute(WebConst.Session.Session_User_Key);
		return (T) user;
	}
	
	public static void setSessionUser(Object user) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute(WebConst.Session.Session_User_Key, user);
	}
	
	public static HttpSession getSession() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getSession();
	}
}
