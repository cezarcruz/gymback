package br.com.gymback.core.usecase.modality;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetModalityUseCaseTest {

  @Mock
  private GetModalityGateway getModalityGateway;

  @InjectMocks
  private GetModalityUseCase getModalityUseCase;

  @Test
  void shouldGetAll() {
    final var pageDomain = PageDomain.<ModalityDomain>builder().build();

    when(getModalityGateway.findAll(pageDomain)).thenReturn(pageDomain);

    final var all = getModalityUseCase.findAll(pageDomain);

    assertNotNull(all);

    verify(getModalityGateway).findAll(pageDomain);
  }

}