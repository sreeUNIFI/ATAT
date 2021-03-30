package com.example.atat.converter;

import com.example.atat.command.UnitOfMeasureCommand;
import com.example.atat.domains.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Nullable
    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand==null){
            return null;
        }
        final UnitOfMeasure measure = new UnitOfMeasure();
        measure.setId(unitOfMeasureCommand.getId());
        measure.setUom(unitOfMeasureCommand.getUom());
        return measure; }

}
