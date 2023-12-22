package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetStudentUseCase {

  private final GetStudentGateway getStudentGateway;

  public Stream<Student> findAll() {
    return getStudentGateway.findAll();
  }

}
