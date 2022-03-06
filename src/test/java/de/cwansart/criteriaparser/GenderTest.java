package de.cwansart.criteriaparser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void male() {
        assertThat(Gender.fromString("male")).isEqualTo(Gender.MALE);
        assertThat(Gender.fromString("männlich")).isEqualTo(Gender.MALE);
    }

    @Test
    void female() {
        assertThat(Gender.fromString("female")).isEqualTo(Gender.FEMALE);
        assertThat(Gender.fromString("weiblich")).isEqualTo(Gender.FEMALE);
    }

    @Test
    void both() {
        assertThat(Gender.fromString("both")).isEqualTo(Gender.BOTH);
        assertThat(Gender.fromString("beide")).isEqualTo(Gender.BOTH);
    }

    @Test
    void unknown() {
        assertThat(Gender.fromString("unknown")).isEqualTo(Gender.UNKNOWN);
        assertThat(Gender.fromString("unbekannt")).isEqualTo(Gender.UNKNOWN);
    }
}