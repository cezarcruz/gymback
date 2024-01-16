package br.com.gymback.core.gateway.student;

import br.com.gymback.core.domain.StudentDomain;

public interface NotifyStudentGateway {
  void notify(final StudentDomain studentDomain);
}
