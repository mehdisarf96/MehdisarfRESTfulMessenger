package com.mehdisarf.services;

import com.mehdisarf.dao.MessageDAO;
import com.mehdisarf.models.Comment;
import com.mehdisarf.models.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long, Message> messages = MessageDAO.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Message theMessage = messages.get(messageId);
        Map<Long, Comment> commentsOfTheMessage = theMessage.getComments();

        comment.setId(commentsOfTheMessage.size() + 1);

        commentsOfTheMessage.put(comment.getId(), comment);

        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        if (comment.getId() <= 0)
            return null;

        Message theMessage = messages.get(messageId);
        Map<Long, Comment> commentsOfTheMessage = theMessage.getComments();

        commentsOfTheMessage.put(comment.getId(), comment);

        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {

        Message theMessage = messages.get(messageId);
        Map<Long, Comment> commentsOfTheMessage = theMessage.getComments();

        return commentsOfTheMessage.remove(commentId);
    }
}
