package br.com.cezarcruz.gymback.core.domain;

import lombok.Builder;
import lombok.With;

@Builder
public record Student(
    Long id,
    String name,
    Integer age,

    @With
    Address address
) {

}
