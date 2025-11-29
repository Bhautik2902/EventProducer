package com.livevote.eventproducer.controller;

import com.livevote.eventproducer.dto.CreatePollRequest;
import com.livevote.eventproducer.dto.VoteRequest;
import com.livevote.eventproducer.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping("/create")
    public ResponseEntity<String> createPoll(@RequestBody CreatePollRequest pollData) {
        pollService.createPoll(pollData);
        return ResponseEntity.ok("Poll created event sent");
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody VoteRequest voteData) {
        pollService.vote(voteData);
        return ResponseEntity.ok("Vote cast event sent");
    }
}

