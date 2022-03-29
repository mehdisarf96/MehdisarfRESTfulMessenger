package com.mehdisarf.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
    @Path("") va @Path("/") yekian va farqi nadaran.
    tuye URI va path, 'hichi' ro mituni ba '/' namayesh bedi.
 */
@Path("") // the class level @Path annotation is optional for sub resources.
public class CommentResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getComments() {
        return "test- this is in CommentResource.";
    }

    /*
        path nahaei:
        class-level path for root resource + method-level path for root resource
        + class-level path for sub resource + method-level path for sub resource
     */
    @Path("/{commentId}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getComment(@PathParam("messageId") long msgId, // u can access the parent resource path parameter as well in the sub resource.
                             @PathParam("commentId") long cmtId) {
        return "msg:" + msgId + " cmt:" + cmtId;
    }
}