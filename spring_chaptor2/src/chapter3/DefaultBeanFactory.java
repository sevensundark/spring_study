package chapter3;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

public class DefaultBeanFactory {
	// Bean����ע���
	private BeanDifinitionRegister DEFINITIONS = new BeanDifinitionRegister();

	// ����ע���
	private final SingletonBeanRegistry SINGLETONS = new SingletonBeanRegister();

	public Object getBean(String beanName) {
		// 1.��֤Bean�����Ƿ����
		if (!DEFINITIONS.containsBeanDefinition(beanName)) {
			throw new RuntimeException("������[" + beanName + "]Bean����");
		}
		// 2.��ȡBean����
		BeanDefinition bd = DEFINITIONS.getBeanDefinition(beanName);
		// 3.�Ƿ��Bean�����ǵ���������
		if (bd.getScope() == BeanDefinition.SCOPE_SINGLETON) {
			// 3.1 �������ע������Bean����ֱ�ӷ��ظ�Bean
			if (SINGLETONS.containsSingleton(beanName)) {
				return SINGLETONS.getSingleton(beanName);
			}
			// 3.2����ע���������Bean��
			// �򴴽���ע�ᵽ����ע����Ӷ�����
			SINGLETONS.registerSingleton(beanName, createBean(bd));
			return SINGLETONS.getSingleton(beanName);
		}
		// 4.�����ԭ��Bean����,��ֱ�ӷ��ظ���Bean���崴������Bean��
		// ÿ�ζ����µģ��޻���
		if (bd.getScope() == BeanDefinition.SCOPE_PROTOTYPE) {
			return createBean(bd);
		}
		// 5.������������Bean����
		throw new RuntimeException("�����Bean����");
	}

	public void registerBeanDefinition(BeanDefinition bd) {
		DEFINITIONS.registerBeanDefinition(bd.getId(), bd);
	}

	private Object createBean(BeanDefinition bd) {
		// ����Bean���崴��Bean
		try {
			Class clazz = Class.forName(bd.getClazz());
			// ͨ������ʹ���޲�������������Bean
			return clazz.getConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("û���ҵ�Bean[" + bd.getId() + "]��");
		} catch (Exception e) {
			throw new RuntimeException("����Bean[" + bd.getId() + "]ʧ��");
		}
	}
}
