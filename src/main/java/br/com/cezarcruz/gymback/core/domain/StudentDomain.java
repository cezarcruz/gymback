package br.com.cezarcruz.gymback.core.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record StudentDomain(
    String id,
    String name,
    LocalDate birthDate,
    String document,
    @With
    List<ContactDomain> contacts,
    @With
    AddressDomain address
) {

}
