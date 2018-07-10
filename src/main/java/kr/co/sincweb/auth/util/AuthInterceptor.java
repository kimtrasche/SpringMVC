package kr.co.sincweb.auth.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	
	private void saveDest(HttpServletRequest request){
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		
		//get방식으로 호출하면 쿼리스트링의 값이 없기 때문에 조건필요
		if(queryString == null || queryString.equals("null")) {
			queryString = "";
		}else {
			queryString = "?" +  queryString;
		}
		
		if(request.getMethod().equals("GET")) {
			request.getSession().setAttribute("dest", uri + queryString);
		}
	}
		
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		System.out.println(">>> preHandle" );
		
		if(session.getAttribute("loginUser") == null) {
			saveDest(request);
			response.sendRedirect("/user/loginForm.sinc");
			return false;
		}
			
		return true;
		
	}
	
}
