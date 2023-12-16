package br.com.cezarcruz.gymback.teacher.domain.model;

import br.com.cezarcruz.gymback.teacher.domain.entity.TeacherEntity;

public record Teacher(
        Long id,
        String name
) {

    public TeacherEntity toEntity() {
        final var teacherEntity = new TeacherEntity();
        teacherEntity.setName(name);
        return teacherEntity;
    }

    public static Teacher fromEntity(final TeacherEntity entit) {
        return new Teacher(entit.getId(), entit.getName());
    }

}
