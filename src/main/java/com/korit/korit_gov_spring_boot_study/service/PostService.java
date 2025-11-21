package com.korit.korit_gov_spring_boot_study.service;

import com.korit.korit_gov_spring_boot_study.dto.Request.PostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.PostRespDto;
import com.korit.korit_gov_spring_boot_study.entity.Post;
import com.korit.korit_gov_spring_boot_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
/*    private static PostService instance;
    private PostService() {
        postRepository = PostRepository.getInstance();
    }
    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }*/ //IOC 사용시 싱글톤 사용 x

    PostRespDto<?> postRespDto = null;

    public PostRespDto<?> enrollPost(PostReqDto postReqDto) {
        if (postRepository.searchTitle(postReqDto.getTitle()) != null) {
            return postRespDto = PostRespDto.builder()
                    .status("failed")
                    .message("중복된 title 입니다.")
                    .build();
        }
        postRepository.addPost(postReqDto.toEntity());
        return postRespDto = PostRespDto.<PostReqDto>builder()
                .status("success")
                .message("post 등록 완료")
                .data(postReqDto)
                .build();
    }

    public PostRespDto<?> searchById(Integer postId) {
        if (postRepository.searchId(postId) == null) {
            return postRespDto = PostRespDto.builder()
                    .status("failed")
                    .message("post가 존재 하지 않습니다")
                    .build();
        }
        return postRespDto = PostRespDto.<Post>builder()
                .status("success")
                .message("post 조회 완료")
                .data(postRepository.searchId(postId))
                .build();
    }

    public PostRespDto<?> searchAll() {
        return postRespDto = PostRespDto.<List<Post>>builder()
                .status("success")
                .message("post 전체 조회 완료")
                .data(postRepository.searchPostAll())
                .build();
    }

    public PostRespDto<?> searchByKeyword(String keyword) {
        return postRespDto = PostRespDto.<List<Post>>builder()
                .status("success")
                .message("keyword 조회 완료")
                .data(postRepository.searchKeyword(keyword))
                .build();
    }

    public PostRespDto<?> updatePostById(Integer postId, String content) {
        Post updatedPost = postRepository.updatePost(postId, content);

        if (updatedPost == null) {
            return PostRespDto.<Post>builder()
                    .status("failed")
                    .message("해당 ID의 게시글이 없습니다.")
                    .data(null)
                    .build();
        }

        return PostRespDto.<Post>builder()
                .status("success")
                .message("content 수정 완료")
                .data(updatedPost)
                .build();
    }
}
