package com.web.model;

public class Message {
	int msg;
	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Message(int msg, String userid) {
		super();
		this.msg = msg;
		this.userid = userid;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMsg() {
		return msg;
	}

	public void setMsg(int msg) {
		this.msg = msg;
	}
}
