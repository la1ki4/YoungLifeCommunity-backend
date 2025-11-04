package org.yl.post.spi;
import org.yl.post.model.YoungLifePostModel;

import java.util.Optional;

@FunctionalInterface
public interface AddYoungLifePostSpi {
    Optional<YoungLifePostModel> addYoungLifePostSpi (YoungLifePostModel postData);
}
