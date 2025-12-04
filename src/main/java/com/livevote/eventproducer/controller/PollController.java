package com.livevote.eventproducer.controller;

import com.livevote.eventproducer.dto.CreatePollRequestDto;
import com.livevote.eventproducer.dto.VoteCreateRequestDto;
import com.livevote.eventproducer.service.PollCreateService;
import com.livevote.eventproducer.service.VoteCastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/poll")
public class PollController {

    private final PollCreateService pollCreateService;
    private final VoteCastService voteCastService;

    public PollController(PollCreateService pollCreateService, VoteCastService voteCastService) {
        this.pollCreateService = pollCreateService;
        this.voteCastService = voteCastService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPoll(@RequestBody CreatePollRequestDto pollData) {
        pollCreateService.create(pollData);
        return ResponseEntity.ok("Poll created event sent");
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody VoteCreateRequestDto voteData) {
        voteCastService.create(voteData);
        return ResponseEntity.ok("Vote cast event sent");
    }
}

