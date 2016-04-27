package com.adanac.demo.bootstrap.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dto2Entity {
	/**
	 * 父类DTO对象转换为实体对象。如命名不规范或其他原因导致失败
	 * @param t 源转换的对象
	 * @param e 目标转换的对象
	 * 
	 */
	public static <T, E> void transalte(T t, E e) {
		Method[] tms = t.getClass().getSuperclass().getDeclaredMethods();
		Method[] tes = e.getClass().getSuperclass().getDeclaredMethods();
		for (Method m1 : tms) {
			if (m1.getName().startsWith("get")) {
				String mNameSubfix = m1.getName().substring(3);
				String forName = "set" + mNameSubfix;
				for (Method m2 : tes) {
					if (m2.getName().equals(forName)) {
						// 如果类型一致，或者m1的返回类型是m2的参数类型的父类或接口
						boolean canContinue = m1.getReturnType().isAssignableFrom(m2.getParameterTypes()[0]);
						if (canContinue) {
							try {
								m2.invoke(e, m1.invoke(t));
								break;
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * DTO对象转换为实体对象。如命名不规范或其他原因导致失败
	 * @param t 源转换的对象
	 * @param e 目标转换的对象
	 * 
	 */
	public static <T, E> void transalte2(T t, E e) {
		Method[] tms = t.getClass().getDeclaredMethods();
		Method[] tes = e.getClass().getDeclaredMethods();
		for (Method m1 : tms) {
			if (m1.getName().startsWith("get")) {
				String mNameSubfix = m1.getName().substring(3);
				String forName = "set" + mNameSubfix;
				for (Method m2 : tes) {
					if (m2.getName().equals(forName)) {
						// 如果类型一致，或者m1的返回类型是m2的参数类型的父类或接口
						boolean canContinue = m1.getReturnType().isAssignableFrom(m2.getParameterTypes()[0]);
						if (canContinue) {
							try {
								m2.invoke(e, m1.invoke(t));
								break;
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
