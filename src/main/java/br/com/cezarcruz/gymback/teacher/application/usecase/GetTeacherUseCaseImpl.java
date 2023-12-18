package br.com.cezarcruz.gymback.teacher.application.usecase;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import br.com.cezarcruz.gymback.teacher.domain.usecase.GetTeacherUseCase;
import br.com.cezarcruz.gymback.teacher.infra.repository.TeacherRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class GetTeacherUseCaseImpl implements GetTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public GetTeacherUseCaseImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Stream<Teacher> getAll() {
        final var all = teacherRepository.findAll();
        return all.stream()
                .map(Teacher::fromEntity);
    }

}
