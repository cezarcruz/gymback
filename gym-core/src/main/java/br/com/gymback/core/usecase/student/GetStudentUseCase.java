package br.com.gymback.core.usecase.student;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.student.GetStudentGateway;
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