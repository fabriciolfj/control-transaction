package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException() {
        super(Errors.ERROR_1.toMessage());
    }
}
