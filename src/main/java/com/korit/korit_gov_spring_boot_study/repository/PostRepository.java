package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private List<Post> postList;
    private PostRepository() {
        postList = new ArrayList<>();
    }
/*    private static PostRepository instance;
    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }*/ //IOC 사용시 싱글톤 사용 x

    public Post searchTitle(String title) {
        return postList.stream()
                .filter(post -> post.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public void addPost(Post post) {
        post.setPostId(postList.size() + 1);
        postList.add(post);
    }

    public List<Post> searchKeyword(String keyword) {
        return postList.stream()
                .filter(post -> post.getTitle().contains(keyword))
                .toList();
    }

    public List<Post> searchPostAll() {
        return postList;
    }

    public Post searchId(Integer postId) {
        return postList.stream()
                .filter(post -> post.getPostId().equals(postId))
                .findFirst()
                .orElse(null);
    }

    public Post updatePost(Integer postId, String content) {
        for (Post post : postList) {
            if (post.getPostId().equals(postId)) {
                post.setContent(content);
                return post;
            }
        }
        return null;
    }
}
