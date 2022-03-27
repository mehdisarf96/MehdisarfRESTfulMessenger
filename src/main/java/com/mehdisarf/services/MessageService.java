package com.mehdisarf.services;

import com.mehdisarf.dao.MessageDAO;
import com.mehdisarf.models.Message;
import com.mehdisarf.models.Profile;

import java.util.*;

public class MessageService {

    private Map<Long, Message> messages = MessageDAO.getMessages();

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();

        // vase kar ba 'year' e message hamun, az calendar estefade.
        // ba calendar rahat mituni Date ro besh bedi va vasat year esh ro birun bekeshe.
        Calendar calendar = Calendar.getInstance();

        for (Message message : messages.values()) {
            calendar.setTime(message.getCreated());

            if (calendar.get(Calendar.YEAR) == year)
                messagesForYear.add(message);
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int startPoint, int size) {
        List<Message> messageList = new ArrayList<>(messages.values());

        if (startPoint + size > messageList.size())
            return new ArrayList<>();

        // ex: user mige st:3 sz:5 yani dar list az 2 ta 6. baraye in bayad subList(2,7)
        return messageList.subList(startPoint - 1, (startPoint - 1) + size);
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
