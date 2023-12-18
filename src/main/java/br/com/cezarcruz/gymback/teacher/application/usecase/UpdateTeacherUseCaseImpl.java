package br.com.cezarcruz.gymback.teacher.application.usecase;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import br.com.cezarcruz.gymback.teacher.domain.usecase.UpdateTeacherUseCase;
import br.com.cezarcruz.gymback.teacher.infra.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
class UpdateTeacherUseCaseImpl implements UpdateTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public UpdateTeacherUseCaseImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher update(final Teacher teacher) {
        final var entity = teacher.toEntity();
        final var saved = teacherRepository.save(entity);
        return Teacher.fromEntity(saved);
    }

}
