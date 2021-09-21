package tw.yayichen.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//等同於web.xml
public class WebAppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override  //用來設定等同於beans.config.xml
	protected Class<?>[] getRootConfigClasses() {	
		return new Class[] {RootAppConfig.class};
		//return null;
	}

	@Override  //用來設定等同於mvc-servlet.xml
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMVCJavaConfig.class};
		//return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		
		return new Filter[] {encodingFilter, hiddenHttpMethodFilter};
	}

}
