package br.com.cezarcruz.gymback.teacher.application.usecase;

import br.com.cezarcruz.gymback.teacher.domain.usecase.DeleteTeacherUseCase;
import br.com.cezarcruz.gymback.teacher.infra.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteTeacherUseCaseImpl implements DeleteTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public DeleteTeacherUseCaseImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void deleteBy(final Long id) {
        teacherRepository.deleteById(id);
    }
}
