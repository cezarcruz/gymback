package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import br.com.cezarcruz.gymback.core.domain.Teacher;

public record TeacherResponse (
        Long id,
        String name
) {
    public static TeacherResponse from(final Teacher createdTeacher) {
        return new TeacherResponse(createdTeacher.id(), createdTeacher.name());
    }
}
