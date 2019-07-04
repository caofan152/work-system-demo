package com.ocj.learn;

import org.springframework.util.DigestUtils;

/**
* @author ou
* @time 2019年7月1日 下午10:18:59
*/

public class md5Test {

	public static void main(String [] args) {
		String str = "12345";
		String secret = DigestUtils.md5DigestAsHex(str.getBytes());
		System.out.println("md5 加密后字符串" + secret);
		
	}
}
