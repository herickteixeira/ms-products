package com.products.core.shared.converters;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class JsonConverter {

    public static String toString(Object obj) {
        try {
            var mapper = ObjectMapperFactory.create();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T toObject(String jsonString, Class<T> type) {

        var mapper = ObjectMapperFactory.create();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return mapper.readValue(jsonString, type);
        } catch (Exception e) {
            return null;
        }
    }
}
