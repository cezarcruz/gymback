package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.core.exceptions.TeacherNotFountException;
import br.com.cezarcruz.gymback.core.gateway.teacher.GetTeacherGateway;
import br.com.cezarcruz.gymback.core.gateway.teacher.SaveTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class UpdateTeacherUseCase {

    private final SaveTeacherGateway saveTeacherGateway;
    private final GetTeacherGateway getTeacherGateway;

    public Teacher update(final Teacher teacher) {

        return getTeacherGateway
            .findById(teacher.id())
            .map(t -> t.toBuilder()
                .name(teacher.name())
                .build())
            .map(saveTeacherGateway::save)
            .orElseThrow(TeacherNotFountException::new);
    }

}