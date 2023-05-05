package com.zzm.controller;

import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.ForumReply;
import com.zzm.service.forum.ForumReplyService;
import com.zzm.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forumReply")
public class ForumReplyController {

    @Autowired
    private ForumReplyService forumReplyService;
    @Autowired
    private ForumService forumService;
    @PostMapping("/add")
    public ResponseEntity<ForumReply> addReply(@RequestBody ForumReply forumReplyDTO) {
        ForumReply newReply = forumReplyService.addReply(forumReplyDTO);
        return new ResponseEntity<>(newReply, HttpStatus.CREATED);
    }

}
