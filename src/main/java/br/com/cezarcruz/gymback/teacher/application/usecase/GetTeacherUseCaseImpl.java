package br.com.cezarcruz.gymback.teacher.application.usecase;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;
import br.com.cezarcruz.gymback.teacher.domain.usecase.GetTeacherUseCase;
import br.com.cezarcruz.gymback.teacher.infra.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class GetTeacherUseCaseImpl implements GetTeacherUseCase {

    private static final Logger log = LoggerFactory.getLogger(GetTeacherUseCaseImpl.class);

    private final TeacherRepository teacherRepository;

    public GetTeacherUseCaseImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Stream<Teacher> getAll() {

        log.info("listing all teachers");

        return teacherRepository.findAll()
                .stream()
                .map(Teacher::fromEntity);
    }

}
