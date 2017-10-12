package com.scut.mybatis.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String flag = (String) request.getParameter("name");
		System.out.println(flag);
		if(flag.equals("google")){
			request.getSession().setAttribute("sessionAttribute","google---session");
		}else if (flag.equals("firefox")){
			request.getSession().setAttribute("sessionAttribute","firefox---session");
		}

		/**拦截器放行*/
		return super.preHandle(request, response, handler);
   }
    
}
