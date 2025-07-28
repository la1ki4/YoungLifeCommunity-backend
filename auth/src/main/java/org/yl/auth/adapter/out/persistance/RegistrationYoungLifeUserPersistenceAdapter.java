package org.yl.auth.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.auth.core.model.YoungLifeUserModel;
import org.yl.auth.core.port.out.RegistrationYoungLifeUserPort;

@Component
@RequiredArgsConstructor
public class RegistrationYoungLifeUserPersistenceAdapter implements RegistrationYoungLifeUserPort {
    private final JpaYoungLifeUserRepository jpaYoungLifeUserRepository;

    @Override
    public YoungLifeUserModel registerYoungLifeUser(YoungLifeUserModel user) {
        YoungLifeUserEntity entity = YoungLifeUserEntity.fromModel(user);
        YoungLifeUserEntity saved = jpaYoungLifeUserRepository.save(entity);
        return saved.toModel();
    }
}
