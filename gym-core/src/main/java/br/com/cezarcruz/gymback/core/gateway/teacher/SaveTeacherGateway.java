package br.com.cezarcruz.gymback.core.gateway.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;

public interface SaveTeacherGateway {
  Teacher save(final Teacher teacher);
}
