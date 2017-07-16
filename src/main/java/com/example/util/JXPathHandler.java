package com.example.util;


public class JXPathHandler {

    private JXPathContext context;

    public JXPathHandler(Object obj) {
        this.context = JXPathContext.newContext(obj);
        this.context.setLenient(true);
    }

    public static JXPathHandler with(Object obj) {
        return new JXPathHandler(obj);
    }

    public String getStr(String xpath) {
        return getValue(xpath, String.class);
    }

    public Integer getInt(String xpath) {
        return getValue(xpath, Integer.class);
    }

    public boolean getBoolean(String xpath) {
        Boolean retValue = getValue(xpath, Boolean.class);
        return retValue == null ? false : retValue;
    }

    public Map getMap(String xpath) {
        return getValue(xpath, Map.class);
    }

    public List getList(String xpath) {
        return getValue(xpath, List.class);
    }

    public <T> T getValue(String xpath, Class<T> clazz) {
        return (T) context.getValue(xpath, clazz);
    }
}
