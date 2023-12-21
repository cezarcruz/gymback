package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import br.com.cezarcruz.gymback.core.domain.Modality;

public record ModalityResponse(
        Long id,
        String name
) {
    public static ModalityResponse from(final Modality createdModality) {
        return new ModalityResponse(createdModality.id(), createdModality.name());
    }
}
