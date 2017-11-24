/**
 * Author:   no.191
 * Date:     2017/11/20 19:21
 * Description: swagger
 */
package com.meiaida.jersey.config.swagger;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jersey.JerseyApiReader;
import com.wordnik.swagger.model.ApiInfo;
import com.wordnik.swagger.reader.ClassReader;
import com.wordnik.swagger.reader.ClassReaders;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SwaggerConfiger extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/","classpath:/templates/","classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    public static void initSwagger(String title, String description) {
        //SwaggerConfig swaggerConfig
        SwaggerConfig swaggerConfig = ConfigFactory.config();
        swaggerConfig.setBasePath("/v1");
        swaggerConfig.setApiVersion("1.0.0");
        if (StringUtils.isBlank(description)){
            description = title;
        }

        swaggerConfig.setApiInfo(new ApiInfo(
                title,
                "<a href=\"/api\" target = \"_blank\">" + description + "</a>",
                null,
                null,
                null,
                null
        ));
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new JerseyApiReader());
    }

}
