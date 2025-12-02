package com.livevote.eventproducer.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteCastEvent extends BaseEvent{
    private String voteId;
    private String pollId;
    private String optionId;
    private String userId;
    private long createdAt;
}
