package com.example.atat.converter;

import com.example.atat.command.UnitOfMeasureCommand;
import com.example.atat.domains.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand;

    @BeforeEach
    void setUp() {
        toUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @DisplayName("Testing return null")
    @Test
    void convertWillReturnNull() {
        assertNull(toUnitOfMeasureCommand.convert(null));
    }

    @Test
    void convertWillReturnEmptyObj(){
        assertNotNull(toUnitOfMeasureCommand.convert(new UnitOfMeasure()),"shouldn't return Null");
    }

    @Test
    void convert(){
//        Given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);
        unitOfMeasure.setUom("Description");
//        When
         UnitOfMeasureCommand measureCommand=   toUnitOfMeasureCommand.convert(unitOfMeasure);
//        Then
        assertNotNull(measureCommand);
        assertEquals(1L,measureCommand.getId());
        assertEquals("Description",measureCommand.getUom());


    }
}