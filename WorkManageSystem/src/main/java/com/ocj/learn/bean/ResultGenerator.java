package com.ocj.learn.bean;

/**
 * 返回工具对象
 * @author Administrator
 *  
 */
public class ResultGenerator {
	  private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	    //成功
	    /*public static <T> ResponseBean<T> genSuccessResult() {
	        return new ResponseBean<T>()
	                .setCode(ResultCodeEnum.SUCCESS)
	                .setMessage(DEFAULT_SUCCESS_MESSAGE);
	    }
*/
	    public static <T> ResponseBean<T> genSuccessResult(T data) {
	        return new ResponseBean<T>()
	                .setCode(ResultCodeEnum.SUCCESS)
	                .setMessage(DEFAULT_SUCCESS_MESSAGE)
	                .setData(data);
	    }
	    
	    /**
	     * 成功
	     * @param data
	     * @return
	     */
	    public static ResponseBean<String> genSuccessMessage(String message) {
	        return new ResponseBean<String>()
	                .setCode(ResultCodeEnum.SUCCESS)
	                .setMessage(message) ; 
	    }
	    
	    /**
	     * 失败信息
	     * @param message
	     * @return
	     */
	    public static ResponseBean<String> genFailMessage(String message) {
	        return new ResponseBean<String>()
	                .setCode(ResultCodeEnum.FAIL)
	                .setMessage(message) ; 
	    }	

	    public static ResponseBean<String> genFailResult(String message) {
	        return new ResponseBean<String>()
	                .setCode(ResultCodeEnum.FAIL)
	                .setMessage(message);
	    }
	   
	    /**
	     * 返回权限验证
	     * @param message
	     * @return
	     */
	    public static ResponseBean<String> genAuthResult(String message) {
	        return new ResponseBean<String>()
	                .setCode(ResultCodeEnum.AUTH_FAIL)
	                .setMessage(message);
	    }

	    public static ResponseBean<String> genUnauthorizedResult() {
	        return new ResponseBean<String>()
	                .setCode(ResultCodeEnum.UNAUTHORIZED)
	                .setMessage("权限不足！");
	    }
}
