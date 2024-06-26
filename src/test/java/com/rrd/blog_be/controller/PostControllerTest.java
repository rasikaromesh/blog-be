package com.rrd.blog_be.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rrd.blog_be.configuration.MongoDbConfig;
import com.rrd.blog_be.dto.PostDto;
import com.rrd.blog_be.model.*;
import com.rrd.blog_be.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
@Import(MongoDbConfig.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Autowired
    private ObjectMapper objectMapper;

    private Post post;
    private PostDto postDto;

    @BeforeEach
    void setUp() {
        ParagraphBlock paragraphBlock = new ParagraphBlock("This is a test paragraph.");
        HeadingBlock headingBlock = new HeadingBlock(1, "This is a test heading.");
        ImageBlock imageBlock = new ImageBlock("https://example.com/image.jpg", "This is a test image.");
        ListBlock listBlock = new ListBlock(List.of("This is a test list item.", "This is another test list item."));
        List<ContentBlock> contentBlockList = List.of(headingBlock, paragraphBlock, imageBlock, listBlock);
        post = new Post();
        post.setTitle("Test Title");
        post.setContent(contentBlockList);


        postDto = new PostDto();
        postDto.setTitle("Test Title");
        postDto.setContent(contentBlockList);
    }

    @Test
    void testGetAllPosts() throws Exception {
        List<Post> posts = Collections.singletonList(post);
        when(postService.getAllPost()).thenReturn(posts);

        mockMvc.perform(get("/api/v1/post/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(post.getTitle()));
    }

    @Test
    void testCreatePost() throws Exception {
        when(postService.createPost(any(PostDto.class))).thenReturn(post);

        mockMvc.perform(post("/api/v1/post/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(post.getTitle()))
                .andExpect(jsonPath("$.content[0].type").value("heading"))
                .andExpect(jsonPath("$.content[0].level").value(1))
                .andExpect(jsonPath("$.content[0].text").value("This is a test heading."))
                .andExpect(jsonPath("$.content[1].type").value("paragraph"))
                .andExpect(jsonPath("$.content[1].text").value("This is a test paragraph."))
                .andExpect(jsonPath("$.content[2].type").value("image"))
                .andExpect(jsonPath("$.content[2].src").value("https://example.com/image.jpg"))
                .andExpect(jsonPath("$.content[2].alt").value("This is a test image."))
                .andExpect(jsonPath("$.content[3].type").value("list"))
                .andExpect(jsonPath("$.content[3].items[0]").value("This is a test list item."));
    }

    /*@Test
    void testUpdatePost() throws Exception {
        when(postService.updatePost(any(UUID.class), any(PostDto.class))).thenReturn(post);

        mockMvc.perform(patch("/api/v1/post/{id}", post.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(post.getTitle()));
    }*/

    /*@Test
    void testDeletePost() throws Exception {
        UUID postId = post.getId();

        mockMvc.perform(delete("/api/v1/post/{id}", postId))
                .andExpect(status().isOk());

        Mockito.verify(postService).deletePost(postId);
    }*/
}
