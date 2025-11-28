package org.yl.post.like.api;

@FunctionalInterface
public interface PostLikeApi {
    void addLikeToPost(String email);
}
