package org.yl.post.spi;

import org.yl.post.model.YoungLifeUserModel;

@FunctionalInterface
public interface YoungLifeUserByEmailSpi {
    YoungLifeUserModel getYoungLifeUserByEmail(String userEmail);
}
