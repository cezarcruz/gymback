/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.core.gateway.contact.SaveContactGateway;
import br.com.gymback.core.gateway.teacher.SaveTeacherGateway;
import jakarta.inject.Named;

@Named
public class CreateTeacherUseCase {

  private final SaveTeacherGateway saveTeacherGateway;
  private final SaveContactGateway saveContactGateway;

  public CreateTeacherUseCase(final SaveTeacherGateway saveTeacherGateway,
      final SaveContactGateway saveContactGateway) {
    this.saveTeacherGateway = saveTeacherGateway;
    this.saveContactGateway = saveContactGateway;
  }

  public TeacherDomain create(final TeacherDomain teacher) {
    var contacts = saveContactGateway.save(teacher.contact());
    return saveTeacherGateway.save(teacher.withContact(contacts));
  }
}
