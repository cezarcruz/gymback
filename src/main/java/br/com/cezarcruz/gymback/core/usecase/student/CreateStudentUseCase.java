package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveStudentGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateStudentUseCase {

  private final SaveStudentGateway saveStudentGateway;
  private final SaveAddressGateway saveAddressGateway;

  public CreateStudentUseCase(final SaveStudentGateway saveStudentGateway,
      final SaveAddressGateway saveAddressGateway) {
    this.saveStudentGateway = saveStudentGateway;
    this.saveAddressGateway = saveAddressGateway;
  }

  @Transactional
  public Student create(final Student student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var studentWithAddress = student.withAddress(addressSaved);
    return saveStudentGateway.save(studentWithAddress);
  }

}
