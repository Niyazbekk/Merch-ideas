package com.example.commentapi.controller;

import com.example.commentapi.model.CommentRequest;
import com.example.commentapi.model.CommentResponse;
import com.example.commentapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest);
    }

    @PutMapping
    public CommentResponse updateComment(@RequestParam String commentId,
                                         @RequestBody CommentRequest commentRequest) {
        commentRequest.setCommentId(commentId);
        return commentService.updateComment(commentRequest);
    }

    @GetMapping("/all")
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }
    @GetMapping
    public CommentResponse getCommentById(@RequestParam String commentId){
        return commentService.getCommentById(commentId);
    }
    @DeleteMapping
    public void deleteComment(@RequestParam String commentId){
        commentService.deletePaymentById(commentId);
    }
}
