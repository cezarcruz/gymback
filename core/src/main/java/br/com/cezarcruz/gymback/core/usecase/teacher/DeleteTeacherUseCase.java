package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.gateway.teacher.DeleteTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DeleteTeacherUseCase {

    private final DeleteTeacherGateway teacherGateway;

    public void deleteBy(final String id) {
        teacherGateway.deleteTeacher(id);
    }
}
