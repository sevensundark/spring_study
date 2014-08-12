package controller.validate.model;

import javax.validation.constraints.Pattern;

public class PatternModel {

	// 验证注解的元素值与指定的正则表达式匹配
	// 如常见的用户名，以字母或下划线开头，后边可以跟字母数字下划线，长度在5-20之间
	@Pattern(regexp = "^[a-zA-Z_][\\w]{4,19}$", message = "{user.name.error}")
	//private String value; 属性里面尽量不要使用与注解类里有同名的属性，例如pattern里也有value(主要是因为flag属性里有value)

	private String ovalue;
	
	public String getOvalue() {
		return ovalue;
	}

	public void setOvalue(String ovalue) {
		this.ovalue = ovalue;
	}

}
