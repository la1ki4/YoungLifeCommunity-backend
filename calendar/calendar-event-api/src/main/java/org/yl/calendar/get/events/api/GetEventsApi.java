package org.yl.calendar.get.events.api;
import org.yl.calendar.data.EventData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface GetEventsApi {
    List<EventData> getEventsOnDay(LocalDate date);
}
