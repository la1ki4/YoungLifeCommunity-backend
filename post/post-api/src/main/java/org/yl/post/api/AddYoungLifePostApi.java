package org.yl.post.api;

import org.springframework.web.multipart.MultipartFile;
import org.yl.post.model.YoungLifePostModel;

import java.io.IOException;
import java.util.Optional;

@FunctionalInterface
public interface AddYoungLifePostApi {
    Optional<YoungLifePostModel> addNewPostApi(String description, MultipartFile media, String userEmail) throws IOException;
}
