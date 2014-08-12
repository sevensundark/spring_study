package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserModel {

	@NotNull(message="{username.not.empty}")
	@Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")
	private String username;

	private String password;

	// 真实姓名
	private String realname;

	private WorkInfoModel workInfo;

	private SchoolInfoModel schoolInfo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public SchoolInfoModel getSchoolInfo() {
		return schoolInfo;
	}

	public void setSchoolInfo(SchoolInfoModel schoolInfo) {
		this.schoolInfo = schoolInfo;
	}

	public WorkInfoModel getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(WorkInfoModel workInfo) {
		this.workInfo = workInfo;
	}

	@Override
	public String toString() {
		return "UserModel [username=" + username + ", password=" + password
				+ ", realname=" + realname + ", workInfo=" + workInfo + ", schoolInfo=" + schoolInfo + "]";
	}
}
