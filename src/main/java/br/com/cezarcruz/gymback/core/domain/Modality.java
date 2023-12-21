package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.gateway.out.mysql.entity.ModalityEntity;

public record Modality(
        Long id,
        String name
) {
    public static Modality fromEntity(final ModalityEntity saved) {
        return new Modality(saved.getId(), saved.getName());
    }

    public ModalityEntity toEntity() {
        final var modalityEntity = new ModalityEntity();
        modalityEntity.setName(name());
        modalityEntity.setId(id());
        return modalityEntity;
    }
}
