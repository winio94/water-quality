package com.domain;

/**
 * Created by Michał on 2016-12-05.
 */
public enum Type {
    MINING("Mining"), AGRICURTULAR("Agricultural"), INDUSTRIAL("Industrial");

    private String value;

    Type(String value) {
        this.value = value;
    }
}
