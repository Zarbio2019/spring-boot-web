package com.programming.techie.springredditclone.mapper;

import com.programming.techie.springredditclone.dto.SubredditDto;
import com.programming.techie.springredditclone.model.Post;
import com.programming.techie.springredditclone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/*
This is how the generated class implementation looks like: SubredditMapperImpl.java
D:\ROMULO\PROJECTS\tech\backend\java\spring\springboot\projects\web\reddit clone\backend\spring-reddit-clone-master\target\generated-sources\annotations\com\programming\techie\springredditclone\mapper\SubredditMapperImpl.java
*/
@Mapper(componentModel = "spring") // annotation for Mapstruct Mapper
public interface SubredditMapper {

    // map Subreddit to SubredditDto
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))") // this field Subreddit.(List<Post> posts) is not straight forward, by that apply @Mapping:
                                                                                            // from Subreddit.(List<Post> posts) to SubredditDto.(Integer numberOfPosts) -> subreddit.getPosts()
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    // map SubredditDto to Subreddit
    @InheritInverseConfiguration // create reverse mappings from SubredditDto to Subreddit
    @Mapping(target = "posts", ignore = true) // ignore Subreddit.(List<Post> posts)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}