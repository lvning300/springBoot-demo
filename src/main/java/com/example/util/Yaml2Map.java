package com.example.util;


import java.util.Map;

public class Yaml2Map {

    public static Map convert(String yamlStr) {
        return StringUtils.isBlank(yamlStr) ? Collections.emptyMap()
                : new Yaml().loadAs(yamlStr, Map.class);
    }
}
