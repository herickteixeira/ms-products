package com.products.application.shared;

import com.products.core.shared.converters.NumberConverter;
import com.products.core.shared.validators.CustomValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Pagination {

    public static final int ACCEPT_RANGE = 1000;

    @NotNull(message = "pagination.offset.not.null")
    @Min(value = 0, message = "pagination.offset.min")
    private final Long offset;

    @NotNull(message = "pagination.limit.not.null")
    @Min(value = 1, message = "pagination.limit.min")
    @Max(value = ACCEPT_RANGE, message = "pagination.limit.max")
    private final Integer limit;

    @PositiveOrZero
    private final Long total;

    private Pagination(String offset, String limit) {
        this.offset = NumberConverter.toLong(offset);
        this.limit = getValidLimit(limit);
        this.total = 0L;
    }

    private Pagination(Long offset, Integer limit) {
        this.offset = offset;
        this.limit = getValidLimit(limit);
        this.total = 0L;
    }

    private Pagination(Long offset, Integer limit, Long total) {
        this.offset = offset;
        this.limit = getValidLimit(limit);
        this.total = total;
    }

    private Pagination(String offset, String limit, Long total) {
        this.offset = NumberConverter.toLong(offset);
        this.limit = getValidLimit(limit);
        this.total = total;
    }

    public static Pagination create(String offset, String limit, Long total) {
        var paginate = new Pagination(offset, limit, total);
        CustomValidator.validateAndThrow(paginate);
        return paginate;
    }

    public static Pagination create(Long offset, Integer limit, Long total) {
        var paginate = new Pagination(offset, limit, total);
        CustomValidator.validateAndThrow(paginate);
        return paginate;
    }

    public static Pagination create(Long offset, Integer limit) {
        var paginate = new Pagination(offset, limit);
        CustomValidator.validateAndThrow(paginate);
        return paginate;
    }

    public static Pagination create(String offset, String limit) {
        var paginate = new Pagination(offset, limit);
        CustomValidator.validateAndThrow(paginate);
        return paginate;
    }

    public static Integer getValidLimit(String limit) {
        return getValidLimit(NumberConverter.toInt(limit));
    }

    public static Integer getValidLimit(Integer limit) {
        return (limit != null) ? limit : ACCEPT_RANGE;
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

    public Pagination ofTotal(Long total) {
        return Pagination.create(this.offset, this.limit, total);
    }
}
