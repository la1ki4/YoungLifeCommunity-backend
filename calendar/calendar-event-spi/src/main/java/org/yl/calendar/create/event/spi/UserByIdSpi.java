package org.yl.calendar.create.event.spi;

import org.yl.calendar.data.UserData;

import java.util.Optional;
import java.util.UUID;

@FunctionalInterface
public interface UserByIdSpi {
    Optional<UserData> findUserById(UUID id);
}
