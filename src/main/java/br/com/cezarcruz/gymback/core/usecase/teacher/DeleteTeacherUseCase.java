package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.gateway.out.teacher.DeleteTeacherGateway;
import org.springframework.stereotype.Component;

@Component
public class DeleteTeacherUseCase {

    private final DeleteTeacherGateway teacherGateway;

    public DeleteTeacherUseCase(final DeleteTeacherGateway teacherGateway) {
        this.teacherGateway = teacherGateway;
    }

    public void deleteBy(final Long id) {
        teacherGateway.deleteTeacher(id);
    }
}
