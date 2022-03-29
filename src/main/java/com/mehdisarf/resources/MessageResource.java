package com.mehdisarf.resources;

import com.mehdisarf.models.Message;
import com.mehdisarf.resources.beans.MessageFilterBean;
import com.mehdisarf.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    /*
    @BeanParam:
    The annotation that may be used to inject custom JAX-RS "parameter aggregator" value object
    into a resource class field, property or resource method parameter.
    The JAX-RS runtime will instantiate the object and inject all it's fields and properties
    annotated with either one of the @XxxParam annotation (@PathParam, @FormParam ...) or
    the @Context annotation.
    For the POJO classes same instantiation and injection rules apply as in case of
    instantiation and injection of request-scoped root resource classes.
     */
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYrs() > 0)
            return messageService.getAllMessagesForYear(filterBean.getYrs());
        if (filterBean.getStrt() > 0 && filterBean.getSz() > 0)
            return messageService.getAllMessagesPaginated(filterBean.getStrt(), filterBean.getSz());

        return messageService.getAllMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {

        return messageService.addMessage(message);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message) {

        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) { // Jersey ba didane 'void', 204 barmigardune.
        messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    // one of the way @Path may be used is on methods not annotated with resource method designators such as @GET or @POST.
    // Such methods are referred to as sub-resource locators.
    public CommentResource getCommentResource() { // the sub-resource locator method returns a new resource class.
        return new CommentResource();
    }
}
