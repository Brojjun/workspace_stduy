package com.ssafy.config;
import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.ConfirmInterceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;



@Configuration
@MapperScan(basePackages = { "com.ssafy.**.mapper" })
public class WebMvcConfiguration implements WebMvcConfigurer{

	private ConfirmInterceptor comfirmInterceptor; 
	private final List<String> patterens = Arrays.asList("/article/*","/admin","/user/list");
	
	public WebMvcConfiguration(ConfirmInterceptor comfirmInterceptor) {
		super();
		this.comfirmInterceptor = comfirmInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(comfirmInterceptor).addPathPatterns(patterens);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		//.allowedOrigins("http://ssafy.com","https://localhost","http://127.0.0.1:8080");
		//.allowedMethods("GET","POST","UPDATE","DELETE"); // 비 권장
		.allowedMethods(RequestMethod.GET.name(), RequestMethod.POST.name())
		.allowedMethods("*")
		.maxAge(1000);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	 
	
}