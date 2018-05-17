package com.zkai.financial.controller;

import com.zkai.financial.dto.ResponseDto;
import com.zkai.financial.em.ResponseStatus;

public abstract class BaseController {

	
	protected <T> ResponseDto<T> success() {

		return success(null);
	}
	
	protected <T> ResponseDto<T> success(T res) {

		return new ResponseDto<T>(ResponseStatus.SUCCESS, res);
	}

	protected <T> ResponseDto<T> fail() {

		return fail(null);
	}
	
	protected <T> ResponseDto<T> fail(T res) {

		return new ResponseDto<T>(ResponseStatus.FAIL, res);
	}
}
