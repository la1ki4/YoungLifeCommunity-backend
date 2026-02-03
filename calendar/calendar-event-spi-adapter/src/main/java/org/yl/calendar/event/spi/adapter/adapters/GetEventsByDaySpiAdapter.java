package org.yl.calendar.event.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.calendar.event.spi.adapter.mappers.CalendarMapper;
import org.yl.calendar.event.spi.adapter.repositories.JpaCalendarRepository;
import org.yl.calendar.data.EventData;
import org.yl.calendar.get.events.spi.GetEventsByDaySpi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Component
@AllArgsConstructor
public class GetEventsByDaySpiAdapter implements GetEventsByDaySpi {

    private final JpaCalendarRepository calendarRepository;

    @Override
    public List<EventData> getEventsSpi(LocalDate date) {
        Instant startOfDay = date
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);

        Instant endOfDay = date
                .plusDays(1)
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);

        return calendarRepository
                .findBetween(startOfDay, endOfDay)
                .stream()
                .map(CalendarMapper::toData)
                .toList();
    }
}
