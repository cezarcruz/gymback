package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record Modality(
    String id,
    String name
) {

}
