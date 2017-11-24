package com.meiaida.jersey;

import com.meiaida.jersey.config.jaxrs.MeiAiDaFeignClientConfig;
import com.meiaida.jersey.config.swagger.SwaggerConfiger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@Controller
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = {MeiAiDaFeignClientConfig.class})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com"})
public class SpringCloudJerseyApplication implements CommandLineRunner {
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

		SpringApplication.run(SpringCloudJerseyApplication.class, args);

	}
	/**
	 * 跳转swagger主页
	 **/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectSwaggerIndexhtml() {
		return "redirect:/swagger/index.html";
	}

	@Override
	public void run(String... args) throws Exception {
		// 配置swagger
		SwaggerConfiger.initSwagger("SpringCloudJersey", "SpringCloudJersey接口");
	}
}
