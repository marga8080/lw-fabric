package com.linewell.fabric.console.config;

import org.springframework.context.annotation.Configuration;

import com.linewell.common.config.AbstractSwaggerConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


@Configuration
public class SwaggerConfig extends AbstractSwaggerConfig {

	@Override
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("fabric控制台").description("©2017 Copyright. Powered By linewell.").version("1.0").build();
	}

	@Override
	public String apiPath() {
		return "/web/.*|/api/.*";
	}  

}
