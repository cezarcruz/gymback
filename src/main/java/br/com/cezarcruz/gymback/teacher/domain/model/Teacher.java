package br.com.cezarcruz.gymback.teacher.domain.model;

import br.com.cezarcruz.gymback.teacher.domain.entity.TeacherEntity;

public record Teacher(
        Long id,
        String name
) {

    public TeacherEntity toEntity() {
        final var teacherEntity = new TeacherEntity();
        teacherEntity.setName(name);
        teacherEntity.setId(id);
        return teacherEntity;
    }

    public static Teacher fromEntity(final TeacherEntity entity) {
        return new Teacher(entity.getId(), entity.getName());
    }

}
