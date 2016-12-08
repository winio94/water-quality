package com.domain;

/**
 * Created by Michał on 2016-12-06.
 */
public enum EconomySystem {
    TRADITIONAL("Traditional"),
    COMMAND("Command"),
    MARKET("Market"),
    MIXED("Mixed");

    private String value;

    EconomySystem(String value) {
        this.value = value;
    }
}