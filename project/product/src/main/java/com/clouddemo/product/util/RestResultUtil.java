package com.clouddemo.product.util;

import com.clouddemo.product.vo.RestResult;

public class RestResultUtil {

	public static <T> RestResult<T> success(T data) {
		RestResult<T> result = new RestResult<T>();
		result.setCode(1);
		result.setMsg("success");
		result.setData(data);
	    return result;
    }

}
 