package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import br.com.cezarcruz.gymback.core.gateway.modality.SaveModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateModalityUseCase {

  private final SaveModalityGateway saveModalityGateway;

  public ModalityDomain create(final ModalityDomain modality) {
    return saveModalityGateway.save(modality);
  }

}