package com.livevote.eventproducer.service.events.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteCastPayload {
    private String voteId;
    private String pollId;
    private String optionId;
    private String userId;

    // Event creation timestamp
    private long createdAt;
}
