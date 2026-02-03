package org.yl.calendar.get.events.api.adapter;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.calendar.data.EventData;
import org.yl.calendar.get.events.api.GetEventsBetweenDateApi;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor
public class GetEventsBetweenDateApiAdapter {
    private final GetEventsBetweenDateApi getEventsBetweenDateApi;

    @GetMapping("/between-dates")
    public List<EventData> getEvents(@RequestParam("startDate")
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                     LocalDate startDate,
                                     @RequestParam("endDate")
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                     LocalDate endDate) {
        return getEventsBetweenDateApi.getEventsBetweenDate(startDate, endDate);
    }
}
