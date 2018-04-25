package com.yash.userapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class UserAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { UserAppConfiguration.class };
	}

	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ };
	}
	
}
