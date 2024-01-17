/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.student;

import br.com.gymback.core.domain.StudentDomain;

public interface NotifyStudentGateway {
  void notify(final StudentDomain studentDomain);
}
