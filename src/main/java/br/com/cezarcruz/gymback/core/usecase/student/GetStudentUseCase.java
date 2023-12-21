package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class GetStudentUseCase {

  private final GetStudentGateway getStudentGateway;

  public GetStudentUseCase(final GetStudentGateway getStudentGateway) {
    this.getStudentGateway = getStudentGateway;
  }

  public Stream<Student> findAll() {
    return getStudentGateway.findAll();
  }

}
