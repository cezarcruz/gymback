/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.modality;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.gateway.modality.SaveModalityGateway;
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
