package com.mehdisarf.resources;

import com.mehdisarf.models.Message;
import com.mehdisarf.services.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
    }

    /*
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") String id) {
        return messageService.getMessage(Integer.parseInt(id));
    }

    // age type e method parameter e 'id' ro long bezari, jersey khodesh
    // bahushe va conversion ro anjam mide. va dg niaz nist mese bala
    // khodet biay dasti parse va convert ro anjam bedi.
     */

}
