package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.core.exceptions.TeacherNotFountException;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import br.com.gymback.core.gateway.teacher.SaveTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class UpdateTeacherUseCase {

    private final SaveTeacherGateway saveTeacherGateway;
    private final GetTeacherGateway getTeacherGateway;

    public TeacherDomain update(final TeacherDomain teacher) {

        return getTeacherGateway
            .findById(teacher.id())
            .map(t -> t.toBuilder()
                .name(teacher.name())
                .build())
            .map(saveTeacherGateway::save)
            .orElseThrow(() -> new TeacherNotFountException(teacher.id()));
    }

}
