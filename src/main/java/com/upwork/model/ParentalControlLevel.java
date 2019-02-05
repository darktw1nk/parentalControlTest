package com.upwork.model;

import java.util.Optional;

public enum ParentalControlLevel {
    LEVEL_U("U",1),
    LEVEL_PG("PG",2),
    LEVEL_12("12",3),
    LEVEL_15("15",4),
    LEVEL_18("18",5);

    private final String name;
    private final Integer intLevel;

    ParentalControlLevel(String name,Integer intLevel){
        this.name = name;
        this.intLevel = intLevel;
    }

    public String getName() {
        return name;
    }

    public Integer getIntLevel() {
        return intLevel;
    }

    public static Optional<ParentalControlLevel> fromString(String name) {
        for (ParentalControlLevel level : ParentalControlLevel.values()) {
            if (level.name.equalsIgnoreCase(name)) {
                return Optional.of(level);
            }
        }
        return Optional.empty();
    }
}
