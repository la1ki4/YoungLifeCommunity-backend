package org.yl.calendar.event.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.calendar.data.EventData;
import org.yl.calendar.event.spi.adapter.repositories.JpaCalendarRepository;
import org.yl.calendar.get.events.spi.GetEventsBetweenDateSpi;

import java.time.Instant;
import java.util.List;

@Component
@AllArgsConstructor
public class GetEventsBetweenDateSpiAdapter implements GetEventsBetweenDateSpi {

    private final JpaCalendarRepository jpaCalendarRepository;

    @Override
    public List<EventData> findEventsBetween(Instant from, Instant to) {
        return jpaCalendarRepository.findBetween(from, to)
                .stream()
                .map(e -> EventData.builder()
                        .title(e.getTitle())
                        .description(e.getDescription())
                        .startDate(e.getStartTime())
                        .endDate(e.getEndTime())
                        .firstName(e.getCreatedBy().getFirstName())
                        .lastName(e.getCreatedBy().getLastName())
                        .build()
                )
                .toList();
    }
}
