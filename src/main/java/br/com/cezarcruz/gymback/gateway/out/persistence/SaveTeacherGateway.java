package br.com.cezarcruz.gymback.gateway.out.persistence;

import br.com.cezarcruz.gymback.core.domain.Teacher;

public interface SaveTeacherGateway {
  Teacher save(final Teacher teacher);
}
