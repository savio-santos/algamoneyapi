package com.savio.algamoneyapi.resource.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private String msgDev;
	private Long timeStamped;
	
	
	public StandardError() {
		super();
	}
	public StandardError(Integer status, String msg,String msgDev, Long timeStamped) {
		super();
		this.status = status;
		this.msg = msg;
		this.setMsgDev(msgDev);
		this.timeStamped = timeStamped;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgDev() {
		return msgDev;
	}
	public void setMsgDev(String msgDev) {
		this.msgDev = msgDev;
	}
	public Long getTimeStamped() {
		return timeStamped;
	}
	public void setTimeStamped(Long timeStamped) {
		this.timeStamped = timeStamped;
	}
	
}
