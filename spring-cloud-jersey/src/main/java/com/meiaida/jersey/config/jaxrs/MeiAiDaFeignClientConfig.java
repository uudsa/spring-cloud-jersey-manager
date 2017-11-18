package com.meiaida.jersey.config.jaxrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import feign.Contract;

/**
 * 覆盖Spring Cloud Feign Client的默认配置
 * 
 */
@Configuration
public class MeiAiDaFeignClientConfig {

	// 使用JAX-RS 1.1 注解格式
	@Bean
	public Contract feignContract() {
		return new JAXRSContract();
	}
}
