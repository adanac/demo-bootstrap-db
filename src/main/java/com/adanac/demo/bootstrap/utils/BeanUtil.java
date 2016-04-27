package com.adanac.demo.bootstrap.utils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

/**
 * POJO对象相关操作的工具类
 */
public final class BeanUtil {

	private BeanUtil() {
	}

	static {
		// 注册java.sql.Date的转换器，即允许BeanUtils.copyProperties时的源目标的Date类型的值允许为空
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		// 注册java.util.Date的转换器，即允许BeanUtils.copyProperties时的源目标的Date类型的值允许为空
		ConvertUtils.register(new SqlDateConverter(null), java.util.Date.class);
		// 注册java.sql.Timestamp的转换器，即允许BeanUtils.copyProperties时的源目标的Timestamp类型的值允许为空
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
	}

	/**
	 * 从源对象拷贝同类型同名的属性值到目标对象中
	 * @param target 目标对象
	 * @param source 源对象
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @see void
	 */
	public static void copyProperties(Object target, Object source)
			throws InvocationTargetException, IllegalAccessException {
		// 支持对日期copy
		BeanUtils.copyProperties(target, source);
	}

	/**
	 * 克隆出同类型属性的不同类型对象列表
	 * @param clazz 目标对象类型
	 * @param source 源对象列表
	 * @return 目标对象列表
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @see List<T>
	 */
	public static <T, S> List<T> cloneProperties(Class<T> clazz, List<S> source)
			throws InvocationTargetException, IllegalAccessException, InstantiationException {
		List<T> result = new ArrayList<>();
		T tar = null;
		for (S src : source) {
			tar = clazz.newInstance();
			copyProperties(tar, src);
			result.add(tar);
		}
		return result;
	}

}
