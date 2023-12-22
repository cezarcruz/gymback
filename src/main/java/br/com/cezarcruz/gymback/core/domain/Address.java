package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record Address(
    Long id,
    String zipCode,
    String street,
    String neighborhood,
    String addressNumber
) {

}
