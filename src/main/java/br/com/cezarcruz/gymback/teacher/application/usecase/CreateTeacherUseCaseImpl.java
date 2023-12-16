package br.com.cezarcruz.gymback.teacher.application.usecase;

import br.com.cezarcruz.gymback.teacher.domain.entity.TeacherEntity;
import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import br.com.cezarcruz.gymback.teacher.domain.usecase.CreateTeacherUseCase;
import br.com.cezarcruz.gymback.teacher.infra.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
class CreateTeacherUseCaseImpl implements CreateTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public CreateTeacherUseCaseImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(final Teacher teacher) {
        final var entity = teacher.toEntity();
        final var saved = teacherRepository.save(entity);
        return Teacher.fromEntity(saved);
    }

}
