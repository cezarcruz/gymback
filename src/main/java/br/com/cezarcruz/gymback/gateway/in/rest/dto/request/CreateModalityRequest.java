package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Modality;

public record CreateModalityRequest(
        String name
) {
    public Modality toModality() {
        return new Modality(null, name);
    }
}
