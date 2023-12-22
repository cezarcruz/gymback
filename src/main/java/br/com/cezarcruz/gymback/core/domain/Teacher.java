package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder(toBuilder = true)
public record Teacher(
    String id,
    String name
) {

}
