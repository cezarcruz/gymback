package br.com.cezarcruz.gymback.modality.domain.dto.request;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;

public record CreateModalityRequest(
        String name
) {
    public Modality toModality() {
        return new Modality(null, name);
    }
}
