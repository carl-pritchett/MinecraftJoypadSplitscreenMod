package com.shiny.joypadmod.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfigCategory extends HashMap<String, Value> {
    public Integer remove(String key) {
        return new Integer(1);
    }

    public void setComment(String comment) {

    }

    public void removeChild(ConfigCategory child) {

    }

    public List<ConfigCategory> getChildren() {
        return new ArrayList<>();
    }
}
