package br.com.cezarcruz.gymback.core.usecase.contract;

import br.com.cezarcruz.gymback.core.domain.ContractDomain;
import br.com.cezarcruz.gymback.core.exceptions.ClassRoomNotFountException;
import br.com.cezarcruz.gymback.core.exceptions.StudentNotFoundException;
import br.com.cezarcruz.gymback.core.usecase.payment.CreatePaymentUseCase;
import br.com.cezarcruz.gymback.gateway.out.gateway.classroom.GetClassRoomGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.contract.SaveContractGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateContractUseCase {

  private final SaveContractGateway saveContractGateway;
  private final GetStudentGateway getStudentGateway;
  private final GetClassRoomGateway getClassRoomGateway;

  private final CreatePaymentUseCase createPaymentUseCase;

  public ContractDomain create(final ContractDomain contract) {

    var student =
        getStudentGateway.findById(contract.getStudent().id())
            .orElseThrow(StudentNotFoundException::new);

    var classRoom =
        getClassRoomGateway.findById(contract.getClassRoom().id())
            .orElseThrow(ClassRoomNotFountException::new);

    var contractToCreatePayments =
        contract
            .withStudent(student)
            .withClassRoom(classRoom)
            .activate();


    var payments = createPaymentUseCase.create(contractToCreatePayments);
    var contractToSave = contractToCreatePayments.withPayments(payments);

    return saveContractGateway.save(contractToSave);
  }

}
