package org.yl.calendar.get.events.spi;

import org.yl.calendar.data.EventData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface GetEventsByDaySpi {
    List<EventData> getEventsSpi(LocalDate date);
}
