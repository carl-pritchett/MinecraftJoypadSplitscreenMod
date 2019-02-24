package com.shiny.joypadmod.helpers;

import java.io.File;

public class Configuration {
    public Configuration(File config, boolean unknown) {

    }

    public void load() {

    }

    public void save() {

    }

    // Something you can call getInt on
    public Value get(String category,String name, String defaultValue) {
        return new Value(defaultValue);
    }

    public Value get(String category,String name, int defaultValue) {
        return new Value(defaultValue);
    }

    public Value get(String category,String name, boolean defaultValue) {
        return new Value(defaultValue);
    }

    public Value get(String category,String name, double defaultValue) {
        return new Value(defaultValue);
    }

    public boolean hasCategory(String category) {
        return true;
    }

    public boolean removeCategory(ConfigCategory category) {
        return true;
    }

    public ConfigCategory getCategory(String category) {
        return new ConfigCategory();
    }

    public void addCustomCategoryComment(String category, String msg) {

    }
}
