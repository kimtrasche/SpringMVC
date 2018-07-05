package kr.co.sincweb.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println(">> SampleInterceptor preHandle");

		HttpSession session = request.getSession();

		HandlerMethod method = (HandlerMethod) handler;

		Method methodObj = method.getMethod();
		Object bean = method.getBean();

		System.out.println("Method : " + methodObj);
		System.out.println("Bean : " + bean);

		return true;

		// return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println(">> SampleInterceptor postHandle");

		Object obj = modelAndView.getModel().get("msg");

		if (obj != null) {
			System.out.println(">> postHandle obj != null");
			request.getSession().setAttribute("msgSession", obj);
			response.sendRedirect("/session.sinc");
		}

		// super.postHandle(request, response, handler, modelAndView);
	}

}
