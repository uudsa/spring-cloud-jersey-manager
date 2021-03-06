/**
 * Author:   no.191
 * Date:     2017/11/13 9:45
 * Description: controller
 */
package com.meiaida.jersey.resource;

import com.meiaida.jersey.resource.feignClient.SeyHelloFeign;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
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

@Path("/ok")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "test接口", description = "test接口", produces = MediaType.APPLICATION_JSON)
public class HelloWordResource {

    Logger logger = LoggerFactory.getLogger(HelloWordResource.class);
    @Autowired
    private SeyHelloFeign seyHelloFeign;

    @GET
    @Path("/seyHello")
    @ApiOperation(value = "hello", notes = "hello")
    public void seyHello(){
        logger.info("kaishi");
        System.out.println(seyHelloFeign.seyHello("tim").getBody().toString());
        logger.info("结束");
    }
}
