package br.com.cezarcruz.gymback.teacher.domain.dto.request;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import jakarta.validation.constraints.NotNull;

public record CreateTeacherRequest(

        @NotNull
        String name
) {

    public Teacher toTeacher() {
        return new Teacher(null, name);
    }

}
