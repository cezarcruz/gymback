package br.com.cezarcruz.gymback.gateway.out.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import java.util.stream.Stream;

public interface GetTeacherGateway {
  Stream<Teacher> getAll();
}
