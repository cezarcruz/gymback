package br.com.cezarcruz.gymback.core.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record Student(
    String id,
    String name,
    LocalDate birthDate,
    String document,
    @With
    List<Contact> contacts,
    @With
    Address address
) {

}
