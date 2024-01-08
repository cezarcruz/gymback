package br.com.gymback.core.gateway.teacher;

import br.com.gymback.core.domain.Teacher;

public interface SaveTeacherGateway {
  Teacher save(final Teacher teacher);
}
