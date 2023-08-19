package com.example.prog4.model.utils;

import com.example.prog4.model.core.exception.BadRequestException;
import lombok.Getter;

public record PerPage(@Getter Integer perPage) {
    public static final int MAX_PER_PAGE = 500;

    public PerPage(Integer perPage) {
        if (perPage > MAX_PER_PAGE) {
            throw new BadRequestException("Page size must be < " + MAX_PER_PAGE);
        } else {
            this.perPage = perPage;
        }
    }
}
