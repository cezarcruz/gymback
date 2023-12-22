package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import jakarta.validation.constraints.NotNull;

public record CreateTeacherRequest(

        @NotNull
        String name
) {

    public Teacher toTeacher() {
      return Teacher.builder()
          .name(name())
          .build();
    }

}
