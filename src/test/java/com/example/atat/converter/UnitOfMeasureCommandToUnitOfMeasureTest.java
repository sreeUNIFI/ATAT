package com.example.atat.converter;

import com.example.atat.command.UnitOfMeasureCommand;
import com.example.atat.domains.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure toUnitOfMeasure;

    @BeforeEach
    void setUp() {
        toUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void convertWillReturnEmptyObject() {
        assertNotNull(toUnitOfMeasure.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convertWillReturnNull(){
        assertNull(toUnitOfMeasure.convert(null));
    }

    @Test
    void convert(){
//        Given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(1L);
        command.setUom("Description");
//        When
        UnitOfMeasure measure = toUnitOfMeasure.convert(command);
//        Then
        assertNotNull(measure);
        assertEquals(1L,measure.getId());
        assertEquals("Description",measure.getUom());
    }
}