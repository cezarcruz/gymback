package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record Teacher(
    Long id,
    String name
) {

}
