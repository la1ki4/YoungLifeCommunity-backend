package org.yl.calendar.data;

import lombok.Builder;

@Builder
public record UserData(String firstName, String lastName) {
}
