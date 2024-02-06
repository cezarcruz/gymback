/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.modality;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import br.com.gymback.core.gateway.modality.DeleteModalityGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteModalityUseCaseTest {

  @Mock private DeleteModalityGateway deleteModalityGateway;

  @InjectMocks private DeleteModalityUseCase deleteModalityUseCase;

  @Test
  void shouldDeleteModality() {
    deleteModalityUseCase.deleteBy(1L);

    verify(deleteModalityGateway).deleteById(1L);
  }
}
