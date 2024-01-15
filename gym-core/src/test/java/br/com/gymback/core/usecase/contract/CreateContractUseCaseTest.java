package br.com.gymback.core.usecase.contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import br.com.gymback.core.fixtures.ClassRoomFixtures;
import br.com.gymback.core.fixtures.ContractFixtures;
import br.com.gymback.core.fixtures.PaymentFixture;
import br.com.gymback.core.fixtures.StudentFixture;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import br.com.gymback.core.gateway.contract.SaveContractGateway;
import br.com.gymback.core.gateway.student.GetStudentGateway;
import br.com.gymback.core.usecase.payment.CreatePaymentUseCase;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateContractUseCaseTest {

  @Mock private SaveContractGateway saveContractGateway;
  @Mock private GetStudentGateway getStudentGateway;
  @Mock private GetClassRoomGateway getClassRoomGateway;
  @Mock private CreatePaymentUseCase createPaymentUseCase;

  @InjectMocks
  private CreateContractUseCase createContractUseCase;

  @Test
  void shouldCreateAContract() {
    final var contract = ContractFixtures.getContract();
    final var student = StudentFixture.getStudent();
    final var classRoom = ClassRoomFixtures.getClassRoom();
    final var payment = PaymentFixture.getPayment();

    when(getStudentGateway.findById(contract.getStudent().id()))
        .thenReturn(Optional.of(student));

    when(getClassRoomGateway.findById(contract.getClassRoom().id()))
        .thenReturn(Optional.of(classRoom));

    when(createPaymentUseCase.create(any()))
        .thenReturn(List.of(payment));

    when(saveContractGateway.save(any()))
        .thenAnswer(a -> a.getArgument(0));

    final var contractDomain = createContractUseCase.create(contract);

    assertNotNull(contractDomain);

    assertEquals(contractDomain.contractMonths(), contract.contractMonths());
    assertNotNull(contractDomain.getClassRoom());
    assertEquals(classRoom.name(), contractDomain.getClassRoom().name());

    assertNotNull(contractDomain.getStudent());
    assertEquals(student.name(), contractDomain.getStudent().name());


    assertNotNull(contractDomain.getPayments());
    assertEquals(1, contractDomain.getPayments().size());

  }

}