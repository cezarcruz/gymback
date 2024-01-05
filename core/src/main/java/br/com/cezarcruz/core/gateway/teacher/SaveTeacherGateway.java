package br.com.cezarcruz.core.gateway.teacher;

import br.com.cezarcruz.core.domain.Teacher;

public interface SaveTeacherGateway {
  Teacher save(final Teacher teacher);
}
