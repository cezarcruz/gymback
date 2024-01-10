package br.com.gymback.core.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.With;

@Builder
public record StudentDomain(
    String id,
    String name,
    LocalDate birthDate,
    String document,
    @With
    ContactDomain contact,
    @With
    AddressDomain address
) implements GenericDomain {

}
