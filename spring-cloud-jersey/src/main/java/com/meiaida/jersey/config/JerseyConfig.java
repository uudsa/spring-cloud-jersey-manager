/**
 * Author:   no.191
 * Date:     2017/11/9 10:17
 * Description: jersey config
 */
package com.meiaida.jersey.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        register(provider);
        //想让jersey托管的部分需要加入扫描,或者使用register指定托管类也可以
        String packageName = JerseyConfig.class.getPackage().getName();
        packages(packageName.substring(0, packageName.lastIndexOf('.')) +".resource");
    }
}
