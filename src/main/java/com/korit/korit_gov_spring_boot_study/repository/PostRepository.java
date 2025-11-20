package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static PostRepository instance;
    private List<Post> postList;

    private PostRepository() {
        postList = new ArrayList<>();
    }

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

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
            }
            return post;
        }

        return null;
    }

}
