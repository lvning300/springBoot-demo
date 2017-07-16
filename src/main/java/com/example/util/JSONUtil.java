package com.example.util;


import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.type.TypeReference;

public class JSONUtil {

    static ObjectMapper objectMapper = new ObjectMapper();

    private JSONUtil() {
    }

    public static <T> T parse(String string, TypeReference<T> t) {
        try {
            objectMapper.setDeserializationConfig(objectMapper.getDeserializationConfig().without(new Feature[]{Feature.FAIL_ON_UNKNOWN_PROPERTIES}));
            return objectMapper.readValue(string, t);
        } catch (IOException var3) {
            return null;
        }
    }

    public static <T> T parse(String string, Class<T> t) {
        try {
            objectMapper.setDeserializationConfig(objectMapper.getDeserializationConfig().without(new Feature[]{Feature.FAIL_ON_UNKNOWN_PROPERTIES}));
            return objectMapper.readValue(string, t);
        } catch (IOException var3) {
            return null;
        }
    }

    public static <T> T importJson(String path, Class<T> tClass) throws IOException {
        InputStream is = JSONUtil.class.getResourceAsStream(path);
        return parse(IOUtils.toString(is), tClass);
    }

    public static <T> T importJson(String path, TypeReference<T> t) throws IOException {
        InputStream is = JSONUtil.class.getResourceAsStream(path);
        return parse(IOUtils.toString(is), t);
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writer().writeValueAsString(object);
        } catch (IOException var2) {
            var2.printStackTrace();
            return "{}";
        }
    }
}
