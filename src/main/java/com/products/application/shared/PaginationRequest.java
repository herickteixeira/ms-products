package com.products.application.shared;

import com.products.core.shared.converters.NumberConverter;

public class PaginationRequest {
    private final Long offset;
    private final Integer limit;

    public PaginationRequest(Long offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public PaginationRequest(String offset, String limit) {
        this.offset = NumberConverter.toLong(offset);
        this.limit = NumberConverter.toInt(limit);
    }

    public Long getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

}
