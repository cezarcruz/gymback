package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Modality;
import jakarta.validation.constraints.NotNull;

public record UpdateModalityRequest(
    @NotNull
    String name
) {

  public Modality toModality(final Long id) {
    return new Modality(id, name());
  }
}
