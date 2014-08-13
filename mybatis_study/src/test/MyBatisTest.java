package test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.UserInfoMapper;
import entity.UserInfo;

public class MyBatisTest {
	/**
	 * 获得MyBatis SqlSessionFactory
	 * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句
	 * ，commit，rollback，close等方法。
	 * 
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			UserInfo user1 = sqlSession.selectOne("dao.UserInfoMapper.findByUserId", "lite_admin");
			System.out.println(user1);
			
			System.out.println("***************************************************");
			
			UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
			UserInfo user = userInfoMapper.findByUserId("test");
			System.out.println(user.getUserName());
			System.out.println(user);
			
//			sqlSession
		} finally {
			sqlSession.close();
		}

	}
}
