package com.cn.zhanglei.formtag.action;

import com.opensymphony.xwork2.ActionSupport;

public class ManyAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String zlError() throws Exception {
		return "zl";
	}
	
	public String usualError() throws Exception {
		return "usual";
	}
}
