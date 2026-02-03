package org.yl.calendar.event.spi.adapter.mappers;

import org.yl.calendar.event.spi.adapter.entities.CalendarEntity;
import org.yl.calendar.event.spi.adapter.entities.UserEntity;
import org.yl.calendar.data.EventData;
import org.yl.calendar.model.EventModel;

public class CalendarMapper{
    public static CalendarEntity toEntity(EventModel model, UserEntity entity) {
        CalendarEntity calendarEntity = new CalendarEntity();
        calendarEntity.setTitle(model.title());
        calendarEntity.setCreatedBy(entity);
        calendarEntity.setDescription(model.description());
        calendarEntity.setStartTime(model.startDate());
        calendarEntity.setEndTime(model.endDate());
        return calendarEntity;
    }

    public static EventModel toModel(CalendarEntity commentEntity) {
        return EventModel.builder()
                .userId(commentEntity.getCreatedBy().getId())
                .title(commentEntity.getTitle())
                .description(commentEntity.getDescription())
                .startDate(commentEntity.getStartTime())
                .endDate(commentEntity.getEndTime())
                .build();
    }

    public static EventData toData(CalendarEntity entity) {
        return EventData.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .startDate(entity.getStartTime())
                .endDate(entity.getEndTime())
                .firstName(entity.getCreatedBy().getFirstName())
                .lastName(entity.getCreatedBy().getLastName())
                .build();
    }
}
