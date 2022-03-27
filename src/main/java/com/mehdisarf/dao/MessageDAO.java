package com.mehdisarf.dao;

import com.mehdisarf.models.Message;
import com.mehdisarf.models.Profile;

import java.util.*;

public class MessageDAO { // Message DAO (Stub)

    private static Map<Long, Message> messages = new HashMap<>();

    static {
        messages.put(1L, new Message(1L, "Hello World!", getDate(2013, 2, 16), "Mehdi"));
        messages.put(2L, new Message(2L, "Hello Jersey", new Date(), "Mehdi"));
        messages.put(3L, new Message(3L, "Hello AA", getDate(2013, 10, 06), "GG"));
        messages.put(4L, new Message(4L, "Hello BB", getDate(2013, 12, 27), "FF"));
        messages.put(5L, new Message(5L, "Hello CC", getDate(2019, 4, 25), "RR"));
        messages.put(6L, new Message(6L, "Hello DD", getDate(2021, 7, 13), "TT"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    private static Date getDate(int year, int month, int dayOfMonth) {
        return new GregorianCalendar(year, month - 1, dayOfMonth).getTime();
    }
}
