package br.com.cezarcruz.gymback.core.usecase.student;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveAddressGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveStudentGateway;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateStudentUseCase {

  private final SaveStudentGateway saveStudentGateway;
  private final SaveAddressGateway saveAddressGateway;

  @Transactional
  public Student create(final Student student) {
    var addressSaved = saveAddressGateway.save(student.address());
    var studentWithAddress = student.withAddress(addressSaved);
    return saveStudentGateway.save(studentWithAddress);
  }

}
