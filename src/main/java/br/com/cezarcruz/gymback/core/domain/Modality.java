package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record Modality(
    Long id,
    String name
) {

}
