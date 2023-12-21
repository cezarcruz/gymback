package br.com.cezarcruz.gymback.modality.domain.dto.request;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;
import jakarta.validation.constraints.NotNull;

public record UpdateModalityRequest(
    @NotNull
    String name
) {

  public Modality toModality(final Long id) {
    return new Modality(id, name());
  }
}
