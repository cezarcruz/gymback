/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.gateway.teacher.DeleteTeacherGateway;
import jakarta.inject.Named;

@Named
public class DeleteTeacherUseCase {

  private final DeleteTeacherGateway teacherGateway;

  public DeleteTeacherUseCase(DeleteTeacherGateway teacherGateway) {
    this.teacherGateway = teacherGateway;
  }

  public void deleteBy(final Long id) {
    teacherGateway.deleteTeacher(id);
  }
}
