package com.devsuperior.movieflix.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String field, String message) {
        this.errors.add(new FieldMessage(field, message));
    }

}
