package com.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.LoginBean;


@WebFilter 
public class LoginFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		try {
			LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
			
			if (loginBean == null || !loginBean.isLogin()) {
				String contextPath = ((HttpServletRequest)request).getContextPath();
				System.out.println(contextPath);
				((HttpServletResponse)response).sendRedirect(contextPath + "/login.xhtml");
			}
			
			else {
			chain.doFilter(request, response);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void init(FilterConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}	
	
}
