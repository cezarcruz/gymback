package br.com.gymback.core.domain;

import lombok.Builder;

@Builder
public record AddressDomain(
    Long id,
    String zipcode,
    String street,
    String state,
    String city,
    String neighborhood,
    String addressNumber
) {

}
