package br.com.gymback.core.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.With;

@Builder(toBuilder = true)
public record TeacherDomain(
    String id,
    String name,
    LocalDate birthDate,
    @With
    ContactDomain contact
) implements GenericDomain {

}
