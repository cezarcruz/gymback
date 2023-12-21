package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.modality.SaveModalityGateway;
import org.springframework.stereotype.Component;

@Component
public class UpdateModalityUseCase {

  private final SaveModalityGateway updateModalityGateway;

  public UpdateModalityUseCase(final SaveModalityGateway updateModalityGateway) {
    this.updateModalityGateway = updateModalityGateway;
  }

  public Modality update(final Modality modality) {
    return updateModalityGateway.save(modality);
  }

}
