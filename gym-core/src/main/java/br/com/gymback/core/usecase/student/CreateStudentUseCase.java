package br.com.gymback.core.usecase.student;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.contact.SaveContactGateway;
import br.com.gymback.core.gateway.student.SaveAddressGateway;
import br.com.gymback.core.gateway.student.SaveStudentGateway;
import jakarta.inject.Named;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateStudentUseCase {

  private final SaveStudentGateway saveStudentGateway;
  private final SaveAddressGateway saveAddressGateway;
  private final SaveContactGateway saveContactGateway;

  //@Transactional work on that
  public StudentDomain create(final StudentDomain student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var contacts = saveContactGateway.save(student.contacts());
    var studentWithAddress = student.withAddress(addressSaved).withContacts(contacts);
    return saveStudentGateway.save(studentWithAddress);
  }

}
