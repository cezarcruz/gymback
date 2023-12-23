package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.SaveTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateTeacherUseCase {

  private final SaveTeacherGateway saveTeacherGateway;

  public Teacher create(final Teacher teacher) {
    return saveTeacherGateway.save(teacher);
  }

}
