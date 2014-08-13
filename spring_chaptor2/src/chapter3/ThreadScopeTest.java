package chapter3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.HelloApi;

public class ThreadScopeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/customscope.xml");
		final HelloApi bean1 = beanFactory.getBean("helloApi", HelloApi.class);
		final HelloApi bean2 = beanFactory.getBean("helloApi", HelloApi.class);
		
		System.out.println(bean1 == bean2);
		
		(new Thread() {
			public void run() {
				HelloApi bean3 = beanFactory.getBean("helloApi", HelloApi.class);
				
				System.out.println("thead:" + (bean3 == bean2));
			}
		}).start();
	}

}
