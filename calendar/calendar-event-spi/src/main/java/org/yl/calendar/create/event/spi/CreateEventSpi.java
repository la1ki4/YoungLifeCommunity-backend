package org.yl.calendar.create.event.spi;

import org.yl.calendar.model.EventModel;

import java.util.Optional;

@FunctionalInterface
public interface CreateEventSpi {
    Optional<EventModel> createEvent(EventModel eventModel, String userEmail);
}
