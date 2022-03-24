package com.mehdisarf.services;

import com.mehdisarf.dao.MessageDAO;
import com.mehdisarf.models.Message;
import com.mehdisarf.models.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> messages = MessageDAO.getMessages();
    private Map<Long, Profile> profiles = MessageDAO.getProfiles();

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0)
            return null;

        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
