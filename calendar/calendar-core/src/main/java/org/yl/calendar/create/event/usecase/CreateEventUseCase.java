package org.yl.calendar.create.event.usecase;

import org.yl.calendar.create.event.api.CreateEventApi;
import org.yl.calendar.create.event.spi.CreateEventSpi;
import org.yl.calendar.create.event.spi.UserByIdSpi;
import org.yl.calendar.data.EventData;
import org.yl.calendar.data.UserData;
import org.yl.calendar.model.EventModel;

public record CreateEventUseCase(CreateEventSpi createEventSpi, UserByIdSpi recordOwner) implements CreateEventApi {


    @Override
    public EventData createEvent(EventData eventData, String userEmail) {
        var saved = createEventSpi.createEvent(EventModel.builder()
                .title(eventData.title())
                .description(eventData.description())
                .startDate(eventData.startDate())
                .endDate(eventData.endDate())
                .build(), userEmail);

        EventModel savedModel = saved.orElse(null);

        assert savedModel != null;
        var user = recordOwner.findUserById(savedModel.userId());
        return EventData.builder()
                .title(savedModel.title())
                .description(savedModel.description())
                .startDate(savedModel.startDate())
                .endDate(savedModel.endDate())
                .firstName(user.map(UserData::firstName).orElse(null))
                .lastName(user.map(UserData::lastName).orElse(null))
                .build();
    }
}
