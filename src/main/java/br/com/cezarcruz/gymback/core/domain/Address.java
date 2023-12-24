package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;

@Builder
public record Address(
    String id,
    String zipcode,
    String street,
    String state,
    String city,
    String neighborhood,
    String addressNumber
) {

}
