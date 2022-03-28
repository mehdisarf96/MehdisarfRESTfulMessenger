package com.mehdisarf.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
public class InjectDemoResource {

    @GET
    @Path("/annotation")
    @Produces(MediaType.TEXT_PLAIN)
    public String getParametersUsingAnnotations(@MatrixParam("mtparam") String matrixParameter,
                                                @HeaderParam("customMehdiParam") String mehdiParameter,
                                                @CookieParam("mehdiCookie") String theCookie) {

        return "this is matrix parameter: " + matrixParameter + " ,this is custom Mehdi Parameter: " + mehdiParameter +
                " and finally this is cookie: " + theCookie;
    }

    // http://localhost:8080/Mehdisarf_RESTful_Messenger_war_exploded/webapi/injectdemo/annotation?mtparam=mava  mtparam: a query parameter
    // http://localhost:8080/Mehdisarf_RESTful_Messenger_war_exploded/webapi/injectdemo/annotation;mtparam=mava  mtparam: a matrix parameter
}

