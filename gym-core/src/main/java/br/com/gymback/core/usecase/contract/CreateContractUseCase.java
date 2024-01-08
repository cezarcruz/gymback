package br.com.gymback.core.usecase.contract;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.exceptions.ClassRoomNotFountException;
import br.com.gymback.core.exceptions.StudentNotFoundException;
import br.com.gymback.core.usecase.payment.CreatePaymentUseCase;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import br.com.gymback.core.gateway.contract.SaveContractGateway;
import br.com.gymback.core.gateway.student.GetStudentGateway;
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
            .orElseThrow(() -> new StudentNotFoundException(contract.getStudent().id()));

    var classRoom =
        getClassRoomGateway.findById(contract.getClassRoom().id())
            .orElseThrow(() -> new ClassRoomNotFountException(contract.getClassRoom().id()));

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
