package com.jongwan.fun.domain.repository.post;

import com.jongwan.fun.domain.model.post.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findByCategory_CategoryId(String categoryId, Pageable pageable);

} 
