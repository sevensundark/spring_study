package zhangl.mybatis;

import mapper.OtherUserTInfoMapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserTInfoMapper;
import entity.UserTInfo;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		kaitaoSetMybatis();
		
//		otherSetMybatis();
	}
	
	private static void kaitaoSetMybatis() {
		String[] configLocations = new String[] {  
		        "classpath:applicationContext-resources.xml",  
		        "classpath:applicationContext-mybatis.xml"};  
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");  
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		
		SqlSessionFactory ssfb = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
		
		
		UserTInfoMapper userDao = ctx.getBean(UserTInfoMapper.class);  
		UserTInfo user = userDao.findByUserId(2);  
		System.out.println(user);
		
//		UserTInfo insertUserDto = new UserTInfo();
//		insertUserDto.setUserId(4);
//		insertUserDto.setName("shit");
//		insertUserDto.setAge(33);
//		insertUserDto.setAddress("us");
//		userDao.insertUserT(insertUserDto);
		
		UserTInfo user1 = userDao.findByUserId(4);  
		System.out.println(user1);
	}
	
	private static void otherSetMybatis() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("otherApplicationContext.xml");
		OtherUserTInfoMapper outim = ctx.getBean(OtherUserTInfoMapper.class);
		UserTInfo user = outim.findByUserId(1);
		System.out.println(user);
	}
}
