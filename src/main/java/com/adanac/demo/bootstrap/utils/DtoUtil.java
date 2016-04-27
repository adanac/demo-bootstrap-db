package com.adanac.demo.bootstrap.utils;

import com.adanac.demo.bootstrap.entity.common.BaseDto;

/**
 * DTO工具类
 */
public final class DtoUtil {

	private DtoUtil() {
	}

	/**
	 * 实例化BaseDto对象
	 * 
	 * @param isSucessful
	 *            成功与否
	 * @param errorCode
	 *            错误代码
	 * @param errorMsg
	 *            错误描述
	 * @return BaseDto对象
	 * @see BaseDto
	 */
	public static BaseDto instanceBaseDto(boolean isSuccessful, String errorCode, String errorMsg) {
		return instanceBaseDto(isSuccessful, errorCode, errorMsg, null);
	}

	/**
	 * 实例化BaseDto对象(包含返回值)
	 * 
	 * @param isSucessful
	 *            成功与否
	 * @param errorCode
	 *            错误代码
	 * @param errorMsg
	 *            错误描述
	 * @param retVal
	 *            携带的返回值
	 * @return 返回BaseDto对象
	 * @see BaseDto
	 */
	public static BaseDto instanceBaseDto(boolean isSuccessful, String errorCode, String errorMsg, String retVal) {
		BaseDto baseDto = new BaseDto();
		if (isSuccessful) {
			baseDto.setStatu(BaseDto.SUCCESS);
			if (null != retVal) {
				baseDto.setReturnId(retVal);
			}
		} else {
			baseDto.setStatu(BaseDto.ERROR);
			baseDto.setErrorCode(errorCode);
			baseDto.setErrorMsg(errorMsg);
		}
		return baseDto;
	}
}
