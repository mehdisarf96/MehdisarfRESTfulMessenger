package com.mehdisarf.services;

import com.mehdisarf.models.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages() {

        Message m1 = new Message(1, "Hello World!", new Date(), "Mehdi");
        Message m2 = new Message(2, "Hello Jersey!", new Date(), "Mehdi");

        List<Message> messages = new ArrayList<>();

        messages.add(m1);
        messages.add(m2);

        return messages;
    }
}
