package com.products.application.shared;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private final Long offset;
    private final Integer limit;
    private final Long total;
    private final List<T> elements;

    public Page(Long offset, Integer limit, Long total, List<T> elements) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.elements = (List)(elements == null ? new ArrayList() : elements);
    }

    public Long getTotal() {
        return this.total;
    }

    public List<T> getElements() {
        return this.elements;
    }

    public Long getOffset() {
        return this.offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer size() {
        return this.elements.size();
    }

    public Boolean isEmpty() {
        return this.elements.isEmpty();
    }
}
