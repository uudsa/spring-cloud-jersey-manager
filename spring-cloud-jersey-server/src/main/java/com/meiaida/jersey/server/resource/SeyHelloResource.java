/**
 * Author:   no.191
 * Date:     2017/11/13 10:11
 * Description: resource-server
 */
package com.meiaida.jersey.server.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class SeyHelloResource {
    Logger logger = LoggerFactory.getLogger(SeyHelloResource.class);
    @GET
    @Path("/seyHello")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response seyHello( @QueryParam("name") String name) {
        try {
        } catch (Exception ex) {
            logger.info("新增优惠券日志异常",ex);
            return Response.status(500).entity(ex.getMessage()).build();

        }
        return Response.ok().entity(name+",你好！").build();
    }
}
