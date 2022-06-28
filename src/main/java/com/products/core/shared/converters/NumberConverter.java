package com.products.core.shared.converters;

import com.products.core.shared.helper.StringHelper;

public class NumberConverter {

    private NumberConverter() {
        throw new IllegalStateException("Number Converter");
    }

    public static Long toLong(String value) {
        try {
            return Long.parseLong(StringHelper.clean(value));
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer toInt(String value) {
        try {
            return Integer.parseInt(StringHelper.clean(value));
        } catch (Exception e) {
            return null;
        }
    }
}
