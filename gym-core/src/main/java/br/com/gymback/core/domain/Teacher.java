package br.com.gymback.core.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder(toBuilder = true)
public record Teacher(
    String id,
    String name,
    LocalDate birthDate,
    @With
    List<ContactDomain> contacts
) {

}
