package org.yl.post.spi;

import org.yl.post.model.YoungLifePostModel;
import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface ReceiveYoungLifePostSpi {
   Optional<List<YoungLifePostModel>> getAllYoungLifePosts();
}
