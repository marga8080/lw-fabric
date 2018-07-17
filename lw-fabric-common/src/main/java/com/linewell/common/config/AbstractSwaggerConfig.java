package com.linewell.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 需要使用Swagger的地方继承此类，在类上面配置@Configuration 并实现apiInfo()方法
 * 
 * @author mawei
 */
@EnableSwagger2
public abstract class AbstractSwaggerConfig implements WebMvcConfigurer {
	
	final Logger logger = LoggerFactory.getLogger(AbstractSwaggerConfig.class);
	
	 /**
     * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
     *  <!--swagger资源配置-->
     *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     * @param registry
     */
     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
         registry.addResourceHandler("/webjars*").addResourceLocations("classpath:/META-INF/resources/webjars/");
     }
     
	@Bean
	public Docket api() {
		logger.info("启动Swagger2 ===>");
		
		return new Docket(DocumentationType.SWAGGER_2)
		        	.groupName("fabric")
		            .select()  
		            .apis(RequestHandlerSelectors.any())  
		            .paths(PathSelectors.regex(apiPath()))  // 要过滤的api uri
		            .build()  
		            .apiInfo(apiInfo());  
	}

	public abstract ApiInfo apiInfo();
	
	/**
	 * 需要显示的api uri (正则表达式匹配)
	 * @return
	 */
	public abstract String apiPath();
	
}