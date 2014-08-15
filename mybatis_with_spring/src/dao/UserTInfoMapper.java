package dao;

import entity.UserTInfo;

public interface UserTInfoMapper {

	public UserTInfo findByUserId(int Id);
	
	public void insertUserT(UserTInfo userTInfo);
}
