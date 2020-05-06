package com.jongwan.fun.domain.controller.post;

import com.jongwan.fun.domain.controller.post.vo.CreatePostRequest;
import com.jongwan.fun.domain.controller.post.vo.PostsRequest;
import com.jongwan.fun.domain.model.post.Post;
import com.jongwan.fun.domain.service.post.PostService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@GraphQLApi
@Controller
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GraphQLQuery
    public Post post(@GraphQLArgument(name = "id") String id) {
        return postService.getPost(id);
    }

    @GraphQLQuery
    public List<Post> posts(@GraphQLArgument(name = "request") PostsRequest request) {
        return postService.getPosts(request.getCategoryId(), request.getPageable());
    }

    @GraphQLMutation
    public Post createPost(CreatePostRequest post) {
        Post newPost = Post.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .build();
        return postService.create(newPost);
    }

    @GraphQLMutation
    public Post updatePost(@GraphQLArgument(name = "id") String id, CreatePostRequest post) {
        return postService.update(id, post.getTitle(), post.getContents());
    }

}
