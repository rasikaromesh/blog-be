package com.rrd.blog_be.service;

import com.rrd.blog_be.dto.PostDto;
import com.rrd.blog_be.model.Post;
import com.rrd.blog_be.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post createPost(PostDto postDto) {
        return postRepository.save(mapToEntity(postDto));
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }

    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(UUID id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return postRepository.save(post);
    }
}
