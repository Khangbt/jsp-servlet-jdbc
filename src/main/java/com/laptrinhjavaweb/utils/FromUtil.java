package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FromUtil {
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request){
		T object = null;
		try {
			object = clazz.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		}catch (Exception e) {
			e.getMessage();
		}
		return object;
	}
}
