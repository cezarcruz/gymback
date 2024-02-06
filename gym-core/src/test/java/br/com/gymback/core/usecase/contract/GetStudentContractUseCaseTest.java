/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.contract;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.gymback.core.exceptions.ContractNotFoundException;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetStudentContractUseCaseTest {

  @Mock private GetContractGateway getContractGateway;

  @InjectMocks private GetStudentContractUseCase getStudentContractUseCase;

  @Test
  void shouldGetEmptyStudentById() {

    when(getContractGateway.getByStudentId(1L)).thenReturn(Optional.empty());

    assertThrows(
        ContractNotFoundException.class,
        () -> {
          getStudentContractUseCase.getBy(1L);
        });

    verify(getContractGateway).getByStudentId(1L);
  }
}
