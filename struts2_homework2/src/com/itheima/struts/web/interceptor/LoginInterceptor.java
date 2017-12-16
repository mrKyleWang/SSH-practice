package com.itheima.struts.web.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.codehaus.jackson.map.ObjectMapper;

import com.itheima.struts.VO.ResultVO;
import com.itheima.struts.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends MethodFilterInterceptor{
	
	
	private String LOGIN = "/struts2_homework2/login.html";

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User existUser = (User) ActionContext.getContext().getSession().get("user");
		if(existUser==null) {
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(ResultVO.error("用户名未登录",LOGIN));
			ActionContext actionContext = invocation.getInvocationContext();     
			HttpServletResponse response= (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE); 
			response.getWriter().write(jsonString);
			return null;
		}
		return invocation.invoke();
	}
}
