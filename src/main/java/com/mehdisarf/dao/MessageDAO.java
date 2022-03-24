package com.mehdisarf.dao;

import com.mehdisarf.models.Message;
import com.mehdisarf.models.Profile;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageDAO { // Message DAO (Stub)

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    static {
        messages.put(1L,new Message(1L,"Hello World!",new Date(),"Mehdi"));
        messages.put(2L,new Message(2L,"Hello Jersey",new Date(),"Mehdi"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<Long, Profile> getProfiles() {
        return profiles;
    }
}
