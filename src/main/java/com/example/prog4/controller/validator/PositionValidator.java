package com.example.prog4.controller.validator;

import com.example.prog4.controller.validator.utils.StringValidator;
import com.example.prog4.model.core.exception.BadRequestException;
import com.example.prog4.model.core.entity.management.Position;

public class PositionValidator {
    public void validate(Position position){
        StringBuilder error = new StringBuilder();

        if(StringValidator.isNotNullAndNotBlank(position.getName())){
            error.append("Position name is mandatory");
        }

        if(!error.isEmpty()){
            throw new BadRequestException(error.toString());
        }
    }
}
