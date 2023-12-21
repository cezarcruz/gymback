package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.persistence.SaveModalityGateway;
import org.springframework.stereotype.Component;

@Component
public class CreateModalityUseCase {

  private final SaveModalityGateway saveModalityGateway;

  public CreateModalityUseCase(final SaveModalityGateway saveModalityGateway) {
    this.saveModalityGateway = saveModalityGateway;
  }


  public Modality create(final Modality modality) {
    return saveModalityGateway.save(modality);
  }

}
