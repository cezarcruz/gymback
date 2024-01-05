package br.com.cezarcruz.core.domain;

import lombok.Builder;

@Builder
public record ModalityDomain(
    String id,
    String name
) {

}
