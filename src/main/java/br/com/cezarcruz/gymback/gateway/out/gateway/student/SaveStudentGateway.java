package br.com.cezarcruz.gymback.gateway.out.gateway.student;

import br.com.cezarcruz.gymback.core.domain.Student;

public interface SaveStudentGateway {
  Student save(final Student student);
}
