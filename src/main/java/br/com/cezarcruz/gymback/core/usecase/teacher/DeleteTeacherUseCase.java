package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.DeleteTeacherGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteTeacherUseCase {

    private final DeleteTeacherGateway teacherGateway;

    public void deleteBy(final String id) {
        teacherGateway.deleteTeacher(id);
    }
}
