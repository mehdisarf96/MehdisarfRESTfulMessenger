package com.mehdisarf.resources;

import com.mehdisarf.models.Comment;
import com.mehdisarf.models.Profile;
import com.mehdisarf.services.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
    @Path("") va @Path("/") yekian va farqi nadaran.
    tuye URI va path, 'hichi' ro mituni ba '/' namayesh bedi.
 */

@Path("") // the class level @Path annotation is optional for sub resources.
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment createComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @Path("/{commentId}") // masalan in mishe: /messages/{messageId}/comments/{commentId}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @Path("/{commentId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long commentId,
                                 Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void removeComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        commentService.removeComment(messageId, commentId);
    }

/*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getComments() {
        return "test- this is in CommentResource.";
    }
 */

    /*
        path nahaei:
        class-level path for root resource + method-level path for root resource
        + class-level path for sub resource + method-level path for sub resource
     */

    /*
    @Path("/{commentId}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getComment(@PathParam("messageId") long msgId, // u can access the parent resource path parameter as well in the sub resource.
                             @PathParam("commentId") long cmtId) {
        return "msg:" + msgId + " cmt:" + cmtId;
    }
    */
}
