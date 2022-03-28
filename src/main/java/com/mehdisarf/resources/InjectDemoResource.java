package com.mehdisarf.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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

    // tu method e bala, bayad esme un Matrix param ya header ya coockie ro midunesti.
    // vase @QueryParam va @PathParam ham be hamin shekl. bayad esm e un parameter ro beduni
    // ta betuni access them. ama age esm haro naduni chi? rahesh:
    @GET
    @Path("/context")
    @Produces(MediaType.TEXT_PLAIN)
    public String getParametersUsingContext(@Context UriInfo uriInfo,
                                            @Context HttpHeaders headers) { // @Context faqat be ye seri type e khas Apply mishe; mesle UriInfo, HttpHeaders.

        String absPath = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();

        return "path: " + absPath + " , Cookies: " + cookies;
    }
}

