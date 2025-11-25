package org.yl.post.usecase;

import org.springframework.web.multipart.MultipartFile;
import org.yl.post.api.AddYoungLifePostApi;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.model.YoungLifeUserModel;
import org.yl.post.spi.AddYoungLifePostSpi;
import org.yl.post.spi.YoungLifeUserByEmailSpi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

public record AddYoungLifePostUseCase (AddYoungLifePostSpi postRepository, YoungLifeUserByEmailSpi userRepository) implements AddYoungLifePostApi {
    private static final String UPLOAD_DIR = "media/";
    private static final String DOMAIN = "http://localhost:8081/";

    @Override
    public Optional<YoungLifePostModel> addNewPostApi(String description, MultipartFile mediaFile, String userEmail) throws IOException {

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = System.currentTimeMillis() + "_" + mediaFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        Files.copy(mediaFile.getInputStream(), filePath);
        YoungLifeUserModel user = userRepository.getYoungLifeUserByEmail(userEmail);

        return postRepository.addYoungLifePostSpi(YoungLifePostModel.builder()
                        .description(description)
                        .filePath(DOMAIN + filePath)
                        .fileName(fileName)
                        .contentType(mediaFile.getContentType())
                        .uploadedAt(Timestamp.from(Instant.now()))
                        .user(user)
                        .build());
    }
}
