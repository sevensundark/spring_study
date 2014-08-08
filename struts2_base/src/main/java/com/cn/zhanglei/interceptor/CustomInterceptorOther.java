package com.cn.zhanglei.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class CustomInterceptorOther extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------------CustomInterceptor excute-----------other-----");
		invocation.addPreResultListener(new CustomListener());
		return invocation.invoke();
	}

	public class CustomListener implements PreResultListener {

		@Override
		public void beforeResult(ActionInvocation PreResultListener, String resultCode) {
			System.out.println("------------after action excuted-----------" + resultCode + "===============other-----");
			
		}
		
	}
	
}
