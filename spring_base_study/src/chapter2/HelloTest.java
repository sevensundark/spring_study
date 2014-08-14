package chapter2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloWorld() {
		// 1、读取配置文件实例化一个IoC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter2/helloworld.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();
	}
	
	@Test
	public void testInstantiatingBeanByStaticFactory() {
		// 使用静态工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/instantiatingBean.xml");
		HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
		bean3.sayHello();
	}


	@Test
	public void testInstantiatingBeanByInstanceFactory() {
		// 使用实例工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter2/instantiatingBean.xml");
		HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
		bean4.sayHello();
	}

	
	public static void main(String args[]) {
		// 1、读取配置文件实例化一个IoC容器
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter2/helloworld.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		// 3、执行业务逻辑
		helloApi.sayHello();
	}
}
