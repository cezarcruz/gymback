package br.com.cezarcruz.gymback.core.gateway.student;

import br.com.cezarcruz.gymback.core.domain.StudentDomain;

public interface SaveStudentGateway {
  StudentDomain save(final StudentDomain student);
}
