package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.SaveTeacherGateway;
import org.springframework.stereotype.Component;

@Component
public class CreateTeacherUseCase {

  private final SaveTeacherGateway saveTeacherGateway;

  public CreateTeacherUseCase(final SaveTeacherGateway saveTeacherGateway) {
    this.saveTeacherGateway = saveTeacherGateway;
  }

  public Teacher create(final Teacher teacher) {
    return saveTeacherGateway.save(teacher);
  }

}
