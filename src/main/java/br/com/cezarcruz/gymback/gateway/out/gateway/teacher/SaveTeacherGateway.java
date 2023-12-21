package br.com.cezarcruz.gymback.gateway.out.gateway.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;

public interface SaveTeacherGateway {
  Teacher save(final Teacher teacher);
}
