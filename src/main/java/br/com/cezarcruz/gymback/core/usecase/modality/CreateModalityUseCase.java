package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.SaveModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateModalityUseCase {

  private final SaveModalityGateway saveModalityGateway;

  public Modality create(final Modality modality) {
    return saveModalityGateway.save(modality);
  }

}
