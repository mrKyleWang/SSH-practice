package com.itheima.struts.web.interceptor;

import com.itheima.struts.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user ==null) {
			ActionContext.getContext().getValueStack().set("errorMsg", "用户未登录!");
			return "login";
		}
		return invocation.invoke();
	}

}
