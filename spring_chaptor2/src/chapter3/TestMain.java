package chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.HelloApi;
import chapter3.bean.Printer;

public class TestMain {

	@Test
	public void testSetterDependencyInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/setterDependencyInject.xml");
		HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
		bean.sayHello();
	}
	
	@Test
	public void testIdRefTestBean() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/idRefInject.xml");
		IdRefTestBean bean1 = beanFactory.getBean("idrefBean1", IdRefTestBean.class);
		System.out.println(bean1.getId());
		
		
		
		IdRefTestBean bean2 = beanFactory.getBean("idrefBean2", IdRefTestBean.class);
		System.out.println(bean2.getId());
	}


	@Test
	public void testBeanInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/beanInject.xml");
		// 通过构造器方式注入
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		// 通过setter方式注入
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testLocalAndparentBeanInject() {
		// 初始化父容器
		ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("chapter3/parentBeanInject.xml");
		// 初始化当前容器
		ApplicationContext beanContext = new ClassPathXmlApplicationContext(
				new String[] { "chapter3/localBeanInject.xml" }, parentBeanContext);
		HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);
		bean1.sayHello();// 该Bean引用local bean
		HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);
		bean2.sayHello();// 该Bean引用parent bean
	}

	@Test(expected = BeanCurrentlyInCreationException.class)
	public void testCircleByConstructor() throws Throwable {
		try {
			new ClassPathXmlApplicationContext("chapter3/circleInjectByConstructor.xml");
		} catch (Exception e) {
			// 因为要在创建circle3时抛出；
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}
	}


    //测试代码cn.javass.spring.chapter3.CircleTest  
    @Test(expected = BeanCurrentlyInCreationException.class)  
    public void testCircleBySetterAndPrototype () throws Throwable {  
        try {  
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter3/circleInjectBySet.xml");  
            System.out.println(ctx.getBean("circleA"));  
        }  
        catch (Exception e) {  
            Throwable e1 = e.getCause().getCause().getCause();  
            throw e1;  
        }  
    }  

    @Test  
    public void testMethodReplacer() {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter3/methodReplacerInject.xml");  
        Printer printer = context.getBean("printer", Printer.class);  
        printer.print("我将被替换");  
    }  

}
