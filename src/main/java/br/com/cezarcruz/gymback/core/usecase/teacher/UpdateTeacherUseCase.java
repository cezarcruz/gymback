package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.SaveTeacherGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateTeacherUseCase {

    private final SaveTeacherGateway saveTeacherGateway;

    public Teacher update(final Teacher teacher) {
        return saveTeacherGateway.save(teacher);
    }

}
