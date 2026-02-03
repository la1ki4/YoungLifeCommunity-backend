package org.yl.calendar.create.event.usecase;

import org.yl.calendar.data.EventData;
import org.yl.calendar.get.events.api.GetEventsApi;
import org.yl.calendar.get.events.spi.GetEventsByDaySpi;

import java.time.LocalDate;
import java.util.List;

public record GetEventsUseCase(GetEventsByDaySpi getEventsByDaySpi) implements GetEventsApi {

    @Override
    public List<EventData> getEventsOnDay(LocalDate date) {
        return getEventsByDaySpi.getEventsSpi(date);
    }
}
