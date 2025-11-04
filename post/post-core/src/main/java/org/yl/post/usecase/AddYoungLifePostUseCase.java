package org.yl.post.usecase;

import org.springframework.web.multipart.MultipartFile;
import org.yl.post.api.AddYoungLifePostApi;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.AddYoungLifePostSpi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;

public record AddYoungLifePostUseCase (AddYoungLifePostSpi postRepository) implements AddYoungLifePostApi {
    private static final String UPLOAD_DIR = "media/";

    @Override
    public Optional<YoungLifePostModel> addNewPostApi(String description, MultipartFile mediaFile) throws IOException {

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = System.currentTimeMillis() + "_" + mediaFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        Files.copy(mediaFile.getInputStream(), filePath);

        return postRepository.addYoungLifePostSpi(YoungLifePostModel.builder()
                        .description(description)
                        .uploadedAt(LocalDateTime.now())
                        .fileData(mediaFile.getBytes())
                        .contentType(mediaFile.getContentType())
                        .filePath(filePath.toString())
                        .fileName(fileName)
                        .build());
    }
}
