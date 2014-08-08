package com.cn.zhanglei.helloworld.action;

import com.cn.zhanglei.common.exception.ZhangleiException;
import com.cn.zhanglei.helloworld.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static int helloCount = 0;
	private String userName;
	private MessageStore messageStore;

	public String execute() throws Exception {
//		String s = null;
//		try {
//			s.charAt(1);
//		} catch(Exception e) {
//			throw new ZhangleiException();	
//		}
		
		messageStore = new MessageStore();
		helloCount++;
		
		if (userName != null) {
			messageStore.setMessage(messageStore.getMessage() + " " + userName);
		}
		
		return SUCCESS;
	}
	
	public String throwException() throws Exception {
		throw new Exception();
	}
	
	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}
	
	public int getHelloCount() {
	    return helloCount;
	}
	 
	public void setHelloCount(int helloCount) {
	    HelloWorldAction.helloCount = helloCount;
	}
	
	public String getUserName() {
	    return userName;
	}
	 
	public void setUserName(String userName) {
	    this.userName = userName;
	}
}
