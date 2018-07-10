package kr.co.sincweb.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		
		Object user = modelAndView.getModel().get("loginUser");
		System.out.println(">>>> postHandle interceptor session 시작");
		
		if(user != null) {
			System.out.println(">>>> postHandle interceptor session OK");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			
			Object dest =session.getAttribute("dest");
			
			response.sendRedirect(dest != null ? (String) dest : "/main.sinc");
		}
	
	}
	
}
