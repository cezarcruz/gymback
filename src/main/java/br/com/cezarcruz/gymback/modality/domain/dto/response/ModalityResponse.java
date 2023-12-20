package br.com.cezarcruz.gymback.modality.domain.dto.response;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;

public record ModalityResponse(
        Long id,
        String name
) {
    public static ModalityResponse from(final Modality createdModality) {
        return new ModalityResponse(createdModality.id(), createdModality.name());
    }
}
