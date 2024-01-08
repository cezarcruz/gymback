package br.com.gymback.core.gateway.student;

import br.com.gymback.core.domain.StudentDomain;

public interface SaveStudentGateway {
  StudentDomain save(final StudentDomain student);
}
