package com.rrd.blog_be.controller;

import ch.qos.logback.classic.Logger;
import com.rrd.blog_be.dto.PostDto;
import com.rrd.blog_be.model.Post;
import com.rrd.blog_be.service.PostService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @PostMapping("/")
    public Post createPost(@RequestBody PostDto postDto) {
        logger.info("Creating post: {}", postDto);
        return postService.createPost(postDto);
    }

    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
    }
}
