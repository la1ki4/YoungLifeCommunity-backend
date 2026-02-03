package org.yl.calendar.create.event.api.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yl.calendar.config.CookiesHolder;
import org.yl.calendar.config.JwtValidator;
import org.yl.calendar.create.event.api.CreateEventApi;
import org.yl.calendar.data.EventData;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor
public class CreateEventApiAdapter {

    private final CreateEventApi createEventApi;
    private final JwtValidator jwtValidator;

    @PostMapping("/create-event")
    public ResponseEntity<?> createEvent(@RequestBody EventData eventData, HttpServletRequest request) {
        try {
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if (token == null) return ResponseEntity.status(401).body("No JWT token found in cookies");
            String email = jwtValidator.extractEmail(token);
            return ResponseEntity.ok(createEventApi.createEvent(eventData, email));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error loading comments: " + e.getMessage());
        }
    }
}
