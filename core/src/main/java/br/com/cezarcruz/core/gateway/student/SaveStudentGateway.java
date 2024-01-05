package br.com.cezarcruz.core.gateway.student;

import br.com.cezarcruz.core.domain.StudentDomain;

public interface SaveStudentGateway {
  StudentDomain save(final StudentDomain student);
}
