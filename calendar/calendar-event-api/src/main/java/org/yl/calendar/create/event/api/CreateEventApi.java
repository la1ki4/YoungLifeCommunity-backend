package org.yl.calendar.create.event.api;

import org.yl.calendar.data.EventData;

@FunctionalInterface
public interface CreateEventApi {
    EventData createEvent(EventData eventData, String userEmail);
}
