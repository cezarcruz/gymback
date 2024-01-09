package br.com.gymback.core.domain;

import lombok.Builder;

@Builder
public record ModalityDomain(
    String id,
    String name
) implements GenericDomain {

}
