package com.clouddemo.order.util;

import com.clouddemo.order.vo.RestResult;

public class RestResultUtil {

	public static <T> RestResult<T> success(T data) {
		RestResult<T> result = new RestResult<T>();
		result.setCode(1);
		result.setMsg("success");
		result.setData(data);
	    return result;
    }

}
 