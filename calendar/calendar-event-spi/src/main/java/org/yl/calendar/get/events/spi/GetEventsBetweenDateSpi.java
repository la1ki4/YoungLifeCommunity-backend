package org.yl.calendar.get.events.spi;

import org.yl.calendar.data.EventData;

import java.time.Instant;
import java.util.List;

@FunctionalInterface
public interface GetEventsBetweenDateSpi {
    List<EventData> findEventsBetween(Instant from, Instant to);
}
