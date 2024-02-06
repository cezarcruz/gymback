/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.response;

import java.util.List;

public record PageResponse<T>(
    int page, int size, long totalElements, int totalPages, List<T> elements) {}
