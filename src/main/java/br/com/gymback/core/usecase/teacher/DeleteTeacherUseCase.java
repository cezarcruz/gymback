/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.gateway.teacher.DeleteTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DeleteTeacherUseCase {

  private final DeleteTeacherGateway teacherGateway;

  public void deleteBy(final Long id) {
    teacherGateway.deleteTeacher(id);
  }
}
