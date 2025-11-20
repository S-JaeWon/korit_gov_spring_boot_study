package com.korit.korit_gov_spring_boot_study.controller;

import com.korit.korit_gov_spring_boot_study.dto.Request.PostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.PostRespDto;
import com.korit.korit_gov_spring_boot_study.service.PostService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.RequestEntity.*;

@RestController
public class PostController {
    private PostService postService;

    public PostController() {
        postService = PostService.getInstance();
    }

    @PostMapping("/post")
    public ResponseEntity<PostRespDto<?>> enrollPost(@RequestBody PostReqDto postReqDto) {
        return ResponseEntity.ok(postService.enrollPost(postReqDto));
    }

    @GetMapping("/post/id")
    public ResponseEntity<PostRespDto<?>> searchById(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.searchById(postId));
    }

    @GetMapping("/post")
    public ResponseEntity<PostRespDto<?>> searchAll() {
        return ResponseEntity.ok(postService.searchAll());
    }

    @GetMapping("/post/keyword")
    public ResponseEntity<PostRespDto<?>> searchByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(postService.searchByKeyword(keyword));
    }

    @PutMapping("/post")
    public ResponseEntity<PostRespDto<?>> updateById(@RequestBody Integer postId, String content) {
        return ResponseEntity.ok(postService.updatePostById(postId, content));
    }
}
