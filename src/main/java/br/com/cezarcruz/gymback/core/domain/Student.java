package br.com.cezarcruz.gymback.core.domain;

import java.util.List;
import lombok.Builder;
import lombok.With;

@Builder
public record Student(
    String id,
    String name,
    Integer age,

    @With
    List<Contact> contacts,

    @With
    Address address
) {

}
