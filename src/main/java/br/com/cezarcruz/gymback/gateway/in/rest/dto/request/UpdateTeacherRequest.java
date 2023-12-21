package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import jakarta.validation.constraints.NotNull;

public record UpdateTeacherRequest(
        
        @NotNull
        String name
) {
    public Teacher toTeacher(final Long id) {
        return new Teacher(id, name);
    }
}
