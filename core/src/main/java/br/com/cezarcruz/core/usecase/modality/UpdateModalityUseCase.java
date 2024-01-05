package br.com.cezarcruz.core.usecase.modality;

import br.com.cezarcruz.core.domain.ModalityDomain;
import br.com.cezarcruz.core.gateway.modality.SaveModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class UpdateModalityUseCase {

  private final SaveModalityGateway updateModalityGateway;

  public ModalityDomain update(final ModalityDomain modality) {
    return updateModalityGateway.save(modality);
  }

}
