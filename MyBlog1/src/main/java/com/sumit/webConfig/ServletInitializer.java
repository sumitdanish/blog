package com.sumit.webConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletInitializer extends AbstractDispatcherServletInitializer{
	@Override
	protected WebApplicationContext createServletApplicationContext() {
		System.out.println("init..createServletApplicationContext..");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		///context.register(SecurityConfig.class, WebConfiguration.class);
		context.scan(ClassUtils.getPackageName(getClass()));
		return context;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("init..mapping / ..");
		return new String[] { "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return null;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		System.out.println("inint .. OnStartUp..");
		registerProxyFilter(servletContext, "springSecurityFilterChain");
		/*registerProxyFilter(servletContext, "oauth2ClientContextFilter");*/
	}

	private void registerProxyFilter(ServletContext servletContext, String name) {
		System.out.println("init .. Register Proxy..");
		DelegatingFilterProxy filter = new DelegatingFilterProxy(name);
		filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
		servletContext.addFilter(name, filter).addMappingForUrlPatterns(null, false, "/*");
	}
}
