package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.mysql.TeacherRepository;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GetTeacherUseCase {

    private static final Logger log = LoggerFactory.getLogger(GetTeacherUseCase.class);

    private final TeacherRepository teacherRepository;

    public GetTeacherUseCase(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Stream<Teacher> getAll() {

        log.info("listing all teachers");

        return teacherRepository.findAll()
                .stream()
                .map(Teacher::fromEntity);
    }

}
