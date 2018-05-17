package com.zkai.financial.execption.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zkai.financial.dto.ResponseDto;
import com.zkai.financial.execption.ValidateException;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto<?> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
       
        return new ResponseDto<String>(com.zkai.financial.em.ResponseStatus.FAIL);
    }

    
    @ResponseBody
    @ExceptionHandler(value = ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<?> validateExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
       
        return new ResponseDto<String>(com.zkai.financial.em.ResponseStatus.FAIL);
    }

}
