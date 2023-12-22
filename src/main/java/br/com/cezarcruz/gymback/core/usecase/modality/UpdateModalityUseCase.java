package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.SaveModalityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateModalityUseCase {

  private final SaveModalityGateway updateModalityGateway;

  public Modality update(final Modality modality) {
    return updateModalityGateway.save(modality);
  }

}
