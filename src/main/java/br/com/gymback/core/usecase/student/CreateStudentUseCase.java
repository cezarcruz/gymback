/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.student;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.contact.SaveContactGateway;
import br.com.gymback.core.gateway.student.NotifyStudentGateway;
import br.com.gymback.core.gateway.student.SaveAddressGateway;
import br.com.gymback.core.gateway.student.SaveStudentGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateStudentUseCase {

  private final SaveStudentGateway saveStudentGateway;
  private final SaveAddressGateway saveAddressGateway;
  private final SaveContactGateway saveContactGateway;
  private final NotifyStudentGateway notifyStudentGateway;

  public StudentDomain create(final StudentDomain student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var contacts = saveContactGateway.save(student.contact());
    var studentWithAddress = student.withAddress(addressSaved).withContact(contacts);
    final StudentDomain savedStudent = saveStudentGateway.save(studentWithAddress);
    notifyStudentGateway.notify(savedStudent);
    return savedStudent;
  }
}
