package chapter3;

import java.util.HashMap;
import java.util.Map;

public class BeanDifinitionRegister {
	// bean���建�棬�˴������ǲ�������
	private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<String, BeanDefinition>();

	public void registerBeanDefinition(String beanName, BeanDefinition bd) {
		// 1.��ʵ�ֲ�������Bean����
		if (DEFINITIONS.containsKey(bd.getId())) {
			throw new RuntimeException("�Ѵ���Bean���壬��ʵ�ֲ�������");
		}
		// 2.��Bean�������Bean���建���
		DEFINITIONS.put(bd.getId(), bd);
	}

	public BeanDefinition getBeanDefinition(String beanName) {
		return DEFINITIONS.get(beanName);
	}

	public boolean containsBeanDefinition(String beanName) {
		return DEFINITIONS.containsKey(beanName);
	}
}
