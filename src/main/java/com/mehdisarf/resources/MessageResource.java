package com.mehdisarf.resources;

import com.mehdisarf.models.Link;
import com.mehdisarf.models.Message;
import com.mehdisarf.resources.beans.MessageFilterBean;
import com.mehdisarf.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;


@Path("/messages")
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getJsonMessages(@BeanParam MessageFilterBean filterBean) {

        System.out.println("JSON method called.");

        if (filterBean.getYrs() > 0)
            return messageService.getAllMessagesForYear(filterBean.getYrs());
        if (filterBean.getStrt() > 0 && filterBean.getSz() > 0)
            return messageService.getAllMessagesPaginated(filterBean.getStrt(), filterBean.getSz());

        return messageService.getAllMessages();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getXmlMessages(@BeanParam MessageFilterBean filterBean) {

        System.out.println("XML method called.");

        if (filterBean.getYrs() > 0)
            return messageService.getAllMessagesForYear(filterBean.getYrs());
        if (filterBean.getStrt() > 0 && filterBean.getSz() > 0)
            return messageService.getAllMessagesPaginated(filterBean.getStrt(), filterBean.getSz());

        return messageService.getAllMessages();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(Message message,
                                  @Context UriInfo uriInfo) { // Return Type alan Response E; instead of Message ke ghablan bud.

        // return messageService.addMessage(message);

        Message newMessage = messageService.addMessage(message);
        String idOfTheNewMessage = String.valueOf(newMessage.getId());

        // getAbsolutePath(): return mikone: http://localhost:8080/Mehdisarf_RESTful_Messenger_war_exploded/webapi/messages
        URI uri = uriInfo.getAbsolutePathBuilder().path(idOfTheNewMessage).build();

        return Response.created(uri) // created(): set both the status code 201 and the Location header of the new resource whenever u create any new resource.
                .entity(newMessage)
                .build();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId,
                              @Context UriInfo uriInfo) {

        Message theMessage = messageService.getMessage(messageId);

        String uri = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(Long.toString(theMessage.getId()))
                .build()
                .toString();
        Link link = new Link(uri, "self");
        theMessage.getLinks().add(link);

        String uriAuthor = uriInfo.getBaseUriBuilder()
                .path(ProfileResource.class)
                .path(theMessage.getAuthor())
                .build()
                .toString();
        Link link1 = new Link(uriAuthor, "author");
        theMessage.getLinks().add(link1);

        String uriComments = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class, "getCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId", messageId) // Resolve a URI template with a given name
                // in this UriBuilder instance using a supplied value.
                // alan inja bejaye {messageId}, bayad actual value jaygozin beshe.
                .build()
                .toString();
        Link link2 = new Link(uriComments, "comments");
        theMessage.getLinks().add(link2);


        return theMessage;
    }

    @PUT
    @Path("/{messageId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // inam be khast e dele khodam injur 2taii kardam ke ye mesal injur ham dashte basham.
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
