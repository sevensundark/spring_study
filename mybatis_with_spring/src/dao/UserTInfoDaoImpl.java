package dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import entity.UserTInfo;

public class UserTInfoDaoImpl extends SqlSessionDaoSupport implements UserTInfoMapper {

	@Override
	public UserTInfo findByUserId(int id) {
		return (UserTInfo) getSqlSession().selectOne("dao.UserTInfoMapper.findByUserId", id);
	}

	@Override
	public void insertUserT(UserTInfo userTInfo) {
		getSqlSession().insert("dao.UserTInfoMapper.insertUserT", userTInfo);
	}
}
