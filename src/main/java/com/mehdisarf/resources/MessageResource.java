package com.mehdisarf.resources;

import com.mehdisarf.models.Message;
import com.mehdisarf.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    // shoma age '/messages?harchizi' bezani, baz map mishe be hamin method.
    @GET
    public List<Message> getMessages(@QueryParam("year") int yrs,
                                     @QueryParam("start") int strt,
                                     @QueryParam("size") int sz) { // age chizi ersal nashode bashe, tabiatan chon int e, nemitune null esh kone. leza 0 mide.
        if (yrs > 0)
            return messageService.getAllMessagesForYear(yrs);
        if (strt > 0 && sz > 0)
            return messageService.getAllMessagesPaginated(strt, sz);

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
}
