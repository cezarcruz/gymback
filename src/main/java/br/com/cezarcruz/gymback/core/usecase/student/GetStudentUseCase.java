package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.StudentDomain;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import jakarta.inject.Named;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetStudentUseCase {

  private final GetStudentGateway getStudentGateway;

  public Stream<StudentDomain> findAll() {
    return getStudentGateway.findAll();
  }

}
