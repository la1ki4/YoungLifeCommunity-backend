package org.yl.calendar.model;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record EventModel(UUID userId, String title, String description, Instant startDate, Instant endDate) {
}
