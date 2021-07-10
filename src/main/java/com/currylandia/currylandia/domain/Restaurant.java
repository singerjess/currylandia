package com.currylandia.currylandia.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String description;
    private final String address;
    private final List<String> schedule;

    public Restaurant(String name, String description, String address, List<String> schedule) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.schedule = schedule;
    }
}
