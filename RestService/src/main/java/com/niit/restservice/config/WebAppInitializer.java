package com.niit.restservice.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.niit")

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("root config");
		return new Class[] {WebConfiguration.class,WebSocketConfig.class};
	}
	
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}
	
	//first part of copy(here servletRegistration is imported)
//	 @Override
//	  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//	    registration.setInitParameter("dispatchOptionsRequest", "true");
//	    registration.setAsyncSupported(true);
//	  }
	
	
	
	
	
	

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}
	
	
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		logger.debug("Starting of the metnod customizeRegistration");
		//String path = "resources/img/";
		String path = "D://Collaboration";
        File uploadDirectory = new File(path);

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

        registration.setMultipartConfig(multipartConfigElement);
        logger.debug("Ending of the metnod customizeRegistration");
    }
	
	
	
	
	
	
	
	/*//getting specialcode(importing characterEncodingFilter,f)
	@Override
	  protected Filter[] getServletFilters() {
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
	    return new Filter[] { characterEncodingFilter };
	  }
	*/
	

}


