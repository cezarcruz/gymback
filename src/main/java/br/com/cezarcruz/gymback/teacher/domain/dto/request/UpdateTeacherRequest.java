package br.com.cezarcruz.gymback.teacher.domain.dto.request;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import jakarta.validation.constraints.NotNull;

public record UpdateTeacherRequest(
        
        @NotNull
        String name
) {
    public Teacher toTeacher(final Long id) {
        return new Teacher(id, name);
    }
}
