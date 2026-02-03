package org.yl.calendar.event.spi.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yl.calendar.event.spi.adapter.entities.CalendarEntity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface JpaCalendarRepository extends JpaRepository<CalendarEntity, UUID> {
    @Query("""
        select c from CalendarEntity c
        where c.startTime >= :start
          and c.startTime < :end
    """)
    List<CalendarEntity> findBetween(
            @Param("start") Instant start,
            @Param("end") Instant end
    );
}
