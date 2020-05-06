package com.jongwan.fun.domain.service.post;

import com.jongwan.fun.common.error.FunExceptionCode;
import com.jongwan.fun.domain.model.post.Post;
import com.jongwan.fun.domain.repository.category.CategoryRepository;
import com.jongwan.fun.domain.repository.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public Post getPost(String id) {
        return postRepository.findById(id).orElseThrow(() -> FunExceptionCode.POST_NOT_FOUND.newInstance(id));
    }

    public List<Post> getPosts(String categoryId, Pageable pageable) {
        if (!categoryRepository.findById(categoryId).isPresent()) {
            throw FunExceptionCode.CATEGORY_NOT_FOUND.newInstance(categoryId);
        }

        return postRepository.findByCategory_CategoryId(categoryId, pageable);
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post update(String postId, String title, String contents) {
        Post updatedPost = postRepository.findById(postId).orElseThrow(() -> FunExceptionCode.POST_NOT_FOUND.newInstance(postId));
        updatedPost.setTitle(title);
        updatedPost.setContents(contents);
        updatedPost.setUpdatedDatetime(ZonedDateTime.now());
        return postRepository.save(updatedPost);
    }

}
