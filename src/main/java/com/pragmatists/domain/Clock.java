package com.pragmatists.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public LocalDate date() {
        return LocalDate.now();
    }

    public String dateAsString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
