package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import br.com.cezarcruz.gymback.core.domain.Student;

public record StudentResponse(
    Long id,
    String name,
    Integer age,
    AddressResponse address
) {

  public static StudentResponse from(final Student createdStudent) {
    return new StudentResponse(createdStudent.id(),
        createdStudent.name(),
        createdStudent.age(),
        AddressResponse.from(createdStudent.address()));
  }
}
