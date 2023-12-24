package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.contact.SaveContactGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveStudentGateway;
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
  public Student create(final Student student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var contacts = saveContactGateway.save(student.contacts());
    var studentWithAddress = student.withAddress(addressSaved).withContacts(contacts);
    return saveStudentGateway.save(studentWithAddress);
  }

}
