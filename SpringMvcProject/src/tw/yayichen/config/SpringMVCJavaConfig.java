package tw.yayichen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//等同於mvc.servlet.xml
@Configuration
@EnableWebMvc //等同於<mvc:annotation-driven/>
@ComponentScan(basePackages = {"tw.yayichen"}) //等同於<context:component-scan base-package="tw.yayichen"/>
public class SpringMVCJavaConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//configureDefaultServletHandling用來將指定的組態檔覆載Override預設的組態檔設定enable()允許啟用 -> 代表可進行<bean>的註冊
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}
	//透過虛擬路徑 localhost:8080/SpringMvcProject/images/banner-01.jpg 即可找到圖片
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:membersentry.contoller");
	}
	//輸入 localhost:8080/SpringMvcProject/ 就可以導到 localhost:8080/SpringMvcProject/membersentry.contoller
	
	
	//設定MultipartResolver處理器上傳檔案
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmpartResolver = new CommonsMultipartResolver();
		cmpartResolver.setDefaultEncoding("UTF-8");
		return cmpartResolver;
	}
	
}
