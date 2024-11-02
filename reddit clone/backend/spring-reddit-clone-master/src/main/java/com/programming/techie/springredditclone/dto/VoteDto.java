package com.programming.techie.springredditclone.dto;

import com.programming.techie.springredditclone.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto { // represents the request coming in from the client
    private VoteType voteType;
    private Long postId;
}
