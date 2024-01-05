package br.com.cezarcruz.core.usecase.student;

import br.com.cezarcruz.core.domain.StudentDomain;
import br.com.cezarcruz.core.gateway.contact.SaveContactGateway;
import br.com.cezarcruz.core.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.core.gateway.student.SaveStudentGateway;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateStudentUseCase {

  private final SaveStudentGateway saveStudentGateway;
  private final SaveAddressGateway saveAddressGateway;
  private final SaveContactGateway saveContactGateway;

  @Transactional
  public StudentDomain create(final StudentDomain student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var contacts = saveContactGateway.save(student.contacts());
    var studentWithAddress = student.withAddress(addressSaved).withContacts(contacts);
    return saveStudentGateway.save(studentWithAddress);
  }

}
