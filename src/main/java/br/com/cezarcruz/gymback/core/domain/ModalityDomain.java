package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record ModalityDomain(
    String id,
    String name
) {

}
