package com.cn.zhanglei.register.action;

import com.cn.zhanglei.common.exception.ZhangleiException;
import com.cn.zhanglei.register.model.Person;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Person personBean;

	@Override
	public String execute() throws Exception {

		// call Service class to store personBean's state in database
        System.out.println("----------------Action Execute!!----------------------");
		
		return SUCCESS;

	}
	
	public String throwZhangleiException() throws Exception {
		throw new ZhangleiException();
	}

	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person person) {
		personBean = person;
	}

	public void validate() {
//		if (personBean.getFirstName().length() == 0) {
//			addFieldError("personBean.firstName", "First name is required.");
//		}
//
//		if (personBean.getEmail().length() == 0) {
//			addFieldError("personBean.email", "Email is required.");
//		}
//
//		if (personBean.getAge() < 18) {
//			addFieldError("personBean.age", "Age is required and must be 18 or older");
//		}
	}
	
}
