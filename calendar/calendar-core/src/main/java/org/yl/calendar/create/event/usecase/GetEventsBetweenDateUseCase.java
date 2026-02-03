package org.yl.calendar.create.event.usecase;

import org.yl.calendar.data.EventData;
import org.yl.calendar.get.events.api.GetEventsBetweenDateApi;
import org.yl.calendar.get.events.spi.GetEventsBetweenDateSpi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public record GetEventsBetweenDateUseCase(GetEventsBetweenDateSpi getEventsBetweenDateSpi)
        implements GetEventsBetweenDateApi {
    @Override
    public List<EventData> getEventsBetweenDate(LocalDate startDate, LocalDate endDate) {
        Instant from = startDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant to = endDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return getEventsBetweenDateSpi.findEventsBetween(from, to);
    }
}
