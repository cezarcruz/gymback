package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.domain.Teacher;
import br.com.gymback.core.gateway.contact.SaveContactGateway;
import br.com.gymback.core.gateway.teacher.SaveTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateTeacherUseCase {

  private final SaveTeacherGateway saveTeacherGateway;
  private final SaveContactGateway saveContactGateway;


  public Teacher create(final Teacher teacher) {
    var contacts = saveContactGateway.save(teacher.contacts());
    return saveTeacherGateway.save(teacher.withContacts(contacts));
  }

}
