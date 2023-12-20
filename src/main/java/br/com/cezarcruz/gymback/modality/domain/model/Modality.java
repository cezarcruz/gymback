package br.com.cezarcruz.gymback.modality.domain.model;

import br.com.cezarcruz.gymback.modality.domain.entity.ModalityEntity;

public record Modality(
        Long id,
        String name
) {
    public static Modality fromEntity(final ModalityEntity saved) {
        return new Modality(saved.getId(), saved.getName());
    }

    public ModalityEntity toEntity() {
        final var modalityEntity = new ModalityEntity();
        modalityEntity.setName(name);
        return modalityEntity;
    }
}
