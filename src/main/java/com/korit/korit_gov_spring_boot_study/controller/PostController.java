package com.korit.korit_gov_spring_boot_study.controller;

import com.korit.korit_gov_spring_boot_study.dto.Request.PostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Request.PostUpdateReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.PostRespDto;
import com.korit.korit_gov_spring_boot_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

/*    public PostController() {
        postService = PostService.getInstance();
    }*/

    @PostMapping("/add")
    public ResponseEntity<PostRespDto<?>> enrollPost(@RequestBody PostReqDto postReqDto) {
        return ResponseEntity.ok(postService.enrollPost(postReqDto));
    }

    @GetMapping("/id")
    public ResponseEntity<PostRespDto<?>> searchById(@RequestParam Integer postId) {
        return ResponseEntity.ok(postService.searchById(postId));
    }

    @GetMapping("/all")
    public ResponseEntity<PostRespDto<?>> searchAll() {
        return ResponseEntity.ok(postService.searchAll());
    }

    @GetMapping("/keyword")
    public ResponseEntity<PostRespDto<?>> searchByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(postService.searchByKeyword(keyword));
    }

    @PutMapping("/update")
    public ResponseEntity<PostRespDto<?>> updateById(@RequestBody PostUpdateReqDto postUpdateReqDto) {
        return ResponseEntity.ok(postService.updatePostById(postUpdateReqDto.getPostId(), postUpdateReqDto.getContent()));
    }
}
