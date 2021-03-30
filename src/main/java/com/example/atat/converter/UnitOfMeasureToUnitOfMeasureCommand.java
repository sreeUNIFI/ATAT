package com.example.atat.converter;

import com.example.atat.command.UnitOfMeasureCommand;
import com.example.atat.domains.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure==null){
            return null;
        }
       final UnitOfMeasureCommand measureCommand = new UnitOfMeasureCommand();
        measureCommand.setId(unitOfMeasure.getId());
        measureCommand.setUom(unitOfMeasure.getUom());
        return measureCommand; }
}
