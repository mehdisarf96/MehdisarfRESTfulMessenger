package com.mehdisarf.resources;

import com.mehdisarf.models.Message;
import com.mehdisarf.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {

        return messageService.addMessage(message);
    }

    /*
    // temporary for test

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createMessage() {
        return "Post Post";
    }
     */

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }


}
