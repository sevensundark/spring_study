package dao;

import entity.UserInfo;

public interface UserInfoMapper {

	public UserInfo findByUserId(String Id);
	
}
