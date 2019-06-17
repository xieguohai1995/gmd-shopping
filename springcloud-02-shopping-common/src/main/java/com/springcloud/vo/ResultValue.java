package com.springcloud.vo;

import java.util.Map;

import lombok.Data;

/**
 * 定义本项目所有controller返回的结果类型
 * @author Administrator
 *
 */
@Data
public class ResultValue implements java.io.Serializable{

	private static final long serialVersionUID = -7333058567132357663L;
	
	/**
	 * 表示当前返回结果的状态：0成功，1失败
	 */
	
	private Integer code;
	
	/**
	 * 设置返回信息
	 */
	
	private String message;
	
	
	/**
	 * 设置返回数据
	 */
	
	private Map<String, Object> dataMap;

}
