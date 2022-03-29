package com.mehdisarf.dao;

import com.mehdisarf.models.Comment;
import com.mehdisarf.models.Message;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CommentDAO {

    private static Map<Long, Comment> comments = new HashMap<>();

    static {
        comments.put(1L, new Comment(1L, "nice!", "af"));
        comments.put(2L, new Comment(2L, "beautiful!", "me"));
        comments.put(3L, new Comment(3L, "augh!", "ro"));
        comments.put(4L, new Comment(4L, "ish!", "fo"));
        comments.put(5L, new Comment(5L, "ouch!", "zi"));
    }

    public static Map<Long, Comment> getComments() {
        return comments;
    }
}
