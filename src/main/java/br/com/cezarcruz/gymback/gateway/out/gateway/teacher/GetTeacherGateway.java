package br.com.cezarcruz.gymback.gateway.out.gateway.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import java.util.Optional;
import java.util.stream.Stream;

public interface GetTeacherGateway {
  Stream<Teacher> getAll();

  Optional<Teacher> findById(final String id);
}
