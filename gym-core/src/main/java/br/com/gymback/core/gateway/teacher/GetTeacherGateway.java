package br.com.gymback.core.gateway.teacher;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.TeacherDomain;
import java.util.Optional;

public interface GetTeacherGateway {
  PageDomain<TeacherDomain> getAll(PageDomain<TeacherDomain> page);

  Optional<TeacherDomain> findById(final String id);
}
