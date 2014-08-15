package zhangl.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserTInfoMapper;
import entity.UserTInfo;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] configLocations = new String[] {  
		        "classpath:applicationContext-resources.xml",  
		        "classpath:applicationContext-mybatis.xml"};  
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");  
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		UserTInfoMapper userDao = ctx.getBean(UserTInfoMapper.class);  
	    UserTInfo user =  userDao.findByUserId(1);  
	    System.out.println(user);
	}
}
