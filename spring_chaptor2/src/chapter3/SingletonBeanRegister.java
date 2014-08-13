package chapter3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class SingletonBeanRegister implements SingletonBeanRegistry {
	// ����Bean����أ��˴������ǲ���
	private final Map<String, Object> BEANS = new HashMap<String, Object>();

	public boolean containsSingleton(String beanName) {
		return BEANS.containsKey(beanName);
	}

	public Object getSingleton(String beanName) {
		return BEANS.get(beanName);
	}

	@Override
	public int getSingletonCount() {
		return BEANS.size();
	}

	@Override
	public String[] getSingletonNames() {
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public void registerSingleton(String beanName, Object bean) {
		if (BEANS.containsKey(beanName)) {
			throw new RuntimeException("[" + beanName + "] �Ѵ���");
		}
		BEANS.put(beanName, bean);
	}
}
