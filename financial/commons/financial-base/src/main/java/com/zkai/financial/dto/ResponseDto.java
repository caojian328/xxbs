package com.zkai.financial.dto;

import com.zkai.financial.em.ResponseStatus;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class ResponseDto<T> extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4939201283968053640L;

	/**
     * 结果码
     */
    private final String code;

    /**
     * 结果描述
     */
    private final String msg;
    

    private final T result;

    public ResponseDto(ResponseStatus status) {
        this(status.getCode(), status.getMsg(), null);

    }
    
    public ResponseDto(ResponseStatus status,T res) {
        this(status.getCode(), status.getMsg(), res);

    }
    
    public ResponseDto(String code, String msg) {
        this(code, msg, null);
    }

    public ResponseDto(String code, String msg, T res) {
        this.code = code;
        this.msg = msg;
        this.result = res;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getResult() {
        return result;
    }
}
