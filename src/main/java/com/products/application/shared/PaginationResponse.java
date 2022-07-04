package com.products.application.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaginationResponse<T> implements Serializable {

    private final Long offset;
    private final Integer limit;
    private Long total;
    private final int acceptRange;
    private final transient List<T> elements;

    public PaginationResponse(Long offset, Integer limit, Long total, List<T> elements) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.elements = elements == null ? new ArrayList<>() : elements;
        this.acceptRange = Pagination.ACCEPT_RANGE;
    }

    public PaginationResponse(Long offset, Integer limit, List<T> elements) {
        this.offset = offset;
        this.limit = limit;
        this.elements = elements == null ? new ArrayList<>() : elements;
        this.acceptRange = Pagination.ACCEPT_RANGE;
    }

    public PaginationResponse(Long offset, Integer limit, Long total, int acceptRange, List<T> elements) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.acceptRange = acceptRange;
        this.elements = elements;
    }

    public Long getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getElements() {
        return elements;
    }

    public int getAcceptRange() {
        return acceptRange;
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public int size() {
        return this.elements.size();
    }
}
