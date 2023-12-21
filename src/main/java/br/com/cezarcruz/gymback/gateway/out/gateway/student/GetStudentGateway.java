package br.com.cezarcruz.gymback.gateway.out.gateway.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import java.util.stream.Stream;

public interface GetStudentGateway {
  Stream<Student> findAll();
}
