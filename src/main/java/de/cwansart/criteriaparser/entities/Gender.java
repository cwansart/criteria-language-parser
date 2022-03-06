package de.cwansart.criteriaparser.entities;

import java.util.Arrays;

public enum Gender {
    MALE("male", "männlich"),
    FEMALE("female", "weiblich"),
    BOTH("both", "beide"),
    UNKNOWN("unknown", "unbekannt");

    private final String englishName;

    private final String germanName;

    Gender(String englishName, String germanName) {
        this.englishName = englishName;
        this.germanName = germanName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getGermanName() {
        return germanName;
    }

    public static Gender fromString(String genderString) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.englishName.equalsIgnoreCase(genderString) ||
                        gender.germanName.equalsIgnoreCase(genderString))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
