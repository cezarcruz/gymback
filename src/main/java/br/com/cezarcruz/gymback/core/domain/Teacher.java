package br.com.cezarcruz.gymback.core.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record Teacher(
    String id,
    String name,
    LocalDate birthDate,
    List<Contact> contacts
) {

}
