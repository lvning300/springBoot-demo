package com.example.util;


import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.util.Collections;
import java.util.Map;

public class Yaml2Map {

    public static Map convert(String yamlStr) {
        return StringUtils.isBlank(yamlStr) ? Collections.emptyMap()
                : new Yaml().loadAs(yamlStr, Map.class);
    }
}
