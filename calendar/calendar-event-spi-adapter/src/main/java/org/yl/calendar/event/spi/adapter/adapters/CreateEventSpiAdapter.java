package org.yl.calendar.event.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.calendar.create.event.spi.CreateEventSpi;
import org.yl.calendar.event.spi.adapter.entities.CalendarEntity;
import org.yl.calendar.event.spi.adapter.entities.UserEntity;
import org.yl.calendar.event.spi.adapter.mappers.CalendarMapper;
import org.yl.calendar.event.spi.adapter.repositories.JpaCalendarRepository;
import org.yl.calendar.event.spi.adapter.repositories.JpaUserRepository;
import org.yl.calendar.model.EventModel;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CreateEventSpiAdapter implements CreateEventSpi {

    JpaCalendarRepository jpaCalendarRepository;
    JpaUserRepository jpaUserRepository;

    @Override
    public Optional<EventModel> createEvent(EventModel eventModel, String userEmail) {
        if (eventModel == null) {
            return Optional.empty();
        }
        Optional<UserEntity> user = jpaUserRepository.findYoungLifeUserByEmail(userEmail);
        UserEntity userEntity = user.orElse(null);
        CalendarEntity calendarEntity = jpaCalendarRepository.save(CalendarMapper.toEntity(eventModel,userEntity));
        return Optional.of(CalendarMapper.toModel(calendarEntity));
    }
}
