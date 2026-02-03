package org.yl.calendar.event.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.calendar.create.event.spi.UserByIdSpi;
import org.yl.calendar.event.spi.adapter.entities.UserEntity;
import org.yl.calendar.event.spi.adapter.repositories.JpaUserRepository;
import org.yl.calendar.data.UserData;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserByIdSpiAdapter implements UserByIdSpi {

    JpaUserRepository jpaUserRepository;

    @Override
    public Optional<UserData> findUserById(UUID id) {
        UserEntity userEntity = jpaUserRepository.findById(id).orElse(null);
        if (userEntity == null) {
            return Optional.empty();
        }
        return Optional.of(UserData.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .build());
    }
}
