package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.gateway.out.mysql.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public DeleteTeacherUseCase(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void deleteBy(final Long id) {
        teacherRepository.deleteById(id);
    }
}
