package org.yl.calendar.data;
import lombok.Builder;

import java.time.Instant;

@Builder
public record EventData(String title, String description, Instant startDate, Instant endDate, String firstName, String lastName) {
}
