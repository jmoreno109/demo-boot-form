package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("TimeInterceptor")
public class TimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("*** TimeInterceptor: preHandle() entrando ***");
		logger.info("* Interceptando:" + handler);

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			logger.info("* Interceptando:" + handlerMethod.getMethod().getName());
		}

		long initTime = System.currentTimeMillis();
		request.setAttribute("initTime", initTime);
		Thread.sleep(500);

		response.sendRedirect(request.getContextPath().concat("/login")); // if return is false
		
		// return HandlerInterceptor.super.preHandle(request, response, handler);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		long initTime = (long) request.getAttribute("initTime");
		long finalTime = System.currentTimeMillis();

		long total = finalTime - initTime;

		if (handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("total", total);
		}

		logger.info("*** TimeInterceptor: postHandle() saliendo ***");

		// HandlerInterceptor.super.postHandle(request, response, handler,
		// modelAndView);
	}

}
