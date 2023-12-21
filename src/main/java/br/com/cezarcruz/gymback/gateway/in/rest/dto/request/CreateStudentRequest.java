package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateStudentRequest (

    @NotNull String name,
    @NotNull Integer age,
    @Valid @NotNull CreateAddressRequest address

) {

  public Student toStudent() {
    return new Student(null, name(), age(), address.toAddress());
  }
}
