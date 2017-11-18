/**
 * Author:   no.191
 * Date:     2017/11/13 9:45
 * Description: controller
 */
package com.meiaida.jersey.resource;

import com.meiaida.jersey.resource.feignClient.SeyHelloFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@RestController
public class HelloWordResource {

    Logger logger = LoggerFactory.getLogger(HelloWordResource.class);
    @Autowired
    private SeyHelloFeign seyHelloFeign;

    @RequestMapping(value = "/seyHello",method = RequestMethod.GET)
    public String seyHello(){
        return seyHelloFeign.seyHello("tim").getBody();
    }
}
