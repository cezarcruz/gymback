package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.persistence.UpdateModalityGateway;
import org.springframework.stereotype.Component;

@Component
public class UpdateModalityUseCase {

  private final UpdateModalityGateway updateModalityGateway;

  public UpdateModalityUseCase(final UpdateModalityGateway updateModalityGateway) {
    this.updateModalityGateway = updateModalityGateway;
  }

  public Modality update(final Modality modality) {
    return updateModalityGateway.update(modality);
  }

}
