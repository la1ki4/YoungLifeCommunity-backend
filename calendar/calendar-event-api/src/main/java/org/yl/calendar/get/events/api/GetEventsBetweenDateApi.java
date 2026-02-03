package org.yl.calendar.get.events.api;

import org.yl.calendar.data.EventData;

import java.time.LocalDate;
import java.util.List;

public interface GetEventsBetweenDateApi {
    List<EventData> getEventsBetweenDate(LocalDate startDate, LocalDate endDate);
}
