package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.mysql.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public UpdateTeacherUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher update(final Teacher teacher) {
        final var entity = teacher.toEntity();
        final var saved = teacherRepository.save(entity);
        return Teacher.fromEntity(saved);
    }

}
