package com.the.simone.util;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PkmEnum {

    SEALED_BOX("Sealed box"),
    SINGLE_CARD("Single card"),
    SEALED("Sealed item"),
    GOOD("Good condition card"),
    NEAR_MINT("Near Mint condiction card");

    private final String value;

    PkmEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }
}
