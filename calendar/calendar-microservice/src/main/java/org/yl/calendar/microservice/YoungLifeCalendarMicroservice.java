package org.yl.calendar.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.yl.calendar.create.event.api.CreateEventApi;
import org.yl.calendar.create.event.spi.CreateEventSpi;
import org.yl.calendar.create.event.spi.UserByIdSpi;
import org.yl.calendar.create.event.usecase.CreateEventUseCase;
import org.yl.calendar.create.event.usecase.GetEventsBetweenDateUseCase;
import org.yl.calendar.create.event.usecase.GetEventsUseCase;
import org.yl.calendar.get.events.api.GetEventsApi;
import org.yl.calendar.get.events.api.GetEventsBetweenDateApi;
import org.yl.calendar.get.events.spi.GetEventsBetweenDateSpi;
import org.yl.calendar.get.events.spi.GetEventsByDaySpi;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication(scanBasePackages = "org.yl.calendar")
@EnableJpaRepositories(basePackages = {
        "org.yl.calendar.event.spi",
})
@EnableFeignClients
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@EntityScan(basePackages = {
        "org.yl.calendar.event.spi",
})
public class YoungLifeCalendarMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifeCalendarMicroservice.class, args);
    }

    @Bean
    public CreateEventApi createEvent(CreateEventSpi createEventSpi, UserByIdSpi recordOwner) {
        return new CreateEventUseCase(createEventSpi, recordOwner);
    }

    @Bean
    public GetEventsApi getEventsApi(GetEventsByDaySpi getEventsByDaySpi) {
        return new GetEventsUseCase(getEventsByDaySpi);
    }

    @Bean
    public GetEventsBetweenDateApi getEventsBetweenDateApi(GetEventsBetweenDateSpi getEventsBetweenDateSpi) {
        return new GetEventsBetweenDateUseCase(getEventsBetweenDateSpi);
    }
}
