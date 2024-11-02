package com.programming.techie.springredditclone.service;

import com.programming.techie.springredditclone.dto.SubredditDto;
import com.programming.techie.springredditclone.exceptions.SpringRedditException;
import com.programming.techie.springredditclone.exceptions.SubredditNotFoundException;
import com.programming.techie.springredditclone.mapper.SubredditMapper;
import com.programming.techie.springredditclone.model.Subreddit;
import com.programming.techie.springredditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final AuthService authService;
    private final SubredditMapper subredditMapper;

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto) // map using Mapstruct
                //.map(this::mapToDto)
                .collect(toList());
    }

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto)); // map using Mapstruct
//        Subreddit subreddit = subredditRepository.save(mapToSubreddit(subredditDto)); // map using lombok
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit); // map using Mapstruct
//                .orElseThrow(() -> new SubredditNotFoundException("Subreddit not found with id -" + id));
//        return mapToDto(subreddit); // map using lombok
    }

    // map using @Builder from package lombok used in Spring
    private SubredditDto mapToDto(Subreddit subreddit) {
        return SubredditDto.builder()
                .name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                //.postCount(subreddit.getPosts().size())
                .build();
    }

    // map using @Builder from package lombok used in Spring
    private Subreddit mapToSubreddit(SubredditDto subredditDto) {
        return Subreddit.builder()
                .name("/r/" + subredditDto.getName())
                .description(subredditDto.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now())
                .build();
    }
}