package com.meiaida.jersey.resource.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@FeignClient(name="spring-cloud-service")
@Path("/v1/hello")
public interface SeyHelloFeign {
    @GET
    @Path("/seyHello")
    ResponseEntity<String> seyHello(@QueryParam("name") String name);
}
