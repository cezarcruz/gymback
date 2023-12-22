package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.SaveModalityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateModalityUseCase {

  private final SaveModalityGateway saveModalityGateway;

  public Modality create(final Modality modality) {
    return saveModalityGateway.save(modality);
  }

}
