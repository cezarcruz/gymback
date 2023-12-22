package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.TeacherEntity;
import lombok.Builder;

@Builder
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
