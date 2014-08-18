package mapper;

import entity.UserTInfo;

public interface OtherUserTInfoMapper {

	public UserTInfo findByUserId(int Id);
	
	public void insertUserT(UserTInfo userTInfo);
}
