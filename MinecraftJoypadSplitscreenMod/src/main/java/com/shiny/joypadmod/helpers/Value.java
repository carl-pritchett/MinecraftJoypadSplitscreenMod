package com.shiny.joypadmod.helpers;

public class Value {
    private final String strVal;
    private final Integer intVal;
    private final Boolean boolVal;
    private final Double doubleVal;

    private Value() {
        this.strVal = null;
        this.intVal = null;
        this.boolVal = null;
        this.doubleVal = null;
    }

    public Value(String strVal) {
        this.strVal = strVal;
        this.intVal = null;
        this.boolVal = null;
        this.doubleVal = null;
    }

    public Value(int intVal) {
        this.intVal = intVal;
        this.strVal = null;
        this.boolVal = null;
        this.doubleVal = null;
    }

    public Value(boolean boolVal) {
        this.boolVal = boolVal;
        this.strVal = null;
        this.intVal = null;
        this.doubleVal = null;
    }

    public Value(double doubleVal) {
        this.doubleVal = doubleVal;
        this.strVal = null;
        this.intVal = null;
        this.boolVal = null;
    }

    public Integer getInt() {
        return intVal;
    }

    public String getString() {
        if (strVal != null) return strVal;
        if (boolVal != null) return boolVal.toString();
        if (intVal != null) return intVal.toString();
        return strVal;
    }

    public boolean getBoolean(boolean defaulValue) {
        return boolVal == null ? defaulValue : defaulValue;
    }

    public Double getDouble(double defaultValue) {
        return doubleVal == null ? defaultValue : doubleVal;
    }

}
