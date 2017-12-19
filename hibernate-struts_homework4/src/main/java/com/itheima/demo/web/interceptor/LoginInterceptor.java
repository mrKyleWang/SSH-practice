package com.itheima.demo.web.interceptor;

import com.itheima.demo.VO.ResultVO;
import com.itheima.demo.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.StrutsStatics;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginInterceptor extends MethodFilterInterceptor{
	
	
	private String LOGIN = "/hibernate-struts_homework4/login.html";

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
