package com.example.commentapi.service;

import com.example.commentapi.model.CommentRequest;
import com.example.commentapi.model.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse createComment(CommentRequest commentRequest);
    CommentResponse updateComment(CommentRequest commentRequest);
    CommentResponse getCommentById(String commentId);
    List<CommentResponse> getAllComments();
    void deletePaymentById(String commentId);


}
