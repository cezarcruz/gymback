package br.com.cezarcruz.gymback.teacher.domain.dto.response;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;

public record TeacherResponse (
        Long id,
        String name
) {
    public static TeacherResponse from(final Teacher createdTeacher) {
        return new TeacherResponse(createdTeacher.id(), createdTeacher.name());
    }
}
