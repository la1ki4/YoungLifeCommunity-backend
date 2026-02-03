package org.yl.calendar.get.events.api.adapter;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.calendar.data.EventData;
import org.yl.calendar.get.events.api.GetEventsApi;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor
public class GetEventApiAdapter {
    private final GetEventsApi getEventsApi;

    @GetMapping("/day-event")
    public List<EventData> getEvents(@RequestParam("date")
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                     LocalDate date) {
        return getEventsApi.getEventsOnDay(date);
    }
}
