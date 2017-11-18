package com.meiaida.jersey;

import com.meiaida.jersey.config.jaxrs.MeiAiDaFeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;


@SpringBootApplication
@EnableFeignClients(defaultConfiguration = {MeiAiDaFeignClientConfig.class})
@EnableDiscoveryClient
public class SpringCloudJerseyWebApplication {
	/**
	 * 解决中文内容编码问题，统一用UTF-8编码
	 */
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudJerseyWebApplication.class, args);
	}
}
