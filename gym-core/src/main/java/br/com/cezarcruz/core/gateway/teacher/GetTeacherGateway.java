package br.com.cezarcruz.core.gateway.teacher;

import br.com.cezarcruz.core.domain.PageDomain;
import br.com.cezarcruz.core.domain.Teacher;
import java.util.Optional;

public interface GetTeacherGateway {
  PageDomain<Teacher> getAll(PageDomain<Teacher> page);

  Optional<Teacher> findById(final String id);
}
